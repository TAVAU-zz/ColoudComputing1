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
        dynamoDBMapper.save(course);
        return course;
    }

    //getting one course
    public List<Course> getCourse(String courseId) {
        List<Course> courses = queryCourses(courseId);

        System.out.println("Item retrieved:");
        for (Course c : courses) {
            System.out.println(c.toString());
        }

        return courses;
    }

    //deleting a course
    public List<Course> deleteCourse(String courseId) {
        List<Course> deletedCourses = queryCourses(courseId);
        System.out.println("courses deleted: ");
        for (Course c : deletedCourses) {
            System.out.println(c);
            dynamoDBMapper.delete(c);
        }
        return deletedCourses;
    }

    //updating course info
    public List<Course> updateCourseInformation(String courseId, Course course) {
        List<Course> queryResult = queryCourses(courseId);
        if (queryResult == null) {
            System.out.println("Course need to be updated does not exists");
            return null;
        } else {
            for (Course c : queryResult) {
                dynamoDBMapper.delete(c);
            }
            dynamoDBMapper.save(course);
        }
        return queryCourses(courseId);
    }

    /**
     * query a list of courses according to specific courseId
     * @param courseId Global Secondary Index
     * @return list of query result of the courses
     */
    private List<Course> queryCourses(String courseId) {
        Course myCourse= new Course();
        myCourse.setCourseId(courseId);
        DynamoDBQueryExpression<Course> queryExpression = new DynamoDBQueryExpression<>();
        queryExpression.setHashKeyValues(myCourse);
        queryExpression.withIndexName("courseId-index");
        queryExpression.setConsistentRead(false);
        List<Course> courses = dynamoDBMapper.query(Course.class, queryExpression);
        return courses;
    }
}
