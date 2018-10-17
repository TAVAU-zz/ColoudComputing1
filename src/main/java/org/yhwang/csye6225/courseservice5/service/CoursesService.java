package org.yhwang.csye6225.courseservice5.service;

import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.InMemoryDatabase;
import org.yhwang.csye6225.courseservice5.datamodel.Professor;
import org.yhwang.csye6225.courseservice5.datamodel.Student;

import java.util.*;

public class CoursesService {
    static HashMap<String, Course> course_Map = InMemoryDatabase.getCourseDB();

    //getting a list of courses
    //GET "..webapi/courses"
    public List<Course> getAllCourses() {
        return new ArrayList<>(course_Map.values());
    }

    //adding a course
    public Course addCourse(String courseId) {
        //create a course obj
        Course course = new Course(courseId);
        course_Map.put(courseId, course);
        return course_Map.get(courseId);
    }

    public Course addCourse(String courseId, Professor pro) {
        Course course = new Course(courseId);
        course.setAssociatedProfessor(pro);
        return course_Map.put(courseId, course);
    }

    //getting one course
    public Course getCourse(String courseId) {
        return course_Map.get(courseId);
    }

    //deleting a course
    public Course deleteCourse(String courseId) {
        Course deletedCourseDetails = course_Map.get(courseId);
        course_Map.remove(courseId);
        return deletedCourseDetails;
    }

    //updating course info
    public Course updateCourseInformation(String courseId, Course course) {
        Course oldCourseObj = course_Map.get(courseId);
        courseId = oldCourseObj.getCourseId();
        course.setCourseId(courseId);
        //publishing new values
        course_Map.put(courseId, course);
        return course;
    }

    //get course in a department
    public List<Course> getCoursesByTA(String studentName) {
        List<Course> list = new ArrayList<>();
        for (Map.Entry<String, Course> entry: course_Map.entrySet()) {
            if (entry.getValue().getTA().getName() == studentName) {
                list.add(entry.getValue());
            }
        }
        return list;
    }
    //
}
