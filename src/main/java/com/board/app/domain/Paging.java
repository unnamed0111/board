package com.board.app.domain;

public class Paging {
    private Integer page = 1; // 현재 페이지, 사용자 입력
    private Integer beginPage; // 3 {(page-1)/navSize} * navSize + 1
    private Integer endPage; // 4 beginPage + (navSize-1) > totalPage 이면 totalPage -> 둘중 가장 작은 값
    private Integer navSize = 10; // 사용자 입력
    private Integer pageSize = 10; // 사용자 입력
    private Integer totalCnt; // 1 총 게시물 수
    private Integer totalPage; // 2 totalCnt에서 pageSize를 나누고 올림한값
    private boolean showPrev=false;
    private boolean showNext=false;

    public Paging() {}

    public Paging(Integer page, Integer totalCnt) {
        this.page = page;
        this.totalCnt = totalCnt;

        doPaging();
    }

    public void doPaging() {
        this.totalPage = (int) Math.ceil(((float) totalCnt) / this.pageSize);

        if(this.page > this.totalPage) this.page = totalPage;
        if(this.page < 1) this.page = 1;

        this.beginPage = ((this.page-1) / this.navSize) * this.navSize + 1;
        this.endPage = Math.min(totalPage, beginPage + (navSize - 1));

        this.showPrev = this.beginPage != 1;
        this.showNext = !this.endPage.equals(this.totalPage);
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    @Override
    public String toString() {
        return "Paging{" +
                "page=" + page +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", navSize=" + navSize +
                ", pageSize=" + pageSize +
                ", totalCnt=" + totalCnt +
                ", totalPage=" + totalPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
