package com.board.app.controller;

import com.board.app.dao.UserDao;
import com.board.app.domain.Board;
import com.board.app.domain.PageHandler;
import com.board.app.domain.SearchCondition;
import com.board.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    private UserDao userDao;
    private BoardService boardService;

    @Autowired
    public BoardController(UserDao userDao, BoardService boardService) {
        this.userDao = userDao;
        this.boardService = boardService;
    }

    // app/board/list?page=1&keyword=&
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getList(SearchCondition sc, Model m) throws Exception {

        // 페이지 버튼 UI 담당
        Integer totalCnt = boardService.getSize(sc);
        PageHandler ph = new PageHandler(sc, totalCnt);

        List<Board> boardList = boardService.getList(sc);

        m.addAttribute("boardList", boardList);
        m.addAttribute("ph", ph);

        return "boardList";
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET) // /board/read?id=1231
    public String read(@RequestParam(value = "id") Integer boardId, Model m) throws Exception {

        if(boardId == null) return "redirect:/board/list";

        Board board = boardService.read(boardId);

        if(board == null) return "redirect:/board/list";

        m.addAttribute("board", board);

        return "board";
    }

    // 게시물 작성 페이지
    @RequestMapping(value = "/write", method = RequestMethod.GET)
    public String getWrite(HttpServletRequest request, Model m) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return "redirect:/login";

        m.addAttribute("mode", "WRT");

        return "boardForm";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(Board board, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return "redirect:/login";

        // 작성자 주입
        board.setUserId(userId);

        // 게시물 등록
        int rowCnt = boardService.write(board);

        // 목록 첫페이지로 이동
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String getModify(@RequestParam(value = "id") Integer boardId,
                            HttpServletRequest request,
                            Model m) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return "redirect:/login";

        // 게시물의 주인이 세션과 일치하는지 확인
        Board board = boardService.get(boardId);
        if(!board.getUserId().equals(userId)) return "redirect:/board/read?"+boardId;

        // 게시물의 내용을 다시 폼에 적용시키기
        m.addAttribute("board", board);
        m.addAttribute("mode", "MOD");

        return "boardForm";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String modify(Board board, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return "redirect:/login";

        // 유저 정보 주입 (게시글 주인 확인)
        board.setUserId(userId);

        // 수정된 내용들을 DB에 업데이트 시킨다.
        int rowCnt = boardService.modify(board);


        return "redirect:/board/read?id="+board.getBoardId();
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String delete(Board board, HttpServletRequest request) throws Exception {
        String userId = loginCheck(request);
        if(userId == null) return "redirect:/login";

        board.setUserId(userId);

        boardService.remove(board);

        return "redirect:/board/list";
    }


    private String loginCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if(session == null) return null;

        return (String) session.getAttribute("id");
    }
}
