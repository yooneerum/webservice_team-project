package org.example.teamproject.controller;

import org.example.teamproject.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    // 로그인 페이지
    @GetMapping("/login")
    public String loginForm() {
        return "login/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(UserVO user, HttpSession session) {

        // ===== 임시 테스트 계정 (DB 연결 전) =====
        if ("student".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            user.setRole("STUDENT");
        } else if ("parent".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            user.setRole("PARENT");
        } else if ("teacher".equals(user.getUsername()) && "1234".equals(user.getPassword())) {
            user.setRole("TEACHER");
        } else {
            return "login/login_fail";
        }
        // ======================================

        // 세션에 로그인 정보 저장
        session.setAttribute("loginUser", user);
        session.setAttribute("role", user.getRole());

        // 🔥 [추가된 핵심 로직]
        // 로그인 전에 가려던 페이지가 있으면 그곳으로 이동
        String redirectUrl = (String) session.getAttribute("redirectAfterLogin");
        if (redirectUrl != null) {
            session.removeAttribute("redirectAfterLogin");
            return "redirect:" + redirectUrl;
        }

        // 기본 역할별 홈 이동
        switch (user.getRole()) {
            case "STUDENT":
                return "redirect:/student/home";
            case "PARENT":
                return "redirect:/parent/home";
            case "TEACHER":
                return "redirect:/teacher/home";
            default:
                return "login/login_fail";
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
