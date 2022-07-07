package com.board.app.domain;

public class Test {
    private String content;
    private Integer id;

    public Test() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Test{" +
                "content='" + content + '\'' +
                ", id=" + id +
                '}';
    }
}
