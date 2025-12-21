<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>공지 작성</title>

    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/app.css">
</head>
<body>

<jsp:include page="/WEB-INF/views/common/navbar.jsp" />

<h2>📢 공지 작성</h2>

<form action="${pageContext.request.contextPath}/teacher/notice/new"
      method="post">

    <!-- 학급 선택 -->
    <div>
        <label>학급 선택</label><br>
        <select name="classCode" required>
            <c:forEach var="c" items="${classList}">
                <option value="${c.classCode}">
                        ${c.className} (${c.classCode})
                </option>
            </c:forEach>
        </select>
    </div>

    <br>

    <!-- 제목 -->
    <div>
        <label>제목</label><br>
        <input type="text" name="title" required
               placeholder="공지 제목을 입력하세요">
    </div>

    <br>

    <!-- 내용 -->
    <div>
        <label>내용</label><br>
        <textarea name="content" rows="6" required
                  placeholder="공지 내용을 입력하세요"></textarea>
    </div>

    <br>

    <button type="submit">공지 등록</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/teacher/home">← 교사 홈</a>

</body>
</html>
