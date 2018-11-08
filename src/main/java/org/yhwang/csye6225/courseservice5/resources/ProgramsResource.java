//package org.yhwang.csye6225.courseservice5.resources;
//
//import org.yhwang.csye6225.courseservice5.datamodel.Course;
//import org.yhwang.csye6225.courseservice5.datamodel.Professor;
//import org.yhwang.csye6225.courseservice5.datamodel.Program;
//import org.yhwang.csye6225.courseservice5.service.ProgramService;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import java.util.*;
//
//@Path("programs")
//public class ProgramsResource {
//    ProgramService programService = new ProgramService();
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Program> getPrograms() {
//        return programService.getAllPrograms();
//    }
//
//    //query by program name
//    //kind of duplicate
////    @GET
////    @Path("/byname")
////    @Produces(MediaType.APPLICATION_JSON)
////    public List<Program> getProgramsByName(@QueryParam("name") String name) {
////        if (name == null) {
////            return programService.getAllPrograms();
////        } else {
////            return programService.getProgramsByName(name);
////        }
////    }
//
//    //...webapi/programs/1
//    @GET
//    @Path("/{programId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Program getProgram(@PathParam("programId") long programId) {
//        return programService.getProgramById(programId);
//    }
//
//    @GET
//    @Path("/{programId}/courses")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Course> getCourses(@PathParam("programId") long programId) {
//        return programService.getCourses(programId);
//    }
//
//   // @POST
//    //@Path()
//   // @Produces(MediaType.APPLICATION_JSON)
//   // @Consumes(MediaType.APPLICATION_JSON)
////    public Program addProgram(String name) {
////        return programService.addProgram(name);
////    }
//
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Program addProgram(Program program) {
//        programService.addProgram(program);
//        return program;
//    }
//
//    //replace
//    @PUT
//    @Path("/{programId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Program updateProgram(@PathParam("programId")long programId, Program program) {
//        return programService.updateProgramInformation(programId, program);
//    }
//
//    @DELETE
//    @Path("/{programId}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Program deleteStudent(@PathParam("programId")long programId) {
//        return programService.deleteProgram(programId);
//    }
//}
