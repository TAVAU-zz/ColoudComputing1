package org.yhwang.csye6225.courseservice5.datamodel;

public class Lecture {
    private long lectureId;
    private String lectureName;
    private String notes;
    private String courseMaterial;

    public Lecture() {

    }

    public Lecture(long lectureId, String lectureName) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
    }

    public Lecture(long lectureId, String lectureName, String notes, String courseMaterial) {
        this.lectureId = lectureId;
        this.lectureName = lectureName;
        this.notes = notes;
        this.courseMaterial = courseMaterial;
    }

    public long getLectureId() {
        return lectureId;
    }

    public void setLectureId(long lectureId) {
        this.lectureId = lectureId;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
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
