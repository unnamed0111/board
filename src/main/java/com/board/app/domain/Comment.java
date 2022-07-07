package com.board.app.domain;

import java.util.Date;

public class Comment {
    private Integer commentId;
    private String userId;
    private String  commentContent;
    private Date    commentRegDate;
    private Date    commentUpDate;
    private Integer commentParentId;
    private Integer boardId;

    public Comment() {}

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = XSSConverter.cleanXSS(commentContent);
    }

    public Date getCommentRegDate() {
        return commentRegDate;
    }

    public void setCommentRegDate(Date commentRegDate) {
        this.commentRegDate = commentRegDate;
    }

    public Date getCommentUpDate() {
        return commentUpDate;
    }

    public void setCommentUpDate(Date commentUpDate) {
        this.commentUpDate = commentUpDate;
    }

    public Integer getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(Integer commentParentId) {
        this.commentParentId = commentParentId;
    }

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", userId=" + userId +
                ", commentContent='" + commentContent + '\'' +
                ", commentRegDate=" + commentRegDate +
                ", commentUpDate=" + commentUpDate +
                ", commentParentId=" + commentParentId +
                ", boardId=" + boardId +
                '}';
    }
}
