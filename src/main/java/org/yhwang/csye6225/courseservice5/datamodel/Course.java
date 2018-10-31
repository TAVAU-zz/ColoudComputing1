package org.yhwang.csye6225.courseservice5.datamodel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
@DynamoDBTable(tableName ="course")
public class Course {
    private String courseId;
    private String courseName;
    private List<Lecture> lectures;
    private String board;
    private String roster;
    private List<String> enrolledStudent;
    private String TA;
    private String associatedProfessor;

    public Course(){}

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.lectures = null;
        this.board = null;
        this.roster = null;
        this.enrolledStudent = null;
        this.TA = null;
        this.associatedProfessor = null;
    }

    @DynamoDBHashKey(attributeName = "courseId")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @DynamoDBAttribute(attributeName = "courseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @DynamoDBAttribute(attributeName = "lectures")
    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    @DynamoDBAttribute(attributeName = "board")
    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    @DynamoDBIgnore
    public String getRoster() {
        return roster;
    }

    public void setRoster(String roster) {
        this.roster = roster;
    }

    @DynamoDBAttribute(attributeName = "enrolledStudent")
    public List<String> getEnrolledStudent() {
        return enrolledStudent;
    }

    public void setEnrolledStudent(List<String> enrolledStudent) {
        this.enrolledStudent = enrolledStudent;
    }

    @DynamoDBAttribute(attributeName = "TA")
    public String getTA() {
        return TA;
    }

    public void setTA(String TA) {
        this.TA = TA;
    }

    @DynamoDBAttribute(attributeName = "associatedProfessor")
    public String getAssociatedProfessor() {
        return associatedProfessor;
    }

    public void setAssociatedProfessor(String associatedProfessor) {
        this.associatedProfessor = associatedProfessor;
    }
}
