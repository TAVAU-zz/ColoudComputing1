package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;
import org.yhwang.csye6225.courseservice5.Database.LectureDatabase;
import org.yhwang.csye6225.courseservice5.datamodel.*;
import java.util.*;

public class LectureService {
    //InMemoryDatabase db = InMemoryDatabase.getInstance();
    //HashMap<String, Lecture> lec_Map = db.lectureDB();

    //LectureDatabase lectureDatabase = LectureDatabase.getInstance();
    DynamoDBConnector dynamoDBConnector = DynamoDBConnector.getInstance();
    AmazonDynamoDB client = dynamoDBConnector.getClient();
    DynamoDBMapper dynamoDBMapper;
    DynamoDBScanExpression dynamoDBScanExpression;

    public LectureService() {
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    //get all lectures
    public List<Lecture> getAllLectures(){
        //return new ArrayList<>(lec_Map.values());
        dynamoDBScanExpression = new DynamoDBScanExpression();
        List<Lecture> lectures = dynamoDBMapper.scan(Lecture.class, dynamoDBScanExpression);
        System.out.println(lectures);
        return lectures;
    }

    //get lecture by id
    public Lecture getLectureById(String lectureId){
        return dynamoDBMapper.load(Lecture.class, lectureId);
    }

    public Lecture addLecture(Lecture lecture) {
        //lec_Map.put(lecture.getLectureId(),lecture);
        dynamoDBMapper.save(lecture);
        return lecture;
    }

    //updating lecture info
    public Lecture updateLectureInformation(String lectureId, Lecture lecture) {
        Lecture oldlecture = dynamoDBMapper.load(Lecture.class, lectureId);
//        Lecture oldLecObj = lec_Map.get(lectureId);
//        lectureId = oldLecObj.getLectureId();
//        lecture.setLectureId(lectureId);
        dynamoDBMapper.delete(oldlecture);
        dynamoDBMapper.save(lecture);
        //publishing new values
        //lec_Map.put(lectureId, lecture);
        return lecture;
    }

    //delete a lecture
    public Lecture deleteLecture(String lectureId) {
        Lecture lecture = dynamoDBMapper.load(Lecture.class, lectureId);
        dynamoDBMapper.delete(lectureId);
        return lecture;
    }
}
