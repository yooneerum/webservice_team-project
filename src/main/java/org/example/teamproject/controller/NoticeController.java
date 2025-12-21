package org.example.teamproject.controller;

import org.example.teamproject.DAO.CommentDAO;
import org.example.teamproject.DAO.NoticeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeDAO noticeDAO;

    @Autowired
    private CommentDAO commentDAO;

    // 공지 목록
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("notices", noticeDAO.findAll());
        return "notice/list";
    }

    // 공지 상세
    @GetMapping("/detail")
    public String detail(@RequestParam int id, Model model) {
        model.addAttribute("notice", noticeDAO.findById(id));
        model.addAttribute("comments", commentDAO.findByNoticeId(id));
        return "notice/detail";
    }
}
