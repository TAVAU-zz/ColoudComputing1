package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.xspec.S;
import org.yhwang.csye6225.courseservice5.datamodel.Announcement;
import org.yhwang.csye6225.courseservice5.datamodel.DynamoDBConnector;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnouncementService {
    DynamoDBConnector dynamoDBConnector = DynamoDBConnector.getInstance();
    AmazonDynamoDB client = dynamoDBConnector.getClient();
    DynamoDBMapper dynamoDBMapper;
    DynamoDBScanExpression dynamoDBScanExpression;

    public AnnouncementService() {
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    //GET "..webapi/announcements"
    public List<Announcement> getAllAnnouncements() {
        dynamoDBScanExpression = new DynamoDBScanExpression();
        List<Announcement> announcements = dynamoDBMapper.scan(Announcement.class, dynamoDBScanExpression);
        return announcements;
    }

    public Announcement addAnnouncement(Announcement announcement) {
        dynamoDBMapper.save(announcement);
        return announcement;
    }

    //getting announcement by boardId_announcementId
    //GET "..webapi/announcements/csye6225_002"
    public List<Announcement> getAnnouncement(String boardId_announcementId) {
        List<Announcement> announcements = queryAnnouncements(boardId_announcementId);

        for (Announcement announcement : announcements) {
            System.out.println(announcement.toString());
        }
        return announcements;
    }

    //deleting specific announcement
    public List<Announcement> deleteAnnouncement(String boardId_announcementId) {
        List<Announcement> announcements = queryAnnouncements(boardId_announcementId);
        if (announcements == null) {
            System.out.println("Announcement need to be deleted does not exists");
        } else {
            for (Announcement announcement : announcements) {
                dynamoDBMapper.delete(announcement);
            }
        }
        return announcements;
    }

    //updating Announcement info
    public List<Announcement> updateAnnouncementInformation(String boardId_announcementId, Announcement announcement) {
        List<Announcement> announcements = queryAnnouncements(boardId_announcementId);
        if (announcements == null) {
            System.out.println("Announcement need to be updated does not exists");
            return null;
        } else {
            for (Announcement a : announcements) {
                dynamoDBMapper.delete(a);
            }
            dynamoDBMapper.save(announcement);
        }
        return queryAnnouncements(boardId_announcementId);
    }

    private List<Announcement> queryAnnouncements(String boardId_announcementId) {

        String[] keys = boardId_announcementId.split("_");
        String partitionKey = keys[0];
        String rangeKey = keys[1];

        Announcement myAnnouncement = new Announcement();
        myAnnouncement.setBoardId(partitionKey);
        Condition rangeKeyCondition = new Condition();
        rangeKeyCondition.withComparisonOperator(ComparisonOperator.EQ)
                .withAttributeValueList(new AttributeValue().withS(rangeKey));

        DynamoDBQueryExpression<Announcement> queryExpression = new DynamoDBQueryExpression<>();
        queryExpression.setHashKeyValues(myAnnouncement);
        queryExpression.withRangeKeyCondition("announcementId", rangeKeyCondition);
        queryExpression.setConsistentRead(false);

        List<Announcement> announcements = dynamoDBMapper.query(Announcement.class, queryExpression);
        return announcements;

    }
}
