package org.example.teamproject.controller;

import javax.servlet.http.HttpSession;

import org.example.teamproject.DAO.CommentDAO;
import org.example.teamproject.vo.CommentVO;
import org.example.teamproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentDAO commentDAO;

    /* ======================
       댓글 작성
     ====================== */
    @PostMapping("/write")
    public String write(CommentVO comment, HttpSession session) {

        UserVO user = (UserVO) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/login";
        }

        comment.setWriterId(user.getId());
        commentDAO.insert(comment);

        return "redirect:/notice/detail?id=" + comment.getNoticeId();
    }

    /* ======================
       댓글 수정
     ====================== */
    @PostMapping("/update")
    public String update(CommentVO comment, HttpSession session) {

        UserVO user = (UserVO) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/login";
        }

        // 🔐 본인 댓글만 수정 가능
        CommentVO origin = commentDAO.findById(comment.getId());
        if (origin == null || origin.getWriterId() != user.getId()) {
            return "redirect:/notice/detail?id=" + comment.getNoticeId();
        }

        commentDAO.update(comment);
        return "redirect:/notice/detail?id=" + comment.getNoticeId();
    }

    /* ======================
       댓글 삭제
     ====================== */
    @PostMapping("/delete")
    public String delete(@RequestParam int id,
                         @RequestParam int noticeId,
                         HttpSession session) {

        UserVO user = (UserVO) session.getAttribute("loginUser");
        if (user == null) {
            return "redirect:/login";
        }

        // 🔐 본인 댓글만 삭제 가능
        CommentVO origin = commentDAO.findById(id);
        if (origin == null || origin.getWriterId() != user.getId()) {
            return "redirect:/notice/detail?id=" + noticeId;
        }

        commentDAO.delete(id);
        return "redirect:/notice/detail?id=" + noticeId;
    }
}
