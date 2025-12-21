package org.example.teamproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();

        // ✅ 로그인 / 회원가입 / 정적 리소스는 통과
        if (uri.equals(contextPath + "/login")
                || uri.equals(contextPath + "/signup")
                || uri.startsWith(contextPath + "/resources")) {
            return true;
        }

        HttpSession session = request.getSession(false);

        // ❌ 로그인 안 된 경우
        if (session == null || session.getAttribute("loginUser") == null) {

            // 원래 가려던 주소 저장
            String query = request.getQueryString();
            String fullUrl = (query == null) ? uri : uri + "?" + query;

            request.getSession(true).setAttribute("redirectAfterLogin", fullUrl);

            response.sendRedirect(contextPath + "/login");
            return false;
        }

        return true;
    }
}
