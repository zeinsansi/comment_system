package comment_system.comment_system.service;

import comment_system.comment_system.model.Comment;
import comment_system.comment_system.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    public Comment Create(Comment comment){

        Comment commentFromDb = commentRepo.save(comment);
        if(commentFromDb != null){
            return commentFromDb;
        }
        return null;
    }

    public List<Comment> FindByPostId(int postId){
        List<Comment> comments = commentRepo.findAllByPostId(postId);
        if(comments != null){
            return comments;
        }
        return null;
    }
}
