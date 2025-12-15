package org.example.teamproject.interceptor;

import org.example.teamproject.vo.UserVO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        HttpSession session = request.getSession();
        UserVO user = (UserVO) session.getAttribute("loginUser");

        String uri = request.getRequestURI();

        // 로그인 안 한 경우
        if (user == null) {
            session.setAttribute("redirectAfterLogin", uri);
            response.sendRedirect("/login");
            return false;
        }


        String role = user.getRole();

        // 학생만 일기 작성 가능
        if (uri.startsWith("/diary/write") && !role.equals("STUDENT")) {
            response.sendRedirect("/diary/all");
            return false;
        }

        // 역할별 접근 제한
        if (uri.startsWith("/student") && !role.equals("STUDENT")) return false;
        if (uri.startsWith("/parent") && !role.equals("PARENT")) return false;
        if (uri.startsWith("/teacher") && !role.equals("TEACHER")) return false;

        return true;
    }
}
