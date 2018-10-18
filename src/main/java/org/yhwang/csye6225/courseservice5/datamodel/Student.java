package org.yhwang.csye6225.courseservice5.datamodel;

import com.amazonaws.services.dynamodbv2.xspec.S;
import javafx.scene.image.Image;

import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

@XmlRootElement
public class Student {
    private String name;
    private long studentId;
    private Image image;
    private List<Course> courses;
    private String programName;

    public Student() {

    }

    public Student(String name, long studentId, String programName) {
        this.name = name;
        this.studentId = studentId;
        this.programName = programName;
    }

    public Student(String name, long studentId, List<Course> courses, String programName) {
        this.name = name;
        this.studentId = studentId;
        this.image = null;
        this.courses = courses;
        this.programName = programName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getProgramName() {
        return programName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }
}
