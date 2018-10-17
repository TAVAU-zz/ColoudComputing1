package org.yhwang.csye6225.courseservice5.datamodel;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement//map a class to xml
public class Program {
    private String name;

    private List<Course> courses;

    public Program() {
    }

    public Program(String name) {
        this.name = name;
    }

    public Program(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
