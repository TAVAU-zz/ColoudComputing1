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
    //GET "..webapi/boards/{boardId}"
    public List<Board> getBoard(String boardId) {
        List<Board> boards = queryBoards(boardId);

        System.out.println("Item retrieved:");
        for (Board b : boards) {
            System.out.println(b.toString());
        }

        return boards;
    }

    //deleting a board
    public List<Board> deleteBoard(String boardId) {
        List<Board> deletedBoards = queryBoards(boardId);
        if (deletedBoards == null) {
            System.out.println("Board need to be deleted does not exists!");
        } else {
            for (Board board : deletedBoards) {
                dynamoDBMapper.delete(board);
            }
        }
        return deletedBoards;
    }

    //updating board info
    public List<Board> updateBoardInformation(String boardId, Board board) {
        List<Board> boards = queryBoards(boardId);
        if (boards == null) {
            System.out.println("Board need to be updated does not exists!");
        } else {
            for (Board b : boards) {
                dynamoDBMapper.delete(b);
            }
            dynamoDBMapper.save(board);
        }
        return queryBoards(boardId);
    }

    private List<Board> queryBoards(String boardId) {
        //@DynamoDBIndexHashKey(attributeName = "boardId", globalSecondaryIndexName = "boardId-index")
        Board myBoard= new Board();
        myBoard.setBoardId(boardId);
        DynamoDBQueryExpression<Board> queryExpression = new DynamoDBQueryExpression<Board>();
        queryExpression.setHashKeyValues(myBoard);
        queryExpression.withIndexName("boardId-index");//not necessary
        queryExpression.setConsistentRead(false);
        List<Board> boards = dynamoDBMapper.query(Board.class, queryExpression);
        return boards;
    }
}
