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

        HttpSession session = request.getSession(false);
        String contextPath = request.getContextPath();
        String uri = request.getRequestURI();

        UserVO user = (session != null)
                ? (UserVO) session.getAttribute("loginUser")
                : null;

        // 로그인 안 한 경우
        if (user == null) {
            request.getSession(true).setAttribute("redirectAfterLogin", uri);
            response.sendRedirect(contextPath + "/login");
            return false;
        }

        String role = user.getRole();

        // ✅ 학생만 일기 작성 가능
        if (uri.startsWith(contextPath + "/diary/write")
                && !role.equals("STUDENT")) {
            response.sendRedirect(contextPath + "/diary/all");
            return false;
        }

        // ✅ 역할별 접근 제한
        if (uri.startsWith(contextPath + "/student")
                && !role.equals("STUDENT")) {
            response.sendRedirect(contextPath + "/");
            return false;
        }

        if (uri.startsWith(contextPath + "/parent")
                && !role.equals("PARENT")) {
            response.sendRedirect(contextPath + "/");
            return false;
        }

        if (uri.startsWith(contextPath + "/teacher")
                && !role.equals("TEACHER")) {
            response.sendRedirect(contextPath + "/");
            return false;
        }

        return true;
    }
}
