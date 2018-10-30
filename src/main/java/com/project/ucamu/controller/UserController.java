package com.project.ucamu.controller;

import com.project.ucamu.dto.UserFormDto;
import com.project.ucamu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

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
    public String postJoin(@Valid UserFormDto userFormDto, BindingResult result, RedirectAttributes flash){
//        if(result.hasErrors()){
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            flash.addAttribute("fieldErrors", fieldErrors);
//            flash.addAttribute("userFormDto", userFormDto);
//            return "redirect:/user/join";
//        }
        userService.addUser(userFormDto); //save된 User 리턴 받음
        return "redirect:/user/login"; //임시
    }

    @GetMapping(path = "/login")
    public String getLogin(){
        return "test/user/login";
    }

//    @GetMapping("/info")
//    public String getInfo(Principal principal){
//        return "test/user/info";
//    }

}