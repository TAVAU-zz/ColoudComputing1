package org.yhwang.csye6225.courseservice5.datamodel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement//map a class to xml
public class Professor {

    private String department;
    private long professorId;
    private Date joiningDate;
    private String firstName;
    private List<Course> courses;

    public Professor() {
        //internal proccess for xml
    }

    public Professor(String department, long professorId, Date joiningDate, String firstName) {
        this.department = department;
        this.professorId = professorId;
        this.joiningDate = joiningDate;
        this.firstName = firstName;
    }

    public Professor(String department, long professorId, Date joiningDate, String firstName, List<Course> courses) {
        this.department = department;
        this.professorId = professorId;
        this.joiningDate = joiningDate;
        this.firstName = firstName;
        this.courses = courses;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(long professorId) {
        this.professorId = professorId;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
