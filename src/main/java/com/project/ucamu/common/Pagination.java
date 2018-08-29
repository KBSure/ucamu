package com.project.ucamu.common;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Pagination {
    private int thisPage; //선택된 현재 페이지
    private int buttonSIze; //최대로 보여질 페이지 버튼 수
    private long totalCount; //전체 게시물 수
    private int totalPage; //전체 페이지 수
    private int startPage;
    private int endPage;

    public Pagination(int thisPage, int buttonSIze, long totalCount, int totalPage){
        this.thisPage = thisPage;
        this.buttonSIze = buttonSIze;
        this.totalCount = totalCount;
        this.totalPage = totalPage;
        init();
    }

    private void init(){
        this.startPage = (thisPage - 1) / buttonSIze * buttonSIze + 1;
        this.endPage = startPage + buttonSIze - 1 > totalPage ? totalPage : startPage + buttonSIze - 1;
        if(endPage > totalPage) endPage = totalPage;
        if(endPage == 0) endPage = 1;
    }

    public int getPrevPage(){
        int prevPage =  getStartPage() - 1;
        if(prevPage <= 0){
            prevPage = 0;
        }
        return prevPage;
    }

    public int getNextPage(){
        int nextPage = getEndPage() + 1;
        if(nextPage > totalPage){
            nextPage = 0;
        }
        return nextPage;
    }
}
