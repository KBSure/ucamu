package com.project.ucamu.controller;

import com.project.ucamu.domain.Board;
import com.project.ucamu.service.BoardService;
import javafx.scene.control.TableColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    BoardService boardService;

    @GetMapping
    public String getMain(ModelMap modelMap){
        //공지사항 카테고리 게시글
        Page<Board> noticePage = boardService.getBoardList("notice", "NEW", null, null, 1, 10);
        modelMap.addAttribute("noticeList", noticePage.getContent());
        Page<Board> greatPage = boardService.getBoardList(null, "GREAT", null, null, 1, 10);
        modelMap.addAttribute("greatList", greatPage.getContent());
        Page<Board> issuePage = boardService.getBoardList("issue", "NEW", null, null, 1, 10);
        modelMap.addAttribute("issueList", issuePage.getContent());
        Page<Board> discussionPage = boardService.getBoardList("discussion", "NEW", null, null, 1, 10);
        modelMap.addAttribute("discussionList", discussionPage.getContent());
        return "test/main/main";
    }
}
