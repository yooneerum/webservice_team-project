package org.example.teamproject.controller;

import org.example.teamproject.DAO.UserDAO;
import org.example.teamproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("컨트롤러 username = " + user.getUsername());
        System.out.println("컨트롤러 password = " + user.getPassword());

        // 🔥 DB에서 사용자 조회
        UserVO loginUser = userDAO.findByUsernameAndPassword(
                user.getUsername(),
                user.getPassword()
        );

        // 로그인 실패
        if (loginUser == null) {
            return "login/login_fail";
        }

        // 로그인 성공 → 세션 저장
        session.setAttribute("loginUser", loginUser);
        session.setAttribute("role", loginUser.getRole());

        // 역할별 홈 이동
        switch (loginUser.getRole()) {
            case "STUDENT":
                return "redirect:/student/home";
            case "PARENT":
                return "redirect:/parent/home";
            case "TEACHER":
                return "redirect:/teacher/home";
            default:
                return "redirect:/";
        }
    }




    // 로그아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @Autowired
    private UserDAO userDAO;

    // 회원가입 페이지
    @GetMapping("/signup")
    public String signupForm() {
        return "login/signup";
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String signup(UserVO user) {

        // 학생 / 학부모인데 학급 코드 없으면 실패
        if (!"TEACHER".equals(user.getRole())
                && (user.getClassCode() == null || user.getClassCode().isEmpty())) {
            return "login/signup_fail";
        }

        userDAO.insertUser(user);
        return "redirect:/login";
    }

}


