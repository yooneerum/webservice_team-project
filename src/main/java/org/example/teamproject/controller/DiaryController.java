package org.example.teamproject.controller;

import org.example.teamproject.DAO.DiaryDAO;
import org.example.teamproject.vo.PostVO;
import org.example.teamproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private DiaryDAO diaryDAO;

    // 전체 일기
    @GetMapping("/all")
    public String all(Model model) {
        model.addAttribute("diaries", diaryDAO.findAll());
        return "diary/diary_all";
    }

    // 우리반 일기
    @GetMapping("/class")
    public String classDiary(HttpSession session, Model model) {
        UserVO user = (UserVO) session.getAttribute("loginUser");
        model.addAttribute("diaries",
                diaryDAO.findByClassCode(user.getClassCode()));
        return "diary/diary_class";
    }

    // 내 일기
    @GetMapping("/mine")
    public String myDiary(HttpSession session, Model model) {
        UserVO user = (UserVO) session.getAttribute("loginUser");
        model.addAttribute("diaries",
                diaryDAO.findByUserId(user.getId()));
        return "diary/diary_mine";
    }

    // 일기 작성 폼
    @GetMapping("/write")
    public String writeForm() {
        return "diary/diary_write";
    }

    // 일기 작성
    @PostMapping("/write")
    public String write(PostVO post, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("loginUser");

        post.setUserId(user.getId());
        post.setClassCode(user.getClassCode());

        diaryDAO.insert(post);
        return "redirect:/diary/mine";
    }

    // 일기 삭제 (본인 것만)
    @GetMapping("/delete")
    public String delete(@RequestParam int postId, HttpSession session) {
        UserVO user = (UserVO) session.getAttribute("loginUser");
        diaryDAO.deleteByPostIdAndUserId(postId, user.getId());
        return "redirect:/diary/mine";
    }

    // 일기 수정 폼
    @GetMapping("/edit")
    public String editForm(@RequestParam int postId,
                           HttpSession session,
                           Model model) {

        UserVO user = (UserVO) session.getAttribute("loginUser");
        PostVO post = diaryDAO.findById(postId);

        if (post == null || post.getUserId() != user.getId()) {
            return "redirect:/diary/mine";
        }

        model.addAttribute("post", post);
        return "diary/diary_edit";
    }

    // 일기 수정 처리
    @PostMapping("/edit")
    public String edit(PostVO post, HttpSession session) {

        UserVO user = (UserVO) session.getAttribute("loginUser");
        PostVO origin = diaryDAO.findById(post.getPostId());

        if (origin == null || origin.getUserId() != user.getId()) {
            return "redirect:/diary/mine";
        }

        diaryDAO.update(post);
        return "redirect:/diary/mine";
    }
}
