<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>우리반 일기</title>
</head>
<body>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<h2>🏫 우리반 일기</h2>

<!-- 일기 없음 -->
<c:if test="${empty diaries}">
    <p>우리 반에 등록된 일기가 없습니다.</p>
</c:if>

<!-- 일기 목록 -->
<c:if test="${not empty diaries}">
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="d" items="${diaries}">
            <tr>
                <td>${d.postId}</td>
                <td>
                    <strong><c:out value="${d.title}" /></strong>
                </td>
                <td>
                    <c:out value="${d.content}" />
                </td>
                <td>
                    <fmt:formatDate value="${d.createdAt}" pattern="yyyy-MM-dd" />
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

<br>

<!-- 학생만 글쓰기 -->
<c:if test="${sessionScope.loginUser.role eq 'STUDENT'}">
    <a href="${ctx}/diary/write">✏️ 일기 작성</a>
</c:if>

<br><br>

<a href="${ctx}/student/home">← 학생 홈</a>

</body>
</html>
