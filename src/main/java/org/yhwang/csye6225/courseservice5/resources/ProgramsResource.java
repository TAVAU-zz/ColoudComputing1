package org.yhwang.csye6225.courseservice5.resources;

import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.Professor;
import org.yhwang.csye6225.courseservice5.datamodel.Program;
import org.yhwang.csye6225.courseservice5.service.ProgramService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("programs")
public class ProgramsResource {
    ProgramService programService = new ProgramService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Program> getPrograms() {
        List<Course> list = new ArrayList<>();
        list.add(new Course("cloud"));
        list.add(new Course("algorithm"));
        addProgram("CS", list);
        addProgram("IS", list);
        return programService.getAllPrograms();
    }

    //query by program name
    //kind of duplicate
//    @GET
//    @Path("/byname")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Program> getProgramsByName(@QueryParam("name") String name) {
//        if (name == null) {
//            return programService.getAllPrograms();
//        } else {
//            return programService.getProgramsByName(name);
//        }
//    }

    //...webapi/programs/1
    @GET
    @Path("/{programName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Program getProgram(@PathParam("programName")String programName) {
        return programService.getProgram(programName);
    }

   // @POST
    // @Path()
   // @Produces(MediaType.APPLICATION_JSON)
   // @Consumes(MediaType.APPLICATION_JSON)
//    public Program addProgram(String name) {
//        return programService.addProgram(name);
//    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProgram(Program program) {
        programService.addProgram(program);
    }

    //replace
    @PUT
    @Path("/{programName}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Program updateProgram(@PathParam("programName")String name, Program program) {
        return programService.updateProgramInformation(name, program);
    }

    @DELETE
    @Path("/{programName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Program deleteStudent(@PathParam("programName")String programName) {
        return programService.deleteProgram(programName);
    }
}
