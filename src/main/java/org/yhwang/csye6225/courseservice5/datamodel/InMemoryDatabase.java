package org.yhwang.csye6225.courseservice5.datamodel;

import java.util.*;

public class InMemoryDatabase {
    private static HashMap<Long, Professor> professorDB = new HashMap<>();

    public static HashMap<Long, Professor> getProfessorDB() {
        return professorDB;
    }
}
