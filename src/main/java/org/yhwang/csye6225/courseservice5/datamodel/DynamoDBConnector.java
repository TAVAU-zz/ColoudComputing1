package org.yhwang.csye6225.courseservice5.datamodel;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class DynamoDBConnector {

    static AmazonDynamoDB client;

    private static DynamoDBConnector dynamoDBConnector = new DynamoDBConnector();
    public static DynamoDBConnector getInstance() {
        if (dynamoDBConnector == null) {
            dynamoDBConnector = new DynamoDBConnector();
        }
        return dynamoDBConnector;
    }

    public DynamoDBConnector()  {
        if (client == null) {
            ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvider();
            credentialsProvider.getCredentials();
            System.out.println("credentialsProvider is " + credentialsProvider);
            client = AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider)
                    .withRegion("us-east-2").build();
            System.out.println("I create the client");
        }
    }

    public AmazonDynamoDB getClient() {
        return client;
    }
}
