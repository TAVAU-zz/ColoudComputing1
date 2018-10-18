package org.yhwang.csye6225.courseservice5.service;

import javafx.scene.image.Image;
import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.InMemoryDatabase;
import org.yhwang.csye6225.courseservice5.datamodel.Professor;
import org.yhwang.csye6225.courseservice5.datamodel.Student;

import java.util.*;

public class StudentsService {
    InMemoryDatabase db = InMemoryDatabase.getInstance();
    HashMap<Long, Student> stu_Map = db.getStudentDB();

    //getting a list of all students
    //GET "..webapi/students"
    public List<Student> getAllStudents() {
        return new ArrayList<>(stu_Map.values());
    }

    //adding a student
    public Student addStudent(Student student) {
        //Next id
        //not thread safe :multi call
        long nextAvailableId = stu_Map.size() + 1;
        return stu_Map.put(nextAvailableId, student);
    }

    //getting one student
    public Student getStudent(Long stuId) {
        return stu_Map.get(stuId);
    }
    //deleting a student
    public Student deleteStudent(Long stuId) {
        Student deletedStuDetails = stu_Map.get(stuId);
        stu_Map.remove(stuId);
        return deletedStuDetails;
    }

    //updating student info
    public Student updateStudentInformation(Long stuId, Student stu) {
        Student oldStuObj = stu_Map.get(stuId);
        stuId = oldStuObj.getStudentId();
        stu.setStudentId(stuId);
        //publishing new values
        stu_Map.put(stuId, stu);
        return stu;
    }

    //get stu in a department
    public List<Student> getStudentsByProgram(String program) {
        List<Student> list = new ArrayList<>();
        for (Map.Entry<Long, Student> entry: stu_Map.entrySet()) {
            if (entry.getValue().getProgramName() == program) {
                list.add(entry.getValue());
            }
        }
        return list;
    }
    //
}
