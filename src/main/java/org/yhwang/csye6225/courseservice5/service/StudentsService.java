package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.TableCollection;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import javafx.scene.image.Image;
import org.yhwang.csye6225.courseservice5.datamodel.*;

import org.yhwang.csye6225.courseservice5.SNS.*;
import org.yhwang.csye6225.courseservice5.service.CoursesService;


import java.util.*;

public class StudentsService {
    //InMemoryDatabase db = InMemoryDatabase.getInstance();
    //HashMap<String, Student> stu_Map = db.getStudentDB();

    DynamoDBConnector dynamoDBConnector = DynamoDBConnector.getInstance();
    AmazonDynamoDB client = dynamoDBConnector.getClient();
    DynamoDBMapper dynamoDBMapper;
    //DynamoDB dynamoDB;
    DynamoDBScanExpression dynamoDBScanExpression;

    SNSClientConnector snsClientConnector = SNSClientConnector.getInstance();
    CoursesService coursesService = new CoursesService();

    public StudentsService() {
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    //getting a list of all students
    //GET "..webapi/students"
    public List<Student> getAllStudents() {
        //return new ArrayList<>(stu_Map.values());
        dynamoDBScanExpression = new DynamoDBScanExpression();
        List<Student> students = dynamoDBMapper.scan(Student.class, dynamoDBScanExpression);
        System.out.println(students);
        return students;
    }

    //adding a student
    public Student addStudent(Student student) {
        dynamoDBMapper.save(student);
        return student;
    }

    //getting one student
    public List<Student> getStudent(String stuId) {
        List<Student> students = queryStudents(stuId);
        System.out.println("Item retrieved:");
        for (Student s : students) {
            System.out.println(s.toString());
        }
        return students;

    }

    //deleting a student
    public List<Student> deleteStudent(String stuId) {
        List<Student> deletedStudents = queryStudents(stuId);
        if (deletedStudents == null) {
            System.out.println("The student need to be deleted does not exists");
        } else {
            for (Student s : deletedStudents) {
                dynamoDBMapper.delete(s);
            }
        }

        return deletedStudents;
    }

    //updating student info
    public List<Student> updateStudentInformation(String stuId, Student stu) {
        List<Student> students = queryStudents(stuId);
        if (students == null) {
            System.out.println("The student need to be updated does not exists");
            return null;
        } else {
            for (Student s : students) {
                dynamoDBMapper.delete(s);
            }
            dynamoDBMapper.save(stu);
        }
        return queryStudents(stuId);
    }

    private List<Student> queryStudents(String stuId) {
        Student myStudent= new Student();
        myStudent.setStudentId(stuId);
        DynamoDBQueryExpression<Student> queryExpression = new DynamoDBQueryExpression<>();
        queryExpression.setHashKeyValues(myStudent);
        queryExpression.withIndexName("studentId-index");
        queryExpression.setConsistentRead(false);//https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/HowItWorks.ReadConsistency.html
        List<Student> students = dynamoDBMapper.query(Student.class, queryExpression);
        return students;
    }

    public List<Course> registerCourses(String stuId, List<Course> courses) {
        List<Student> students = queryStudents(stuId);
        if (students.size() != 0) {
            for (Student student : students) {
                dynamoDBMapper.delete(student);
                for (Course course : courses) {
                    String topic = course.getNotificationTopic();
                    if (!getAllCourseTopics().contains(topic)) {
                        snsClientConnector.createTopic(course);
                    }
                    snsClientConnector.subscribeTopic(course, student);
                    student.getRegisteredCourses().add(course.getCourseId());
                    course.getEnrolledStudent().add(student.getEmail());
                }
                dynamoDBMapper.save(student);
            }
            return courses;
        } else {
            return null;
        }

    }

    public List<String> getAllCourseTopics() {
        List<String> courseTopics = new ArrayList<>();
        List<Course> courses = coursesService.getAllCourses();
        for (Course course : courses) {
            //System.out.println(course.getNotificationTopic());
            courseTopics.add(course.getNotificationTopic());
        }
        return courseTopics;
    }
}
