package com.project.ucamu.service.impl;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.Category;
import com.project.ucamu.domain.embeddable.Content;
import com.project.ucamu.domain.embeddable.NormalDate;
import com.project.ucamu.dto.BoardFormDto;
import com.project.ucamu.repository.BoardRepository;
import com.project.ucamu.repository.CategoryRepository;
import com.project.ucamu.service.BoardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Board addBoard(Board board, BoardFormDto boardFormDto) {
        //image 등록도 진행해야함
        board.setContent(new Content());
        BeanUtils.copyProperties(boardFormDto, board.getContent());
        //title 임의로 how 지정
        board.setTitle(board.getContent().getHow());
        board.setGreat(0);
        board.setView(0L);
        board.setDate(new NormalDate(LocalDateTime.now(), LocalDateTime.now()));
        return boardRepository.save(board);
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategory(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    @Override
    public Board getBoard(Long boardId) {
        return boardRepository.findById(boardId).get();
    }
}
