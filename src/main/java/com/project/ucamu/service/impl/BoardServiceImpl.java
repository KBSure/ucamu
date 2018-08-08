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

    @Override
    public List<Board> getBoardList(String categoryName, String sortType, String searchType, String searchStr, Integer pageNum) {
        //sort시킨 것, Search관련, pageNum
        //sortType에는 우선 최신순, 공감순, 조회순으로 할 것

        Sort sort = createSort(sortType);
        if(pageNum == null){
            pageNum = 1;
        }
        Pageable pageable = PageRequest.of(pageNum - 1, 10, sort);

         //조건에 해당되는 boardList를 뽑아온다. custom한다.
        return boardRepository.findBoardList(categoryName, pageable, searchType, searchStr);

    }

    private enum SortType{
        NEW, GREAT, VIEW
    }

    private Sort createSort(String sortType){
        if(sortType == null){
            return Sort.by(Sort.Direction.DESC, "id");
        }
        String sortTypeUpper = sortType.toUpperCase();
        switch (SortType.valueOf(sortTypeUpper)){
            case NEW:
                return Sort.by(Sort.Direction.DESC, "id");
            case GREAT:
                return Sort.by(Sort.Direction.ASC, "great");
            case VIEW:
                return Sort.by(Sort.Direction.ASC, "view");
//            default : //잘못된 sortType이 넘어왔을 때
        }
        return Sort.by(Sort.Direction.DESC, "id");
    }
}
