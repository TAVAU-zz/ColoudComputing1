package org.yhwang.csye6225.courseservice5.datamodel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement//map a class to xml
public class Program {
    private long programId;
    private String programName;
    private List<Course> courses;

    public Program() {
    }

    public Program(long programId, String programName) {
        this.programId = programId;
        this.programName = programName;
    }

    public Program(long programId, String programName, List<Course> courses) {
        this.programId = programId;
        this.programName = programName;
        this.courses = courses;
    }

    public long getProgramId() {
        return programId;
    }

    public void setProgramId(long programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
