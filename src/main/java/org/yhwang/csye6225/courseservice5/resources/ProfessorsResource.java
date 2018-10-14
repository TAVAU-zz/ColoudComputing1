package org.yhwang.csye6225.courseservice5.resources;
import com.sun.org.apache.regexp.internal.RE;
import org.yhwang.csye6225.courseservice5.datamodel.Professor;
import org.yhwang.csye6225.courseservice5.service.ProfessorsService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("professors")
public class ProfessorsResource {

    ProfessorsService profService = new ProfessorsService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public List<Professor> getProfessors() {
        addProfessor("Tom", "IS", new Date());
        addProfessor("Yusuf", "IS", new Date());
        return profService.getAllProfessors();
    }

    //query by department
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    //@Produces(MediaType.APPLICATION_XML)
//    public List<Professor> getProfessorsByDepartment(@QueryParam ("department") String department
//                                                      ) {
//        if (department == null) {
//            return profService.getAllProfessors();
//        } else {
//            return profService.getProfessorsByDepartment(department);
//        }
//    }

    //...webapi/professors/1
    @GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public Professor getProfessor(@PathParam("professorId")Long profId) {
        return profService.getProfessor(profId);

    }
    @POST
   // @Path()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    //@Consumes(MediaType.APPLICATION_XML)
    public Professor addProfessor(Professor prof) {
        return profService.addProfessor(prof);
    }

    public void addProfessor(String name, String department, Date joiningDate) {
        profService.addProfessor(name, department,joiningDate);
    }

    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public Professor updateProfessor(@PathParam("professorId")Long profId, Professor prof) {
        return profService.updateProfessorInformation(profId, prof);

    }

    @DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor deleteProfessor(@PathParam("professorId")Long profId) {
        return profService.deleteProfessor(profId);
    }
}
