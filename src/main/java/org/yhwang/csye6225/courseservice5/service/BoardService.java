package org.yhwang.csye6225.courseservice5.service;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import org.yhwang.csye6225.courseservice5.datamodel.Board;
import org.yhwang.csye6225.courseservice5.datamodel.DynamoDBConnector;

import java.util.List;

public class BoardService {
    DynamoDBConnector dynamoDBConnector = DynamoDBConnector.getInstance();
    AmazonDynamoDB client = dynamoDBConnector.getClient();
    DynamoDBMapper dynamoDBMapper;
    DynamoDBScanExpression dynamoDBScanExpression;

    public BoardService() {
        dynamoDBMapper = new DynamoDBMapper(client);
    }

    //GET "..webapi/boards"
    public List<Board> getAllBoards() {
        dynamoDBScanExpression = new DynamoDBScanExpression();
        List<Board> boards = dynamoDBMapper.scan(Board.class, dynamoDBScanExpression);
        return boards;
    }

    public Board addBoard(Board board) {
        dynamoDBMapper.save(board);
        return board;
    }

    //getting board by boardId
    //GET "..webapi/boards/"
    public List<Board> getBoard(String boardId) {
        //@DynamoDBIndexHashKey(attributeName = "boardId", globalSecondaryIndexName = "boardId-index")
        Board myBoard= new Board();
        myBoard.setBoardId(boardId);
        DynamoDBQueryExpression<Board> queryExpression = new DynamoDBQueryExpression<Board>();
        queryExpression.setHashKeyValues(myBoard);
        //queryExpression.withIndexName("boardId-index");
        queryExpression.setConsistentRead(false);
        List<Board> boards = dynamoDBMapper.query(Board.class, queryExpression);

        System.out.println("Item retrieved:");
        for (Board b : boards) {
            System.out.println(b.toString());
        }

        return boards;
    }

    //deleting a board
    public Board deleteBoard(String boardId) {
//        return deletedBoardDetails;
        Board deletedBoard = dynamoDBMapper.load(Board.class, boardId);
        dynamoDBMapper.delete(deletedBoard);
        return deletedBoard;
    }

    //updating board info
    public Board updateBoardInformation(String boardId, Board board) {
        Board oldBoard = dynamoDBMapper.load(Board.class, boardId);
        dynamoDBMapper.delete(oldBoard);
        dynamoDBMapper.save(board);
        return board;
    }
}
