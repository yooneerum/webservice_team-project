package org.example.teamproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    // 전체 일기
    @GetMapping("/all")
    public String all(Model model) {
        List<String> diaries = Arrays.asList(
                "오늘은 체육 시간이 재밌었다",
                "수학 시험을 잘 봤다",
                "친구랑 싸웠지만 화해했다"
        );
        model.addAttribute("diaries", diaries);
        return "diary/diary_all";
    }

    // 우리반 일기
    @GetMapping("/class")
    public String classDiary(Model model) {
        List<String> diaries = Arrays.asList(
                "우리반 체육대회 연습",
                "반 친구 생일 파티"
        );
        model.addAttribute("diaries", diaries);
        return "diary/diary_class";
    }

    // 내 일기
    @GetMapping("/mine")
    public String myDiary(Model model) {
        List<String> diaries = Arrays.asList(
                "내 일기 1",
                "내 일기 2"
        );
        model.addAttribute("diaries", diaries);
        return "diary/diary_mine";
    }
}
