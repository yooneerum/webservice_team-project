<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지 작성</title>
</head>
<body>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<h2>📢 공지 작성</h2>

<!-- 교사 전용 안내 -->
<p>※ 공지는 교사만 작성할 수 있습니다.</p>

<form action="${ctx}/notice/write" method="post">

    <!-- 학급 코드 -->
    <div>
        <label>학급 코드</label><br>
        <input type="text"
               name="classCode"
               value="${sessionScope.loginUser.classCode}"
               required />
    </div>

    <br>

    <!-- 제목 -->
    <div>
        <label>제목</label><br>
        <input type="text"
               name="title"
               required
               style="width: 400px;" />
    </div>

    <br>

    <!-- 내용 -->
    <div>
        <label>내용</label><br>
        <textarea name="content"
                  rows="8"
                  cols="60"
                  required></textarea>
    </div>

    <br>

    <!-- 버튼 -->
    <button type="submit">등록</button>
    <a href="${ctx}/notice/list">취소</a>

</form>

</body>
</html>
