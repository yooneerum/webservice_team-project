package org.example.teamproject.controller;

import org.example.teamproject.vo.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    // 로그인 화면 이동
    @GetMapping("/login")
    public String loginForm() {
        return "login/login";
    }

    // 로그인 처리
    @PostMapping("/login")
    public String login(UserVO user, HttpSession session) {

        // ★ DB 아직 없으므로 테스트용 임시 계정 사용 ★
        // 나중에 Service/Repository/MyBatis로 교체됨.

        if (user.getUsername().equals("student") && user.getPassword().equals("1234")) {
            user.setRole("STUDENT");
        } else if (user.getUsername().equals("parent") && user.getPassword().equals("1234")) {
            user.setRole("PARENT");
        } else if (user.getUsername().equals("teacher") && user.getPassword().equals("1234")) {
            user.setRole("TEACHER");
        } else {
            return "login/login_fail";  // 실패 페이지
        }

        // 로그인 성공 → 세션 저장
        session.setAttribute("loginUser", user);
        session.setAttribute("role", user.getRole());

        // 역할별 이동
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
