package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.yhwang.csye6225.courseservice5.datamodel.*;

import java.util.*;

public class CoursesService {
    //InMemoryDatabase db = InMemoryDatabase.getInstance();
    //HashMap<String, Course> course_Map = db.getCourseDB();

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
    public List<Course> getCourse(String courseId) {
        Course myCourse= new Course();
        myCourse.setCourseId(courseId);
        DynamoDBQueryExpression<Course> queryExpression = new DynamoDBQueryExpression<>();
        queryExpression.setHashKeyValues(myCourse);
        queryExpression.withIndexName("courseId-index");
        queryExpression.setConsistentRead(false);
        List<Course> courses = dynamoDBMapper.query(Course.class, queryExpression);

        System.out.println("Item retrieved:");
        for (Course c : courses) {
            System.out.println(c.toString());
        }

        return courses;
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

}
