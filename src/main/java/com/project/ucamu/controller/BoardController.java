package com.project.ucamu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {


    @GetMapping
    public String getBoardList(){
        return "board/list";
    }

    @GetMapping("/write")
    public String getWrite(){
        return "board/write";
    }
}
