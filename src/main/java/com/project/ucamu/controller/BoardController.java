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

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @GetMapping
    public String getBoardList(){
        return "board/list";
    }

    @GetMapping("/{category}/write")
    public String getWrite(@PathVariable(value = "category") String categoryName, ModelMap modelMap){
        modelMap.addAttribute("category", categoryName);
        return "board/write";
    }

    //category가 유효하지 않도록 접근 한 경우 예외 처리 해야 한다.
    @PostMapping("/{category}/write")
    public String postWrite(@Valid BoardFormDto boardFormDto, @PathVariable(value = "category") String categoryName){

        User user = userService.getUser("kbs");
//      User user = userService.getUser(principal.getName());
        Board board = new Board();
        board.setUser(user);
        board.setCategory(boardService.getCategory(categoryName));
        Board saveBoard = boardService.addBoard(board, boardFormDto);

        return "redirect:/board/" + categoryName + "/"+  saveBoard.getId() + "";
    }

}
