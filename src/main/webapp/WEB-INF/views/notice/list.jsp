<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>학급 공지</title>
</head>
<body>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<h2>📢 학급 공지</h2>

<!-- 관리자/교사만 공지 작성 -->
<c:if test="${sessionScope.loginUser.role eq 'TEACHER'}">
    <div style="margin-bottom: 10px;">
        <a href="${ctx}/notice/write">➕ 공지 작성</a>
    </div>
</c:if>

<!-- 공지 없음 -->
<c:if test="${empty notices}">
    <p>등록된 공지가 없습니다.</p>
</c:if>

<!-- 공지 목록 -->
<c:if test="${not empty notices}">
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="n" items="${notices}">
            <tr>
                <td>${n.id}</td>
                <td>
                    <a href="${ctx}/notice/detail?id=${n.id}">
                        <c:out value="${n.title}" />
                    </a>
                </td>
                <td>
                    <fmt:formatDate value="${n.createdAt}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<br>

<a href="${ctx}/parent/home">← 학부모 홈</a>

</body>
</html>
