package org.yhwang.csye6225.courseservice5.resources;

import org.yhwang.csye6225.courseservice5.datamodel.Board;
import org.yhwang.csye6225.courseservice5.service.BoardService;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("boards")
public class BoardResource {
    BoardService boardService = new BoardService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> getBoards() {
        return boardService.getAllBoards();
    }

    //...webapi/boards/zhifeng.sun
    @GET
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> getBoard(@PathParam("boardId")String boardId) {
        return boardService.getBoard(boardId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Board addBoard(Board board) {
        return boardService.addBoard(board);
    }


    @PUT
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Board> updateBoard(@PathParam("boardId")String boardId, Board board) {
        return boardService.updateBoardInformation(boardId, board);

    }

    @DELETE
    @Path("/{boardId}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Board> deleteBoard(@PathParam("boardId")String boardId) {
        return boardService.deleteBoard(boardId);
    }
}
