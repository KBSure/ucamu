package com.project.ucamu.dto;


import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchStyle {
    private String categoryName;
    private String sortType;
    private String searchType;
    private String searchStr;

    public SearchStyle(String categoryName, String sortType, String searchType, String searchStr){
        this.categoryName = categoryName;
        this.sortType = sortType;
        this.searchType = searchType;
        this.searchStr = searchStr;
    }
}
