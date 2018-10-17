package org.yhwang.csye6225.courseservice5.datamodel;

import java.util.*;

public class InMemoryDatabase {
    private static HashMap<Long, Professor> professorDB = new HashMap<>();
    private static HashMap<Long, Student> studentDB = new HashMap<>();
    private static HashMap<String, Course> courseDB = new HashMap<>();
    private static HashMap<String, Program> programDB = new HashMap<>();
    private static HashMap<String, Lecture> lectureDB = new HashMap<>();

    public static HashMap<Long, Professor> getProfessorDB() {
        return professorDB;
    }

    public static HashMap<Long, Student> getStudentDB() {
        return studentDB;
    }

    public static HashMap<String, Course> getCourseDB() {
        return courseDB;
    }

    public static HashMap<String, Program> programDB() { return programDB; }

    public static HashMap<String, Lecture> lectureDB() { return lectureDB; }
}
