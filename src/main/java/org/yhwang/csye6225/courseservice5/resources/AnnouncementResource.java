package org.yhwang.csye6225.courseservice5.resources;

import org.yhwang.csye6225.courseservice5.datamodel.Announcement;
import org.yhwang.csye6225.courseservice5.service.AnnouncementService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("announcements")
public class AnnouncementResource {
    AnnouncementService announcementService = new AnnouncementService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Announcement> getAnnouncements() {
        return announcementService.getAllAnnouncements();
    }

    //...webapi/announcements/
    @GET
    @Path("/{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Announcement> getAnnouncement(@PathParam("announcementId")String announcementId) {
        return announcementService.getAnnouncement(announcementId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Announcement addAnnouncement(Announcement announcement) {
        return announcementService.addAnnouncement(announcement);
    }


    @PUT
    @Path("/{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Announcement updateAnnouncement(@PathParam("announcementId")String announcementId, Announcement announcement) {
        return announcementService.updateAnnouncementInformation(announcementId, announcement);

    }

    @DELETE
    @Path("/{announcementId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Announcement deleteAnnouncement(@PathParam("announcementId")String announcementId) {
        return announcementService.deleteAnnouncement(announcementId);
    }
}
