package org.example.teamproject.controller;

import org.example.teamproject.DAO.CommentDAO;
import org.example.teamproject.DAO.NoticeDAO;
import org.example.teamproject.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeDAO noticeDAO;

    @Autowired
    private CommentDAO commentDAO;

    // =====================
    // 공지 목록
    // =====================
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("notices", noticeDAO.findAll());
        return "notice/list";
    }

    // =====================
    // 공지 상세
    // =====================
    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("notice", noticeDAO.findById(id));
        model.addAttribute("comments", commentDAO.findByNoticeId(id));
        return "notice/detail";
    }

    // =====================
    // 공지 삭제  🔥 수정된 부분
    // =====================
    @GetMapping("/delete")
    public String delete(@RequestParam int id) {
        noticeDAO.delete(id);   // ← 여기!
        return "redirect:/notice/list";
    }
}
