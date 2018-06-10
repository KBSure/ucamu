package com.project.ucamu.controller;

import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.User;
import com.project.ucamu.service.BoardService;
import com.project.ucamu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/board")
public class BoardController {

//    @Autowired
//    BoardService boardService;
//
//    @Autowired
//    UserService userService;

    @GetMapping
    public String getBoardList(){
        return "board/list";
    }

    @GetMapping("/{category}/write")
    public String getWrite(@PathVariable(value = "category") String category, ModelMap modelMap){
        modelMap.addAttribute("category", category);
        return "board/write";
    }

    @PostMapping("/{category}/write")
    public String postWrite(Board board, @PathVariable(value = "category") String category){
        // 선행 : 글 작성한 데이터 Board Entity에 자동으로 들어가도록 input name 체크

        // Board Entity 영속성 부여 DB 저장

//        userService.getUser(principal.getName());
//        User user = userService.getUser("kbs");
//        board.setUser(user);
//        //addBoard에서 나머지 필드값을 채워준다.
//        boardService.addBoard(board);

        return "redirect:/board?";
    }

}
