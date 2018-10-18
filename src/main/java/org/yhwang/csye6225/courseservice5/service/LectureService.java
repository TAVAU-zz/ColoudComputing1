package org.yhwang.csye6225.courseservice5.service;

import org.yhwang.csye6225.courseservice5.datamodel.*;

import java.util.*;

public class LectureService {
    InMemoryDatabase db = InMemoryDatabase.getInstance();
    HashMap<Long, Lecture> lec_Map = db.lectureDB();
    public LectureService() {

    }

    //get all lectures
    public List<Lecture> getAllLectures(){
        return new ArrayList<>(lec_Map.values());
    }

    //get lecture by id
    public Lecture getLectureById(long lectureId){
        return lec_Map.get(lectureId);
    }

    public Lecture addLecture(Lecture lecture) {
        return lec_Map.put(lecture.getLectureId(),lecture);
    }

    //updating lecture info
    public Lecture updateLectureInformation(long lectureId, Lecture lecture) {
        Lecture oldLecObj = lec_Map.get(lectureId);
        lectureId = oldLecObj.getLectureId();
        lecture.setLectureId(lectureId);
        //publishing new values
        lec_Map.put(lectureId, lecture);
        return lecture;
    }

    //delete a lecture
    public Lecture deleteLecture(long lectureId) {
        return lec_Map.remove(lectureId);
    }
}
