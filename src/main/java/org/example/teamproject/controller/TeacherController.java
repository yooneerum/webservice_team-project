package org.example.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    // 선생님 메인
    @GetMapping("/home")
    public String home() {
        return "teacher/home";
    }

    // 학급 생성 페이지
    @GetMapping("/class/new")
    public String createClassForm() {
        return "teacher/class_create";
    }

    // 내 학급 조회
    @GetMapping("/class")
    public String myClass() {
        return "teacher/class_list";
    }

    // 공지 작성 페이지
    @GetMapping("/notice/new")
    public String writeNoticeForm() {
        return "teacher/notice_create";
    }

    // 내가 작성한 공지 조회
    @GetMapping("/notice")
    public String myNotice() {
        return "teacher/notice_list";
    }
}
