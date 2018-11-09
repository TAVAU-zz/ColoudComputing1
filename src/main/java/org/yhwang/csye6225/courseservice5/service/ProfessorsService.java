package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import org.yhwang.csye6225.courseservice5.datamodel.*;

import java.util.*;
import java.util.Date;

public class ProfessorsService {
    //InMemoryDatabase db = InMemoryDatabase.getInstance();
    //HashMap<String, Course> course_Map = db.getCourseDB();
   // HashMap<String, Professor> prof_Map = db.getProfessorDB();

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
        dynamoDBMapper.save(prof);
        return prof;
    }

    //getting professor by professorId
    //GET "..webapi/professors/zhifeng.sun"
    public List<Professor> getProfessor(String profId) {
        List<Professor> professors = queryProfessors(profId);
        System.out.println("Item retrieved:");
        for (Professor p : professors) {
            System.out.println(p.toString());
        }

        return professors;
    }

    //deleting a professor
    public List<Professor> deleteProfessor(String profId) {
        List<Professor> deletedProfessor = queryProfessors(profId);
        if (deletedProfessor == null) {
            System.out.println("Professor needed to be deleted does not exists");
        } else {
            for (Professor p : deletedProfessor) {
                dynamoDBMapper.delete(p);
            }
        }
        return deletedProfessor;
    }

    //updating profes info
    public List<Professor> updateProfessorInformation(String profId, Professor prof) {
        List<Professor> professors = queryProfessors(profId);
        if (professors == null) {
            System.out.println("Professor needed to be updated does not exists");
            return null;
        } else {
            for (Professor p : professors) {
                dynamoDBMapper.delete(p);
            }
        }
        dynamoDBMapper.save(prof);
        return queryProfessors(profId);
    }

    //get prof in a department
//    public List<Professor> getProfessorsByDepartment(String department) {
//        List<Professor> list = new ArrayList<>();
//        for (Map.Entry<String, Professor> entry: prof_Map.entrySet()) {
//            if (entry.getValue().getDepartment().equals(department)) {
//                list.add(entry.getValue());
//            }
//        }
//        return list;
//    }
    //

    private List<Professor> queryProfessors(String profId) {
        Professor myProfessor= new Professor();
        myProfessor.setProfessorId(profId);
        DynamoDBQueryExpression<Professor> queryExpression = new DynamoDBQueryExpression<Professor>();
        queryExpression.setHashKeyValues(myProfessor);
        queryExpression.withIndexName("professorId-index");
        queryExpression.setConsistentRead(false);
        List<Professor> professors = dynamoDBMapper.query(Professor.class, queryExpression);
        return professors;
    }
}
