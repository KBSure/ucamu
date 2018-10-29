package com.project.ucamu.service;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.Category;
import com.project.ucamu.domain.User;
import com.project.ucamu.dto.ContentFormDto;
import org.springframework.data.domain.Page;


public interface BoardService {
    Board addBoard(Board board, ContentFormDto boardFormDto);
    Board updateBoard(Long boardId, ContentFormDto boardFormDto);
    Board getBoard(Long boardId, boolean viewUp);
    Category getCategory(String categoryName);
    Page<Board> getBoardList(String categoryName, String sortType, String searchType, String searchStr, Integer pageNum, Integer pageSize);
    boolean deleteBoard(Long boardId);
    boolean greatBoard(Long boardId, User user);
    //categoryName, SortType, SearchType, SearcyStr, PageNum

}
