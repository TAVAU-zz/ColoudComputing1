package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.yhwang.csye6225.courseservice5.datamodel.*;

import java.util.*;
import java.util.Date;

public class ProfessorsService {
    InMemoryDatabase db = InMemoryDatabase.getInstance();
    //HashMap<String, Course> course_Map = db.getCourseDB();
    HashMap<String, Professor> prof_Map = db.getProfessorDB();

    DynamoDBConnector dynamoDBConnector = DynamoDBConnector.getInstance();
    AmazonDynamoDB client = dynamoDBConnector.getClient();
    DynamoDBMapper dynamoDBMapper;
    DynamoDBScanExpression dynamoDBScanExpression;

    public ProfessorsService () {
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    //getting a list of all professor
    //GET "..webapi/professors"
    public List<Professor> getAllProfessors() {
        dynamoDBScanExpression = new DynamoDBScanExpression();
        List<Professor> professors = dynamoDBMapper.scan(Professor.class, dynamoDBScanExpression);
        return professors;
    }

    public Professor addProfessor(Professor prof) {
//        String profId = prof.getProfessorId();
//        prof_Map.put(profId, prof);
        dynamoDBMapper.save(prof);
        return prof;
    }

    //getting one professor
    public Professor getProfessor(String profId) {
        Professor prof2 = dynamoDBMapper.load(Professor.class, profId);
        //prof2.setCourses(new ArrayList<Course>());
        System.out.println("Item retrieved:");
        System.out.println(prof2.toString());
        return prof2;
    }

    //deleting a professor
    public Professor deleteProfessor(String profId) {
//        Professor deletedProfDetails = prof_Map.get(profId);
//        prof_Map.remove(profId);
//        return deletedProfDetails;
        Professor deletedProfessor = dynamoDBMapper.load(Professor.class, profId);
        dynamoDBMapper.delete(deletedProfessor);
        return deletedProfessor;
    }

    //updating profes info
    public Professor updateProfessorInformation(String profId, Professor prof) {
        Professor oldProfessor = dynamoDBMapper.load(Professor.class, profId);
        dynamoDBMapper.delete(oldProfessor);
        dynamoDBMapper.save(prof);
        return prof;
    }

    //get prof in a department
    public List<Professor> getProfessorsByDepartment(String department) {
        List<Professor> list = new ArrayList<>();
        for (Map.Entry<String, Professor> entry: prof_Map.entrySet()) {
            if (entry.getValue().getDepartment().equals(department)) {
                list.add(entry.getValue());
            }
        }
        return list;
    }
    //
}
