package org.yhwang.csye6225.courseservice5.Database;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;

import com.amazonaws.services.dynamodbv2.model.*;
import org.yhwang.csye6225.courseservice5.datamodel.DynamoDBConnector;

import java.util.*;

public class LectureDatabase {

    static AmazonDynamoDB dynamoDB;
    static String tableName = "lecture";
    private static LectureDatabase lectureDatabase = new LectureDatabase();
    public static LectureDatabase getInstance() {
        if (lectureDatabase == null) {
            lectureDatabase = new LectureDatabase();
        }
        return lectureDatabase;
    }

    public LectureDatabase() {
        try {

//            List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
//            attributeDefinitions.add(new AttributeDefinition().withAttributeName("lectureId").withAttributeType("S"));
//
//            List<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
//            keySchema.add(new KeySchemaElement().withAttributeName("lectureId").withKeyType(KeyType.HASH)); // Partition key
//
//            CreateTableRequest request = new CreateTableRequest().withTableName(tableName).withKeySchema(keySchema)
//                    .withAttributeDefinitions(attributeDefinitions).withProvisionedThroughput(
//                            new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(6L));

            AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
            CreateTableRequest request = new CreateTableRequest()
                    .withAttributeDefinitions(new AttributeDefinition().withAttributeName("lectureId").withAttributeType("S"),
                            new AttributeDefinition().withAttributeName("lectureName").withAttributeType("S"),
                            new AttributeDefinition().withAttributeName("notes").withAttributeType("S"),
                            new AttributeDefinition().withAttributeName("courseMaterial").withAttributeType("S"))
                    .withTableName(tableName)
                    .withKeySchema(new KeySchemaElement().withAttributeName("lectureId").withKeyType(KeyType.HASH),
                            new KeySchemaElement().withAttributeName("lectureName"),
                            new KeySchemaElement().withAttributeName("notes"),
                            new KeySchemaElement().withAttributeName("courseMaterial")
                            )
                    .withProvisionedThroughput(new ProvisionedThroughput().withReadCapacityUnits(5L).withWriteCapacityUnits(5L));
            CreateTableResult response = client.createTable(request);

            System.out.println("Issuing CreateTable request for " + tableName);
            CreateTableResult tableResult = dynamoDB.createTable(request);
            TableDescription tableDescription = tableResult.getTableDescription();
            System.out.format(
                    "Name: %s:\n" + "Status: %s \n" + "Provisioned Throughput (read capacity units/sec): %d \n"
                            + "Provisioned Throughput (write capacity units/sec): %d \n",
                    tableDescription.getTableName(), tableDescription.getTableStatus(),
                    tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
                    tableDescription.getProvisionedThroughput().getWriteCapacityUnits());

            //add items


        }
        catch (Exception e) {
            System.err.println("CreateTable request failed for " + tableName);
            System.err.println(e.getMessage());
        }
    }

}
