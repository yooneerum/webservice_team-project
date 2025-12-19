<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/app.css">


    <title>학생 홈</title>

</head>

<body>
<jsp:include page="/WEB-INF/views/common/navbar.jsp" />



<div class="card-container">
    <div class="card"
         onclick="location.href='${pageContext.request.contextPath}/diary/all'">
        <div class="card-title">🌍모두의 일기</div>
        <div class="card-desc">전체에게 공개된 일기를 볼 수 있어요 😊</div>
    </div>

    <div class="card"
         onclick="location.href='${pageContext.request.contextPath}/diary/class'">
        <div class="card-title">🏫 우리반 일기</div>
        <div class="card-desc">우리 반 친구들이 작성한 일기 🧑‍🤝‍🧑</div>
    </div>

    <div class="card"
         onclick="location.href='${pageContext.request.contextPath}/diary/mine'">
        <div class="card-title">📔 내 일기</div>
        <div class="card-desc">내가 쓴 일기들을 모아볼 수 있어요 ✨</div>
    </div>
</div>

</body>
</html>
