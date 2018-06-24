package com.project.ucamu.repository.custom;

import com.project.ucamu.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardRepositoryCustom {
    //findBoardList
    List<Board> findBoardList(String categoryName, Pageable pageable, String searchType, String searchStr);
}