package comment_system.comment_system.service;

import comment_system.comment_system.model.Comment;
import comment_system.comment_system.repository.CommentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.mockito.Mockito.*;

class CommentServiceTest {
    @Mock
    CommentRepo commentRepo;
    @InjectMocks
    CommentService commentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        Comment result = commentService.Create(new Comment(0, "message", "username", 0, LocalDate.of(2022, Month.DECEMBER, 20)));
        Assertions.assertEquals(new Comment(0, "message", "username", 0, LocalDate.of(2022, Month.DECEMBER, 20)), result);
    }

    @Test
    void testFindByPostId() {
        when(commentRepo.findAllByPostId(anyInt())).thenReturn(List.of(new Comment(0, "message", "username", 0, LocalDate.of(2022, Month.DECEMBER, 20))));

        List<Comment> result = commentService.FindByPostId(0);
        Assertions.assertEquals(List.of(new Comment(0, "message", "username", 0, LocalDate.of(2022, Month.DECEMBER, 20))), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme