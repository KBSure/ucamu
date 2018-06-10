package com.project.ucamu.service.impl;

import com.project.ucamu.domain.Board;
import com.project.ucamu.repository.BoardRepository;
import com.project.ucamu.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {

//    @Autowired
//    BoardRepository boardRepository;

    @Override
    public void addBoard(Board board) {
        //이미 된 것 : content, id, user, category(컨트롤에서),
        //비워 둘 것 : commentList
        //구현 안되서 처리 아직 안 할 것 : imageList

        //임의로 title을 how 내용으로 선정.


//        board.setTitle(board.getContent().getHow());
//        board.setView(0L);
//        board.setGreat(0);
//        boardRepository.save(board);
        return;
    }
}
