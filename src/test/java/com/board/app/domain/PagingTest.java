package com.board.app.domain;

import com.board.app.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PagingTest {
    @Autowired
    BoardService boardService;

    public void showPageList(Paging paging) {
        System.out.print(paging.isShowPrev() ? "< " : " ");
        for (int i = paging.getBeginPage(); i <= paging.getEndPage(); i++) {
            System.out.print(i + " ");
        }
        System.out.print(paging.isShowNext() ? ">" : " ");
    }

    @Test
    public void pagingTest() {
        Paging paging = new Paging(32, 315);

        showPageList(paging);
    }

    @Test
    public void pagingTest2() throws Exception {
        Paging paging = new Paging(17, boardService.getSize());

        showPageList(paging);
    }
}