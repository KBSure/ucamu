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
    public void addBoard(Board board, BoardFormDto boardFormDto) {
        //image 등록도 진행해야함
        board.setContent(new Content());
        BeanUtils.copyProperties(boardFormDto, board.getContent());
        //title 임의로 how 지정
        board.setTitle(board.getContent().getHow());
        board.setGreat(0);
        board.setView(0L);
        board.setDate(new NormalDate(LocalDateTime.now(), LocalDateTime.now()));
        boardRepository.save(board);
        return;
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategory(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    //    @Override
//    public void addBoard(Board board) {
//        //이미 된 것 : content, id, user, category(컨트롤에서),
//        //비워 둘 것 : commentList
//        //구현 안되서 처리 아직 안 할 것 : imageList
//
//        //임의로 title을 how 내용으로 선정.
//
//
////        board.setTitle(board.getContent().getHow());
////        board.setView(0L);
////        board.setGreat(0);
////        boardRepository.save(board);
//        return;
//    }
}
