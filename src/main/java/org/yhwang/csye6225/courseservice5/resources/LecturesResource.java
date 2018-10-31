package org.yhwang.csye6225.courseservice5.resources;

import org.yhwang.csye6225.courseservice5.datamodel.Lecture;
import org.yhwang.csye6225.courseservice5.service.LectureService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;

@Path("/lectures")
public class LecturesResource {
    LectureService lectureService = new LectureService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lecture> getAllLectures(){
        return lectureService.getAllLectures();
    }

    @GET
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture getLectureById(@PathParam("lectureId") String lectureId){
        return lectureService.getLectureById(lectureId);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture addLecture(Lecture lecture){
        lectureService.addLecture(lecture);
        return lecture;
    }

    @PUT
    @Path("/{lectureId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture updateLectureById(@PathParam("lectureId") String lectureId,Lecture lecture){
        lecture.setLectureId(lectureId);
        return lectureService.updateLectureInformation(lectureId, lecture);
    }

    @DELETE
    @Path("/{lectureId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Lecture removeLecture(@PathParam("lectureId") String lectureId){
        return lectureService.deleteLecture(lectureId);
    }


}
