package org.yhwang.csye6225.courseservice5.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement//map a class to xml
@DynamoDBTable(tableName ="professor")
public class Professor {

    private String department;
    private String professorId;
    private String joiningDate;
    private String firstName;
    private List<String> courses;

    public Professor() {
        //internal proccess for xml
    }

    public Professor(String department, String professorId, String joiningDate, String firstName) {
        this.department = department;
        this.professorId = professorId;
        this.joiningDate = joiningDate;
        this.firstName = firstName;
    }

    public Professor(String department, String professorId, String joiningDate, String firstName, List<String> courses) {
        this.department = department;
        this.professorId = professorId;
        this.joiningDate = joiningDate;
        this.firstName = firstName;
        this.courses = courses;
    }

    @DynamoDBAttribute(attributeName = "department")
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @DynamoDBHashKey(attributeName = "professorId")
    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    @DynamoDBAttribute(attributeName = "joiningDate")
    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    @DynamoDBAttribute(attributeName = "firstName")
    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DynamoDBIgnore
    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @DynamoDBIgnore
    @Override
    public String toString() {
        return "Professor{" +
                "department='" + department + '\'' +
                ", professorId=" + professorId +
                ", joiningDate=" + joiningDate +
                ", firstName='" + firstName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
