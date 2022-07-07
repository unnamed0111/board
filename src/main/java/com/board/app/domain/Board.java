package com.board.app.domain;

import java.util.Date;

public class Board {
    private Integer     boardId;
    private String      boardTitle;
    private String      userId;
    private String      boardContent;
    private Date        boardRegDate;
    private Date        boardUpDate;
    private Integer     boardViewCnt;
    private Integer     boardCommentCnt;
    private Integer     boardLikeCnt;

    public Board() {}

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public Date getBoardRegDate() {
        return boardRegDate;
    }

    public void setBoardRegDate(Date boardRegDate) {
        this.boardRegDate = boardRegDate;
    }

    public Date getBoardUpDate() {
        return boardUpDate;
    }

    public void setBoardUpDate(Date boardUpDate) {
        this.boardUpDate = boardUpDate;
    }

    public Integer getBoardViewCnt() {
        return boardViewCnt;
    }

    public void setBoardViewCnt(Integer boardViewCnt) {
        this.boardViewCnt = boardViewCnt;
    }

    public Integer getBoardCommentCnt() {
        return boardCommentCnt;
    }

    public void setBoardCommentCnt(Integer boardCommentCnt) {
        this.boardCommentCnt = boardCommentCnt;
    }

    public Integer getBoardLikeCnt() {
        return boardLikeCnt;
    }

    public void setBoardLikeCnt(Integer boardLikeCnt) {
        this.boardLikeCnt = boardLikeCnt;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                ", boardTitle='" + boardTitle + '\'' +
                ", userId='" + userId + '\'' +
                ", boardContent='" + boardContent + '\'' +
                ", boardRegDate=" + boardRegDate +
                ", boardUpDate=" + boardUpDate +
                ", boardViewCnt=" + boardViewCnt +
                ", boardCommentCnt=" + boardCommentCnt +
                ", boardLikeCnt=" + boardLikeCnt +
                '}';
    }
}
