package org.example.teamproject.controller;

import javax.servlet.http.HttpSession;

import org.example.teamproject.DAO.CommentDAO;
import org.example.teamproject.vo.CommentVO;
import org.example.teamproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentDAO commentDAO;

    // 댓글 작성
    @PostMapping("/write")
    public String write(CommentVO comment, HttpSession session) {

        UserVO user = (UserVO) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/login";
        }

        comment.setWriter(user.getUsername());
        commentDAO.insert(comment);

        return "redirect:/notice/detail?id=" + comment.getNoticeId();
    }

    // 댓글 수정
    @PostMapping("/update")
    public String update(CommentVO comment) {
        commentDAO.update(comment);
        return "redirect:/notice/detail?id=" + comment.getNoticeId();
    }

    // 댓글 삭제
    @GetMapping("/delete")
    public String delete(int id, int noticeId) {
        commentDAO.delete(id);
        return "redirect:/notice/detail?id=" + noticeId;
    }
}
