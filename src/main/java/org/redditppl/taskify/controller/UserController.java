package org.redditppl.taskify.controller;

import lombok.RequiredArgsConstructor;
import org.redditppl.taskify.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/users/list")
    public String getAllUsers(Model model){
        model.addAttribute("users",userService.getAllUsers());
        return "list-all-users";
    }


}
