<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/app.css">


    <title>선생님 홈</title>

</head>

<body>
<jsp:include page="/WEB-INF/views/common/navbar.jsp" />

<div class="card-container">
    <div class="card"
         onclick="location.href='${pageContext.request.contextPath}/teacher/class/new'">
        <div class="card-title">🏫학급 생성</div>
        <div class="card-desc">학급을 만들고 고유키를 공유하세요😊</div>
    </div>

    <div class="card"
         onclick="location.href='${pageContext.request.contextPath}/teacher/class'">
        <div class="card-title">📚내 학급 조회</div>
        <div class="card-desc">내가 만든 학급 리스트🧑‍🤝‍🧑</div>
    </div>

    <div class="card"
         onclick="location.href='${pageContext.request.contextPath}/teacher/notice/new'">
        <div class="card-title">📝공지 작성</div>
        <div class="card-desc">가정통신문을 작성하세요✨</div>
    </div>

    <div class="card"
         onclick="location.href='${pageContext.request.contextPath}/teacher/notice'">
        <div class="card-title">📢내가 쓴 공지</div>
        <div class="card-desc">내가 작성한 공지리스트✨</div>
    </div>
</div>

</body>
</html>
