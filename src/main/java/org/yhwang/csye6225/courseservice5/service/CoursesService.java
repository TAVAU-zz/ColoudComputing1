package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.yhwang.csye6225.courseservice5.datamodel.*;

import java.util.*;

public class CoursesService {
    InMemoryDatabase db = InMemoryDatabase.getInstance();
    HashMap<String, Course> course_Map = db.getCourseDB();

    DynamoDBConnector dynamoDBConnector = DynamoDBConnector.getInstance();
    AmazonDynamoDB client = dynamoDBConnector.getClient();
    DynamoDBMapper dynamoDBMapper;
    DynamoDBScanExpression dynamoDBScanExpression;


    public CoursesService() {
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    //getting a list of courses
    //GET "..webapi/courses"
    public List<Course> getAllCourses() {
        dynamoDBScanExpression = new DynamoDBScanExpression();
        List<Course> courses = dynamoDBMapper.scan(Course.class, dynamoDBScanExpression);
        return courses;
    }

    //add course by id
    public Course addCourse(Course course){
        //DynamoDBQueryExpression<Course> query = new DynamoDBQueryExpression<Course>().withHashKeyValues(course);
        //List<Course> queriedCourses = dynamoDBMapper.query(Course.class, query);

        dynamoDBMapper.save(course);
        return course;
    }

    //getting one course
    public Course getCourse(String courseId) {
        //return course_Map.get(courseId);
        return dynamoDBMapper.load(Course.class, courseId);
    }

    //deleting a course
    public Course deleteCourse(String courseId) {
//        Course deletedCourseDetails = course_Map.get(courseId);
//        course_Map.remove(courseId);
//        return deletedCourseDetails;
        Course deletedCourse = dynamoDBMapper.load(Course.class, courseId);
        dynamoDBMapper.delete(deletedCourse);
        return deletedCourse;
    }

    //updating course info
    public Course updateCourseInformation(String courseId, Course course) {
//        Course oldCourseObj = course_Map.get(courseId);
//        courseId = oldCourseObj.getCourseId();
//        course.setCourseId(courseId);
//        course_Map.put(courseId, course);
//        return course;
        Course oldCourse = dynamoDBMapper.load(Course.class, courseId);
        dynamoDBMapper.delete(oldCourse);
        dynamoDBMapper.save(course);
        return course;
    }

    //get course in a department
    public List<Course> getCoursesByTA(String studentName) {
        List<Course> list = new ArrayList<>();
        for (Map.Entry<String, Course> entry: course_Map.entrySet()) {
            if (entry.getValue().getTA() == studentName) {
                list.add(entry.getValue());
            }
        }
        return list;
    }
    //
}
