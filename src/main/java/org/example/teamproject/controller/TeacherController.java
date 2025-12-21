package org.example.teamproject.controller;

import org.example.teamproject.DAO.ClassDAO;
import org.example.teamproject.DAO.NoticeDAO;
import org.example.teamproject.DAO.UserDAO;
import org.example.teamproject.vo.ClassVO;
import org.example.teamproject.vo.NoticeVO;
import org.example.teamproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private ClassDAO classDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private NoticeDAO noticeDAO;

    // =====================
    // 로그인 + 교사 체크
    // =====================
    private UserVO requireTeacher(HttpSession session) {
        UserVO loginUser = (UserVO) session.getAttribute("loginUser");
        if (loginUser == null) return null;
        if (!"TEACHER".equals(loginUser.getRole())) return null;
        return loginUser;
    }

    // =====================
    // 교사 홈
    // =====================
    @GetMapping("/home")
    public String home(HttpSession session) {
        if (requireTeacher(session) == null) {
            return "redirect:/login";
        }
        return "teacher/home";
    }

    // =====================
    // 내가 만든 학급 목록
    // =====================
    @GetMapping("/class")
    public String myClasses(HttpSession session, Model model) {
        UserVO teacher = requireTeacher(session);
        if (teacher == null) {
            return "redirect:/login";
        }

        List<ClassVO> classList = classDAO.findByTeacherId(teacher.getId());
        model.addAttribute("classList", classList);

        return "teacher/class_list";
    }

    // =====================
    // 새 학급 만들기 (폼)
    // =====================
    @GetMapping("/class/new")
    public String createClassForm(HttpSession session) {
        if (requireTeacher(session) == null) {
            return "redirect:/login";
        }
        return "teacher/class_create";
    }

    // =====================
    // 새 학급 만들기 (처리)
    // =====================
    @PostMapping("/class/new")
    public String createClass(
            @RequestParam String className,
            HttpSession session
    ) {
        UserVO teacher = requireTeacher(session);
        if (teacher == null) {
            return "redirect:/login";
        }

        ClassVO clazz = new ClassVO();
        clazz.setClassName(className);
        clazz.setTeacherId(teacher.getId());
        clazz.setClassCode(classDAO.generateClassCode());

        classDAO.insertClass(clazz);
        return "redirect:/teacher/class";
    }

    // =====================
    // 학급 상세 보기
    // =====================
    @GetMapping("/class/{classId}")
    public String classDetail(
            @PathVariable int classId,
            HttpSession session,
            Model model
    ) {
        UserVO teacher = requireTeacher(session);
        if (teacher == null) {
            return "redirect:/login";
        }

        ClassVO clazz = classDAO.findById(classId);

        // 본인 학급이 아니면 접근 차단
        if (clazz == null || clazz.getTeacherId() != teacher.getId()) {
            return "redirect:/teacher/class";
        }

        model.addAttribute("clazz", clazz);
        model.addAttribute(
                "students",
                userDAO.findStudentsByClassCode(clazz.getClassCode())
        );
        model.addAttribute(
                "parents",
                userDAO.findParentsByClassCode(clazz.getClassCode())
        );
        model.addAttribute(
                "notices",
                noticeDAO.findByClassCode(clazz.getClassCode())
        );

        return "teacher/class_detail";
    }

    // =====================
    // 학급 삭제 (JdbcTemplate 기반 DAO에 맞춘 최종 정답)
    // =====================
    @PostMapping("/class/delete")
    public String deleteClass(
            @RequestParam int classId,
            HttpSession session
    ) {
        UserVO teacher = requireTeacher(session);
        if (teacher == null) {
            return "redirect:/login";
        }

        // 🔥 이미 존재하는 DAO 메서드 사용
        classDAO.deleteByIdAndTeacherId(classId, teacher.getId());

        return "redirect:/teacher/class";
    }

    // =====================
    // 내가 쓴 공지 목록
    // =====================
    @GetMapping("/notice")
    public String myNoticeList(HttpSession session, Model model) {
        UserVO teacher = requireTeacher(session);
        if (teacher == null) {
            return "redirect:/login";
        }

        List<ClassVO> classes = classDAO.findByTeacherId(teacher.getId());
        List<NoticeVO> notices = noticeDAO.findByTeacherClasses(classes);

        model.addAttribute("notices", notices);
        return "teacher/notice_list";
    }

    // =====================
    // 공지 작성 폼
    // =====================
    @GetMapping("/notice/new")
    public String noticeCreateForm(HttpSession session, Model model) {
        UserVO teacher = requireTeacher(session);
        if (teacher == null) {
            return "redirect:/login";
        }

        model.addAttribute(
                "classList",
                classDAO.findByTeacherId(teacher.getId())
        );

        return "teacher/notice_create";
    }

    // =====================
    // 공지 작성 처리
    // =====================
    @PostMapping("/notice/new")
    public String noticeCreate(
            @RequestParam String classCode,
            @RequestParam String title,
            @RequestParam String content,
            HttpSession session
    ) {
        UserVO teacher = requireTeacher(session);
        if (teacher == null) {
            return "redirect:/login";
        }

        NoticeVO notice = new NoticeVO();
        notice.setClassCode(classCode);
        notice.setTitle(title);
        notice.setContent(content);
        notice.setWriterId(teacher.getId());

        noticeDAO.insert(notice);
        return "redirect:/teacher/notice";
    }
}
