package org.yhwang.csye6225.courseservice5.service;

import org.yhwang.csye6225.courseservice5.datamodel.*;

import java.util.*;

public class CoursesService {
    //public static ProgramService programService = ProgramService.getInstance();
    InMemoryDatabase db = InMemoryDatabase.getInstance();
    HashMap<String, Course> course_Map = db.getCourseDB();

    public CoursesService() {

    }

    //getting a list of courses
    //GET "..webapi/courses"
    public List<Course> getAllCourses() {
        return new ArrayList<>(course_Map.values());
    }

    //add course by id
    public Course addCourse(Course course){
        return course_Map.put(course.getCourseId(),course);
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
