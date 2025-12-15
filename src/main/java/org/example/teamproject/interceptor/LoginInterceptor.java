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

        HttpSession session = request.getSession();

        // 로그인 안 된 경우
        if (session.getAttribute("loginUser") == null) {

            // 🔥 가려던 URL 저장
            String uri = request.getRequestURI();
            String query = request.getQueryString();
            String fullUrl = (query == null) ? uri : uri + "?" + query;

            session.setAttribute("redirectAfterLogin", fullUrl);

            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        return true;
    }
}
