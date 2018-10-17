package org.yhwang.csye6225.courseservice5.datamodel;
import java.util.*;

public class Course {
    private String courseId;
    private Lecture lectures;
    private String board;
    private String roster;
    private List<Student> enrolledStudent;
    private Student TA;
    private Professor associatedProfessor;

    public Course(){}

    public Course(String courseId) {
        this.courseId = courseId;
        this.lectures = null;
        this.board = null;
        this.roster = null;
        this.enrolledStudent = null;
        this.TA = null;
        this.associatedProfessor = null;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public Lecture getLectures() {
        return lectures;
    }

    public void setLectures(Lecture lectures) {
        this.lectures = lectures;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getRoster() {
        return roster;
    }

    public void setRoster(String roster) {
        this.roster = roster;
    }

    public List<Student> getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(List<Student> enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }

    public Student getTA() {
        return TA;
    }

    public void setTA(Student TA) {
        this.TA = TA;
    }

    public Professor getAssociatedProfessor() {
        return associatedProfessor;
    }

    public void setAssociatedProfessor(Professor associatedProfessor) {
        this.associatedProfessor = associatedProfessor;
    }
}
