package comment_system.comment_system.controller;


import comment_system.comment_system.DAO.commentDAO;
import comment_system.comment_system.model.Comment;
import comment_system.comment_system.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/comment")
@CrossOrigin("http://localhost:3000/")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @MessageMapping(value = "/add")
    @SendTo("/comments")
    public ResponseEntity<?> CreateComment(@Payload commentDAO commentDAO) {
        Comment comment = Comment.builder()
                .message(commentDAO.getMessage())
                .username(commentDAO.getUsername())
                .postId(commentDAO.getPostId()).build();

        Comment commentFromDb =  commentService.Create(comment);
        if (commentFromDb != null){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(comment);
        }
        return new ResponseEntity<>("was niet gelukt om Comment te maken", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getComments/{postId}")
    public ResponseEntity<?> GetCommentOfPost(@PathVariable("postId") int postId){

        List<Comment> comments =  commentService.FindByPostId(postId);
        if (comments != null){
            return ResponseEntity.status(HttpStatus.OK)
                    .body(comments);
        }
        return new ResponseEntity<>("was niet gelukt om Comments te halen", HttpStatus.BAD_REQUEST);
    }
}
