package org.example.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/parent")
public class ParentController {

    @GetMapping("/home")
    public String parentHome() {
        return "parent/home";
    }
}
