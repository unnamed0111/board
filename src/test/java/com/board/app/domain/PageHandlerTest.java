package com.board.app.domain;

import com.board.app.service.BoardService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class PageHandlerTest {
    @Autowired
    BoardService boardService;

    public void showPageList(PageHandler pageHandler) {
        System.out.print(pageHandler.isShowPrev() ? "< " : " ");
        for (int i = pageHandler.getBeginPage(); i <= pageHandler.getEndPage(); i++) {
            System.out.print(i + " ");
        }
        System.out.print(pageHandler.isShowNext() ? ">" : " ");
    }


}