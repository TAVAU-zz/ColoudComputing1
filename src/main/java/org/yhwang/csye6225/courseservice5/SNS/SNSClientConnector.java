package org.yhwang.csye6225.courseservice5.SNS;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.*;
import org.yhwang.csye6225.courseservice5.datamodel.Course;
import org.yhwang.csye6225.courseservice5.datamodel.Student;
import org.yhwang.csye6225.courseservice5.datamodel.Announcement;

public class SNSClientConnector {
    AmazonSNS amazonSNSClient;

    private static SNSClientConnector snsClientConnector = new SNSClientConnector();
    public static SNSClientConnector getInstance() {
        if (snsClientConnector == null) {
            snsClientConnector = new SNSClientConnector();
        }
        return snsClientConnector;
    }

    public AmazonSNS getAmazonSNSClient() {
        return amazonSNSClient;
    }

    public SNSClientConnector() {
        //create a new SNS client and set endpoint
        //amazonSNS = new AmazonSNSClient(new ClasspathPropertiesFileCredentialsProvider());
        //AWSStaticCredentialsProvider credentialsProvider = new AWSStaticCredentialsProvider();
        //credentialsProvider.getCredentials();
        if (amazonSNSClient == null) {
            amazonSNSClient = AmazonSNSClientBuilder.defaultClient();
        }

        //snsClient = AmazonSNSClientBuilder.standard().withCredentials(credentialsProvider).
                //withRegion(Regions.US_EAST_2).build();
        //amazonSNS.setRegion(Region.getRegion(Regions.US_EAST_2));
    }

    public void createTopic(Course course) {

        String topic = course.getNotificationTopic();
        //create a new SNS topic
        CreateTopicRequest createTopicRequest = new CreateTopicRequest(topic);
        CreateTopicResult createTopicResult = amazonSNSClient.createTopic(createTopicRequest);
        //print TopicArn
        System.out.println(createTopicResult);
        //get request id for CreateTopicRequest from SNS metadata
        System.out.println("CreateTopicRequest - " + amazonSNSClient.getCachedResponseMetadata(createTopicRequest));

    }

    public void subscribeTopic(Course course, Student student) {
        String topicArn = "arn:aws:sns:us-east-2:432346481126:" + course.getNotificationTopic();
        String subscribedEmail = student.getEmail();
        //subscribe to an SNS topic
        SubscribeRequest subRequest = new SubscribeRequest(topicArn, "email", subscribedEmail);
        amazonSNSClient.subscribe(subRequest);
        //get request id for SubscribeRequest from SNS metadata
        System.out.println("SubscribeRequest - " + amazonSNSClient.getCachedResponseMetadata(subRequest));
        System.out.println("Check your email and confirm subscription.");
    }

    public void deleteTopic(Course course) {
        //delete an SNS topic
        String topicArn = "arn:aws:sns:us-east-2:432346481126:" + course.getNotificationTopic();
        DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicArn);
        amazonSNSClient.deleteTopic(deleteTopicRequest);
        //get request id for DeleteTopicRequest from SNS metadata
        System.out.println("DeleteTopicRequest - " + amazonSNSClient.getCachedResponseMetadata(deleteTopicRequest));
    }

    public void publishTopic(Announcement announcement) {
        //publish to an SNS topic
        String msg = announcement.getAnnouncementText();
       // String topicArn = "arn:aws:sns:us-east-2:432346481126:" + course.getNotificationTopic();
        String topicArn = "arn:aws:sns:us-east-2:432346481126:" + announcement.getBoardId() + "topic";
        PublishRequest publishRequest = new PublishRequest(topicArn, msg);
        PublishResult publishResult = amazonSNSClient.publish(publishRequest);
        //print MessageId of message published to SNS topic
        System.out.println("MessageId - " + publishResult.getMessageId());
    }

    //announcement -> Topic arn -> publish
}
