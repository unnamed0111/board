package com.board.app.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class PageHandler {
//    private Integer page = 1; // 현재 페이지, 사용자 입력
//    private Integer pageSize = 10; // 사용자 입력
//    private String keyword = "";
//    private String option = "";
    private SearchCondition sc;

    private Integer beginPage; // 3 {(page-1)/navSize} * navSize + 1
    private Integer endPage; // 4 beginPage + (navSize-1) > totalPage 이면 totalPage -> 둘중 가장 작은 값
    private Integer navSize = 10; // 서버 입력
    private Integer totalCnt; // 1 총 게시물 수
    private Integer totalPage; // 2 totalCnt에서 pageSize를 나누고 올림한값
    private boolean showPrev=false;
    private boolean showNext=false;

    public PageHandler() {}

    public PageHandler(SearchCondition sc, Integer totalCnt) {
        this.sc = sc;
        this.totalCnt = totalCnt;

        doPaging(sc, totalCnt);
    }

    public void doPaging(SearchCondition sc, Integer totalCnt) {
        this.totalPage = (int) Math.ceil(((float) totalCnt) / sc.getPageSize());

        this.beginPage = ((sc.getPage()-1) / this.navSize) * this.navSize + 1;
        this.endPage = Math.min(totalPage, beginPage + (navSize - 1));
        this.showPrev = this.beginPage != 1;
        this.showNext = !this.endPage.equals(this.totalPage);
    }

    public Integer getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(Integer beginPage) {
        this.beginPage = beginPage;
    }

    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }

    public Integer getNavSize() {
        return navSize;
    }

    public void setNavSize(Integer navSize) {
        this.navSize = navSize;
    }

    public Integer getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(Integer totalCnt) {
        this.totalCnt = totalCnt;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "sc=" + sc +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", navSize=" + navSize +
                ", totalCnt=" + totalCnt +
                ", totalPage=" + totalPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
