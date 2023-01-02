package comment_system.comment_system.repository;

import comment_system.comment_system.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository <Comment, Integer>{
     List<Comment> findAllByPostId(int postId);

}
