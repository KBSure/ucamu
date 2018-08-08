package com.project.ucamu.service;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.Category;
import com.project.ucamu.dto.BoardFormDto;

import java.util.List;


public interface BoardService {
    Board addBoard(Board board, BoardFormDto boardFormDto);
    Board getBoard(Long boardId);
    Category getCategory(String categoryName);
    List<Board> getBoardList(String categoryName, String sortType, String searchType, String searchStr, Integer pageNum);
    //categoryName, SortType, SearchType, SearcyStr, PageNum

}
