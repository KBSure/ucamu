package com.project.ucamu.controller;

import com.project.ucamu.common.Pagination;
import com.project.ucamu.domain.Board;
import com.project.ucamu.domain.Comment;
import com.project.ucamu.domain.User;
import com.project.ucamu.dto.ContentFormDto;
import com.project.ucamu.dto.SearchStyle;
import com.project.ucamu.service.BoardService;
import com.project.ucamu.service.CommentService;
import com.project.ucamu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
//import java.security.Principal;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

//    @Autowired
//    CommentService commentService;

    @GetMapping(path = "/{category}")
    public String getBoardList(@PathVariable(value = "category")String categoryName, @RequestParam(name = "sortType", required = false)String sortType,
                               @RequestParam(name = "searchType", required = false)String searchType, @RequestParam(name = "searchStr", required = false)String searchStr,
                               @RequestParam(name = "pageNum", required = false)Integer pageNum, ModelMap modelMap){
//해당 카테고리의 리스트들을 페이징처리 해서 boardList를 modelMap에 넘긴다.
        Page<Board> boardPage = boardService.getBoardList(categoryName, sortType, searchType, searchStr, pageNum, 15);//categoryName, SortType, SearchType, SearcyStr, PageNum
        List<Board> boardList = boardPage.getContent();

        Pagination pagination = new Pagination(boardPage.getNumber() + 1, 10, boardPage.getTotalElements(), boardPage.getTotalPages());
        modelMap.addAttribute("category", boardService.getCategory(categoryName));
        modelMap.addAttribute(boardList);
        modelMap.addAttribute(pagination);
        modelMap.addAttribute(new SearchStyle(categoryName, sortType, searchType, searchStr));
//        return "board/list";
        return "test/board/list";
    }

    @GetMapping(path = "/{category}/write")
    public String getWrite(@PathVariable(value = "category") String categoryName, ModelMap modelMap){
        modelMap.addAttribute("category", categoryName);
        modelMap.addAttribute("boardFormDto", new ContentFormDto());
//        return "board/write";
        return "test/board/write";
    }

    //category가 유효하지 않도록 접근 한 경우 예외 처리 해야 한다.
    @PostMapping(path = "/{category}/write")
    public String postWrite(@Valid ContentFormDto boardFormDto, @PathVariable(value = "category") String categoryName, Principal principal){
        //        User user = userService.getUser((User)request.getAttribute("loginUser").getId());
        User user = userService.getUser(principal.getName());
        Board board = new Board();
        board.setUser(user);
        board.setCategory(boardService.getCategory(categoryName)); //잘못된 카테고리가 들어왔다면? 오류 페이지?
        Board saveBoard = boardService.addBoard(board, boardFormDto);
        return "redirect:/board/" + categoryName + "/"+  saveBoard.getId();
    }

    @GetMapping(path = "/{category}/{boardId}")
    public String getDetail(@PathVariable(value = "category")String categoryName, @PathVariable(value = "boardId")Long boardId, ModelMap modelMap){
        //boardId에 해당하는 board Entity을 불러와야 한다. (카테고리 체크를 해봐도 좋다)
        Board board = boardService.getBoard(boardId, true);
        modelMap.addAttribute(board);
        modelMap.addAttribute("commentFormDto", new ContentFormDto());
//        return "board/detail";
        return "test/board/detail";
    }

    @GetMapping(path = "/{category}/{boardId}/rewrite")
    public String getRewrite(@PathVariable(value = "category")String categoryName, @PathVariable(value = "boardId")Long boardId, ModelMap modelMap){
        Board board = boardService.getBoard(boardId, false);
        modelMap.addAttribute(board);
        modelMap.addAttribute("category", categoryName);
        modelMap.addAttribute("boardFormDto", new ContentFormDto());
        return "test/board/rewrite";
    }

    @PostMapping(path = "/{category}/{boardId}/rewrite")
    public String putRewrite(@PathVariable(value = "category")String categoryName, @PathVariable(value = "boardId")Long boardId, ContentFormDto boardFormDto){
        boardService.updateBoard(boardId, boardFormDto);
        return "redirect:/board/" + categoryName + "/" + boardId;
    }

    @PostMapping(path = "/{category}/delete")
    public String deleteDelete(@PathVariable(value = "category")String categoryName, Long boardId, Principal principal){
        boardService.deleteBoard(boardId);
        return "redirect:/board/" + categoryName;
    }

    @GetMapping(path = "/{category}/{boardId}/great")
    public String getGreat(@PathVariable(value = "category")String categoryName, @PathVariable(value = "boardId")Long boardId, Principal principal){
        Board board = boardService.getBoard(boardId, false);
        User user = board.getUser();
        if(!board.getGreatUserList().contains(user)){
           boardService.greatBoard(boardId, user);
        }
        return "redirect:/board/" + categoryName + "/" + boardId;
    }

    @PostMapping(path = "/{category}/{boardId}/reply/write")
    public String postReplyWrite(@PathVariable(value = "category")String categoryName, @PathVariable(value = "boardId")Long boardId, ContentFormDto commentFormDto, Principal principal){
        Comment comment = new Comment();
        User user = userService.getUser(principal.getName());
        comment.setUser(user);
        comment.setBoard(boardService.getBoard(boardId, false));
        commentService.addComment(comment, commentFormDto);
        return "redirect:/board/" + categoryName + "/" + boardId;
    }

    @PostMapping(path = "/{category}/reply/delete")
    String deleteReplyDelete(@PathVariable(value = "category")String categoryName, Long boardId, Long commentId){
        commentService.deleteComment(commentId);
        return "redirect:/board/" + categoryName + "/" + boardId;
    }
}
