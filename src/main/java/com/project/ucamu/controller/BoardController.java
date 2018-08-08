package com.project.ucamu.controller;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.User;
import com.project.ucamu.dto.BoardFormDto;
import com.project.ucamu.service.BoardService;
import com.project.ucamu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
//import java.security.Principal;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @GetMapping(path = "/{category}")
    public String getBoardList(@PathVariable(value = "category")String categoryName, @RequestParam(name = "sortType", required = false)String sortType,
                               @RequestParam(name = "searchType", required = false)String searchType, @RequestParam(name = "searchStr", required = false)String searchStr,
                               @RequestParam(name = "pageNum", required = false)Integer pageNum, ModelMap modelMap){
        modelMap.addAttribute("category", categoryName);
//해당 카테고리의 리스트들을 페이징처리 해서 boardList를 modelMap에 넘긴다.
        List<Board> boardList = boardService.getBoardList(categoryName, sortType, searchType, searchStr, pageNum);//categoryName, SortType, SearchType, SearcyStr, PageNum
        modelMap.addAttribute(boardList);
//        return "board/list";
        return "test/board/list";
    }

    @GetMapping(path = "/{category}/write")
    public String getWrite(@PathVariable(value = "category") String categoryName, ModelMap modelMap){
        modelMap.addAttribute("category", categoryName);
        modelMap.addAttribute(new BoardFormDto());
//        return "board/write";
        return "test/board/write";
    }

    //category가 유효하지 않도록 접근 한 경우 예외 처리 해야 한다.
    @PostMapping(path = "/{category}/write")
    public String postWrite(@Valid BoardFormDto boardFormDto, @PathVariable(value = "category") String categoryName){

        User user = userService.getUser("kbs");
//      User user = userService.getUser(principal.getName());
        Board board = new Board();
        board.setUser(user);
        board.setCategory(boardService.getCategory(categoryName));
        Board saveBoard = boardService.addBoard(board, boardFormDto);
        return "redirect:/board/" + categoryName + "/"+  saveBoard.getId() + "";
    }

    @GetMapping(path = "/{category}/{boardId}")
    public String getDetail(@PathVariable(value = "category")String categoryName, @PathVariable(value = "boardId")Long boardId, ModelMap modelMap){
        //boardId에 해당하는 board Entity을 불러와야 한다. (카테고리 체크를 해봐도 좋다)
        Board board = boardService.getBoard(boardId);
        modelMap.addAttribute(board);
//        return "board/detail";
        return "test/board/detail";
    }

}
