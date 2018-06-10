package com.project.ucamu.service;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.Category;
import com.project.ucamu.dto.BoardFormDto;


public interface BoardService {
    void addBoard(Board board, BoardFormDto boardFormDto);
    Category getCategory(String Category);
}
