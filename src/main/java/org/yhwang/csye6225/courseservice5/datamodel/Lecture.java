package org.yhwang.csye6225.courseservice5.datamodel;

public class Lecture {
    private String notes;
    private String courseMaterial;

    public Lecture(String notes, String courseMaterial) {
        this.notes = notes;
        this.courseMaterial = courseMaterial;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCourseMaterial() {
        return courseMaterial;
    }

    public void setCourseMaterial(String courseMaterial) {
        this.courseMaterial = courseMaterial;
    }
}
