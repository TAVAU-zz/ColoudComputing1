package org.yhwang.csye6225.courseservice5.service;

import org.yhwang.csye6225.courseservice5.datamodel.InMemoryDatabase;
import org.yhwang.csye6225.courseservice5.datamodel.Professor;

import java.util.*;
import java.util.Date;

public class ProfessorsService {
    static HashMap<Long, Professor> prof_Map = InMemoryDatabase.getProfessorDB();

    //getting a list of al profe
    //GET "..webapo/professors"
    public List<Professor> getAllProfessors() {

        return new ArrayList<>(prof_Map.values());
    }

    //adding a professor
    public void addProfessor(String name, String department, Date joiningDate) {
        //Next id
        //not thread safe :multi call
        long nextAvailableId = prof_Map.size() + 1;

        //create a prof obj
        Professor prof = new Professor(department, nextAvailableId, joiningDate, name);
        prof_Map.put(nextAvailableId, prof);
    }


    public Professor addProfessor(Professor prof) {
        long nextAvailableId = prof_Map.size() + 1;

        prof_Map.put(nextAvailableId, prof);
        return prof_Map.get(nextAvailableId);
    }

    //getting one professor
    public Professor getProfessor(Long profId) {
        return prof_Map.get(profId);
    }
    //deleting a professor
    public Professor deleteProfessor(Long profId) {
        Professor deletedProfDetails = prof_Map.get(profId);
        prof_Map.remove(profId);
        return deletedProfDetails;
    }

    //updating profes info
    public Professor updateProfessorInformation(Long profId, Professor prof) {
        Professor oldProfObj = prof_Map.get(profId);
        profId = oldProfObj.getProfessorId();
        prof.setProfessorId(profId);
        //publishing new values
        prof_Map.put(profId, prof);
        return  prof;
    }

    //get prof in a department
    public List<Professor> getProfessorsByDepartment(String department) {
        List<Professor> list = new ArrayList<>();
        for (Map.Entry<Long, Professor> entry: prof_Map.entrySet()) {
            if (entry.getValue().getDepartment() == department) {
                list.add(entry.getValue());
            }
        }
        return list;
    }
    //
}
