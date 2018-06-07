package com.project.ucamu.service;

import com.project.ucamu.domain.Board;
import org.springframework.stereotype.Service;

@Service
public interface BoardService {
    void addBoard(Board board);
}
