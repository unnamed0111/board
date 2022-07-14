package com.board.app.dao;

import com.board.app.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentDaoTest {
    @Autowired
    CommentDao commentDao;

    @Test
    public void insertTest() throws Exception {
        Comment comment = new Comment();

        comment.setBoardId(4);
        comment.setCommentContent("대 댓글2 입니다.");
        comment.setUserId("kimpope");
        comment.setCommentParentId(4);

        System.out.println("comment = " + comment);

        commentDao.insert(comment);
    }

    @Test
    public void deleteTest() throws Exception {
        Comment comment = new Comment();

        comment.setBoardId(4);
        comment.setCommentId(2);
        comment.setUserId("kimpope");

        System.out.println("comment = " + comment);

        commentDao.delete(comment);
    }

    @Test
    public void updateTest() throws Exception {
        Comment comment = new Comment();

        comment.setCommentId(4);
        comment.setUserId("falconkick31");
        comment.setCommentContent("수정된 댓글 4");

        int rowCnt = commentDao.update(comment);

        System.out.println("rowCnt = " + rowCnt);
    }

    @Test
    public void selectByBoardIdTest() throws Exception {
        Integer boardId = 4;

        List<Comment> list = commentDao.selectByBoardId(boardId);

        System.out.println("list = " + list);
    }
}