package com.project.ucamu.service.impl;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.Category;
import com.project.ucamu.domain.User;
import com.project.ucamu.domain.embeddable.Content;
import com.project.ucamu.domain.embeddable.NormalDate;
import com.project.ucamu.dto.ContentFormDto;
import com.project.ucamu.repository.BoardRepository;
import com.project.ucamu.repository.CategoryRepository;
import com.project.ucamu.service.BoardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Board addBoard(Board board, ContentFormDto boardFormDto) {
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
    @Transactional
    public Board updateBoard(Long boardId, ContentFormDto boardFormDto) {
        Board oldBoard = boardRepository.findById(boardId).get();
        BeanUtils.copyProperties(boardFormDto, oldBoard.getContent());
        oldBoard.setTitle(oldBoard.getContent().getHow());
        oldBoard.getDate().setUpDate(LocalDateTime.now());
        return boardRepository.save(oldBoard);
    }

    @Override
    @Transactional(readOnly = true)
    public Category getCategory(String categoryName) {
        return categoryRepository.findCategoryByName(categoryName);
    }

    @Override
    @Transactional
    public Board getBoard(Long boardId, boolean viewUp) {
        Board board = boardRepository.findById(boardId).get();
        if(viewUp) board.setUpView();
        return board;
    }

    @Override
    public Page<Board> getBoardList(String categoryName, String sortType, String searchType, String searchStr, Integer pageNum, Integer pageSize) {
        //sort시킨 것, Search관련, pageNum
        //sortType에는 우선 최신순, 공감순, 조회순으로 할 것

        Sort sort = createSort(sortType);
        if(pageNum == null){
            pageNum = 1;
        }
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize, sort);

        return boardRepository.findBoardList(categoryName, pageable, searchType, searchStr);

    }

    @Override
    @Transactional
    public boolean deleteBoard(Long boardId) {
        boardRepository.deleteById(boardId);
        return true;
    }

    @Override
    public boolean greatBoard(Long boardId, User user) {
        Board board = boardRepository.findById(boardId).get();
        board.setGreat(board.getGreat() + 1);
        board.addGreatUser(user);
        boardRepository.save(board);
        return true;
    }

    private enum SortType{
        NEW, GREAT, VIEW
    }

    private Sort createSort(String sortType){
        if(sortType == null || "".equals(sortType)){
            return Sort.by(Sort.Direction.DESC, "id");
        }
        String sortTypeUpper = sortType.toUpperCase();
        switch (SortType.valueOf(sortTypeUpper)){
            case NEW:
                return Sort.by(Sort.Direction.DESC, "id");
            case GREAT:
                return Sort.by(Sort.Direction.DESC, "great");
            case VIEW:
                return Sort.by(Sort.Direction.DESC, "view");
//            default : //잘못된 sortType이 넘어왔을 때
        }
        return Sort.by(Sort.Direction.DESC, "id");
    }
}
