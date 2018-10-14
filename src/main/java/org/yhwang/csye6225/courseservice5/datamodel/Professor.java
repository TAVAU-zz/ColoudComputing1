package org.yhwang.csye6225.courseservice5.datamodel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement//map a class to xml
public class Professor {

    private String department;
    private long professorId;
    private Date joiningDate;
    private String firstName;

    public Professor() {
        //internal proccess for xml
    }

    public Professor(String department, long professorId, Date joiningDate, String firstName) {
        this.department = department;
        this.professorId = professorId;
        this.joiningDate = joiningDate;
        this.firstName = firstName;
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
}
