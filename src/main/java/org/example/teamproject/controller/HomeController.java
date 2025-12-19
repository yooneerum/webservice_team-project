package org.example.teamproject.controller;

import org.example.teamproject.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;


@Controller
public class HomeController {

    @GetMapping("/main")
    public String home(HttpSession session) {

        UserVO loginUser = (UserVO) session.getAttribute("loginUser");

        if (loginUser == null) {
            return "redirect:/login";
        }

        switch (loginUser.getRole()) {
            case "STUDENT":
                return "redirect:/student/home";
            case "PARENT":
                return "redirect:/parent/home";
            case "TEACHER":
                return "redirect:/teacher/home";
            default:
                return "redirect:/login";
        }
    }
}
