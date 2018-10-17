package org.yhwang.csye6225.courseservice5.resources;

import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.Professor;
import org.yhwang.csye6225.courseservice5.datamodel.Student;
import org.yhwang.csye6225.courseservice5.service.CoursesService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.*;

@Path("courses")
public class CoursesResource {
    CoursesService coursesService = new CoursesService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourses() {
        addCourse("Big Data", new Professor("EE", 30, new Date(), "John"));
        addCourse("Could", new Professor("ME", 29, new Date(), "Smith"));
        return coursesService.getAllCourses();
    }

    //query by TA
    @GET
    @Path("/byTA")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCoursesByTA(@QueryParam ("TA") String TA) {
        if (TA == null) {
            return coursesService.getAllCourses();
        } else {
            return coursesService.getCoursesByTA(TA);
        }
    }

    //...webapi/courses/1
    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course getCourse(@PathParam("courseId")String courId) {
        return coursesService.getCourse(courId);

    }

    @POST
    // @Path()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course addCourse(String courseId) {
        return coursesService.addCourse(courseId);
    }

    public void addCourse(String courseId, Professor prof) {
        coursesService.addCourse(courseId, prof);
    }

    @PUT
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course updateStudent(@PathParam("courseId")String courseId, Course course) {
        return coursesService.updateCourseInformation(courseId, course);

    }

    @DELETE
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Course deleteStudent(@PathParam("courseId")String courseId) {
        return coursesService.deleteCourse(courseId);
    }
}
