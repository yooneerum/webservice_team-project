<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>학생 홈</title>
    <style>
        body {
            margin: 0;
            font-family: 'Pretendard', sans-serif;
            background-color: #f7f8fa;
        }
        .navbar {
            background-color: #0d0d2b;
            padding: 18px 40px;
            color: white;
            display: flex;
            justify-content: space-between;
        }
        .menu a {
            color: white;
            margin-left: 20px;
            text-decoration: none;
        }
        .card-container {
            margin-top: 60px;
            display: flex;
            justify-content: center;
            gap: 40px;
        }
        .card {
            background-color: #f2dd70;
            width: 280px;
            padding: 30px;
            border-radius: 18px;
            text-align: center;
            cursor: pointer;
            box-shadow: 0 8px 20px rgba(0,0,0,0.12);
        }
        .card:hover {
            transform: translateY(-6px);
        }
    </style>
</head>
<body>

<div class="navbar">
    <div>📘 참 잘했어요!!</div>
    <div class="menu">
        <a href="${pageContext.request.contextPath}/logout">로그아웃</a>
    </div>
</div>

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
