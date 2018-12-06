package org.yhwang.csye6225.courseservice5.datamodel;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement//map a class to xml
@DynamoDBTable(tableName ="announcement")
public class Announcement {
    private String Id;
    private String announcementId;
    private String announcementText;
    private String boardId;

    public Announcement() {
    }

    @DynamoDBHashKey(attributeName = "Id")
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    @DynamoDBIndexRangeKey(attributeName = "announcementId", globalSecondaryIndexName = "boardId-announcementId-index")
    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    @DynamoDBAttribute(attributeName = "announcementText")
    public String getAnnouncementText() {
        return announcementText;
    }

    public void setAnnouncementText(String announcementText) {
        this.announcementText = announcementText;
    }

    @DynamoDBIndexHashKey(attributeName = "boardId", globalSecondaryIndexName = "boardId-announcementId-index")
    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "Id='" + Id + '\'' +
                ", announcementId='" + announcementId + '\'' +
                ", announcementText='" + announcementText + '\'' +
                ", boardId='" + boardId + '\'' +
                '}';
    }
}