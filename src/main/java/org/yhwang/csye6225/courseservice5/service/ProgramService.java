//package org.yhwang.csye6225.courseservice5.service;
//
//import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
//import org.yhwang.csye6225.courseservice5.datamodel.*;
//
//import java.util.*;
//
//public class ProgramService {
//    InMemoryDatabase db = InMemoryDatabase.getInstance();
//    HashMap<Long, Program> program_Map = db.programDB();
//
//    public ProgramService() {
//
//    }
//
//    //getting a list of program
//    //GET "..webapi/programs"
//    public List<Program> getAllPrograms() {
//        return new ArrayList<>(program_Map.values());
//    }
//
//    // ../programs/{program_id}
//    public Program getProgramById(long programId) {
//        return program_Map.get(programId);
//    }
//
//    //../programs/{program_id}/courses
//    public List<Course> getCourses(long programId) {
//        return getProgramById(programId).getCourses();
//    }
//
//    //adding a program
//    public Program addProgram(Program program) {
//        //create a program obj
//        program_Map.put(program.getProgramId(), program);
//        return program;
//    }
//
//    // ../programs/{program_id}
//    public Program deleteProgram(long programId) {
//        Program deletedProgDetails = program_Map.get(programId);
//        program_Map.remove(programId);
//        return deletedProgDetails;
//    }
//
//    //updating program info
//    public Program updateProgramInformation(long programId, Program program) {
//        Program oldProfObj = program_Map.get(programId);
//        programId = oldProfObj.getProgramId();
//        program.setProgramId(programId);
//        //publishing new values
//        program_Map.put(programId, program);
//        return program;
//    }
//
//}
