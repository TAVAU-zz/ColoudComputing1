package org.yhwang.csye6225.courseservice5.service;

import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.InMemoryDatabase;
import org.yhwang.csye6225.courseservice5.datamodel.Professor;
import org.yhwang.csye6225.courseservice5.datamodel.Program;

import java.util.*;

public class ProgramService {
    static HashMap<String, Program> program_Map = InMemoryDatabase.programDB();
    //getting a list of program
    //GET "..webapi/programs"
    public List<Program> getAllPrograms() {
        return new ArrayList<>(program_Map.values());
    }

    //adding a program
    public Program addProgram(Program program) {
        //create a program obj
        program_Map.put(program.getName(), program);
        return program;
    }


    //getting one program
    public Program getProgram(String name) {
        return program_Map.get(name);
    }
    //deleting a program
    public Program deleteProgram(String name) {
        Program deletedProgDetails = program_Map.get(name);
        program_Map.remove(name);
        return deletedProgDetails;
    }

    //updating program info
    public Program updateProgramInformation(String name, Program program) {
        Program oldProfObj = program_Map.get(name);
        name = oldProfObj.getName();
        program.setName(name);
        //publishing new values
        program_Map.put(name, program);
        return program;
    }

    //get program in a department
    public List<Program> getProgramsByName(String name) {
        List<Program> list = new ArrayList<>();
        for (Map.Entry<String, Program> entry: program_Map.entrySet()) {
            if (entry.getValue().getName().equals(name)) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

}
