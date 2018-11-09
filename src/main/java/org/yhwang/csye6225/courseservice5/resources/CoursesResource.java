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
        return coursesService.getAllCourses();
    }

    //query by TA
//    @GET
//    @Path("/byTA")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Course> getCoursesByTA(@QueryParam ("TA") String TA) {
//        if (TA == null) {
//            return coursesService.getAllCourses();
//        } else {
//            return coursesService.getCoursesByTA(TA);
//        }
//    }

    //...webapi/courses/
    @GET
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> getCourse(@PathParam("courseId")String courId) {
        return coursesService.getCourse(courId);

    }

    @POST
    // @Path()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Course addCourse(Course course) {
        return coursesService.addCourse(course);
    }


    @PUT
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Course> updateStudent(@PathParam("courseId")String courseId, Course course) {
        return coursesService.updateCourseInformation(courseId, course);

    }

    @DELETE
    @Path("/{courseId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Course> deleteStudent(@PathParam("courseId")String courseId) {
        return coursesService.deleteCourse(courseId);
    }
}
