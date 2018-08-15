package com.project.ucamu.controller;

import com.project.ucamu.dto.UserFormDto;
import com.project.ucamu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path = "/join")
    public String getJoin(ModelMap modelMap){
        modelMap.addAttribute(new UserFormDto());
       return "test/user/join";
    }

    @PostMapping(path = "/join")
    public String postJoin(@Valid UserFormDto userFormDto){
        userService.addUser(userFormDto);
        return "redirect:/";
    }
}
