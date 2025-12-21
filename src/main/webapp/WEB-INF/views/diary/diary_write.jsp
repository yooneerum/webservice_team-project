<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<h2>✏️ 일기 작성</h2>

<form action="${ctx}/diary/write" method="post">
    <div>
        제목<br>
        <input type="text" name="title" required>
    </div>

    <br>

    <div>
        내용<br>
        <textarea name="content" rows="6" cols="50" required></textarea>
    </div>

    <br>

    <button type="submit">저장</button>
    <a href="${ctx}/diary/mine">취소</a>
</form>
