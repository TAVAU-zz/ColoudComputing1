package org.yhwang.csye6225.courseservice5.resources;

import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.Student;
import org.yhwang.csye6225.courseservice5.service.StudentsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

@Path("students")
public class StudentsResource {
    StudentsService studentsService = new StudentsService();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return studentsService.getAllStudents();
    }

//    //query by program
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Student> getStudentsByProgram(@QueryParam ("program") String program
//    ) {
//        if (program == null) {
//            return studentsService.getAllStudents();
//        } else {
//            return studentsService.getStudentsByProgram(program);
//        }
//    }

    //...webapi/students/1
    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent(@PathParam("studentId")Long stuId) {
        return studentsService.getStudent(stuId);

    }

    @POST
    // @Path()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student stu) {
        studentsService.addStudent(stu);
        return stu;
    }

    @PUT
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public Student updateStudent(@PathParam("studentId")Long stuId, Student stu) {
        return studentsService.updateStudentInformation(stuId, stu);

    }

    @DELETE
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student deleteStudent(@PathParam("studentId")Long stuId) {
        return studentsService.deleteStudent(stuId);
    }
}
