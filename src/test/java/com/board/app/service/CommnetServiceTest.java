package com.board.app.service;

import com.board.app.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommnetServiceTest {
    @Autowired
    private CommentService commentService;

    @Test
    public void removeTest() throws Exception {
        Comment comment = new Comment();
        comment.setUserId("falconkick31");
        comment.setCommentId(66);
        comment.setBoardId(147);
        commentService.remove(comment);
    }

}
