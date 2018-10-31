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
    public List<Professor> getProfessors() {
        return profService.getAllProfessors();
    }

    //query by department
    @GET
    @Path("/professorsByDepartment")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public List<Professor> getProfessorsByDepartment(@QueryParam("department") String department) {
        if (department.equals("null")) {
            return profService.getAllProfessors();
        } else {
            return profService.getProfessorsByDepartment(department);
        }
    }

    //...webapi/professors/1
    @GET
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public Professor getProfessor(@PathParam("professorId")String profId) {
        return profService.getProfessor(profId);

    }

    @POST
   // @Path()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Professor addProfessor(Professor prof) {
        return profService.addProfessor(prof);
    }


    @PUT
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_XML)
    public Professor updateProfessor(@PathParam("professorId")String profId, Professor prof) {
        return profService.updateProfessorInformation(profId, prof);

    }

    @DELETE
    @Path("/{professorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Professor deleteProfessor(@PathParam("professorId")String profId) {
        return profService.deleteProfessor(profId);
    }
}
