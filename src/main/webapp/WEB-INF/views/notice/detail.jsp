<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지 상세</title>
</head>
<body>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!-- 공지 제목 -->
<h2>${notice.title}</h2>

<!-- 작성일 -->
<p>
    <small>
        작성일 :
        <fmt:formatDate value="${notice.createdAt}" pattern="yyyy-MM-dd HH:mm"/>
    </small>
</p>

<hr>

<!-- 공지 내용 -->
<p>${notice.content}</p>

<hr>

<!-- 관리자/교사 전용 공지 삭제 -->
<c:if test="${sessionScope.loginUser.role eq 'TEACHER'}">
    <form action="${ctx}/notice/delete" method="post"
          onsubmit="return confirm('정말 삭제하시겠습니까?');">
        <input type="hidden" name="id" value="${notice.id}">
        <button type="submit">🗑 공지 삭제</button>
    </form>
</c:if>

<hr>

<!-- 댓글 영역 -->
<h3>💬 댓글</h3>

<!-- 댓글 없음 -->
<c:if test="${empty comments}">
    <p>등록된 댓글이 없습니다.</p>
</c:if>

<!-- 댓글 목록 -->
<c:forEach var="c" items="${comments}">
    <p>• <c:out value="${c.content}" /></p>
</c:forEach>

<hr>

<!-- 로그인 사용자만 댓글 작성 -->
<c:if test="${not empty sessionScope.loginUser}">
    <form action="${ctx}/comment/write" method="post">
        <input type="hidden" name="noticeId" value="${notice.id}">
        <textarea name="content" rows="3" cols="50" required></textarea><br>
        <button type="submit">댓글 작성</button>
    </form>
</c:if>

<!-- 비로그인 안내 -->
<c:if test="${empty sessionScope.loginUser}">
    <p>댓글 작성을 하려면 로그인하세요.</p>
</c:if>

<br>

<a href="${ctx}/notice/list">← 공지 목록</a>

</body>
</html>
