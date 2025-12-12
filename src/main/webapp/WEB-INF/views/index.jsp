<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>우리반 일기</title>
    <style>
        body {
            margin: 0;
            font-family: 'Pretendard', sans-serif;
            background-color: #f7f8fa;
        }

        /* 상단바 */
        .navbar {
            width: 100%;
            background-color: #0d0d2b;
            padding: 18px 40px;
            color: white;
            display: flex;
            align-items: center;
            justify-content: space-between;
            box-sizing: border-box;
        }

        .navbar .logo {
            font-size: 26px;
            font-weight: 700;
            letter-spacing: -1px;
        }

        .menu {
            display: flex;
            gap: 25px;
            align-items: center;
        }

        .menu a {
            color: white;
            text-decoration: none;
            font-size: 16px;
            opacity: 0.9;
        }

        .menu a:hover {
            opacity: 1;
        }

        /* 카드 컨테이너 */
        .card-container {
            margin-top: 60px;
            display: flex;
            justify-content: center;
            gap: 40px;
        }

        .card {
            background-color: #f2dd70;
            width: 300px;
            padding: 35px;
            border-radius: 18px;
            box-shadow: 0px 8px 20px rgba(0,0,0,0.1);
            text-align: center;
            cursor: pointer;
            transition: all 0.2s ease;
        }

        .card:hover {
            transform: translateY(-7px);
            box-shadow: 0px 14px 26px rgba(0,0,0,0.15);
        }

        .card-title {
            font-size: 24px;
            font-weight: 700;
            margin-bottom: 12px;
        }

        .card-desc {
            font-size: 15px;
            color: #444;
        }

    </style>
</head>

<body>

<!-- 상단바 -->
<div class="navbar">
    <div class="logo">📘 우리반 일기</div>

    <div class="menu">
        <a href="/student/home">학생 홈</a>
        <a href="/parent/home">학부모</a>
        <a href="/teacher/home">선생님</a>
        <a href="/login">로그인</a>
    </div>
</div>

<!-- 카드 UI -->
<div class="card-container">
    <div class="card" onclick="location.href='/diary/all'">
        <div class="card-title">🌍 전체 일기</div>
        <div class="card-desc">모두가 공개한 일기를 볼 수 있어요 😊</div>
    </div>

    <div class="card" onclick="location.href='/diary/class'">
        <div class="card-title">🏫 우리반 일기</div>
        <div class="card-desc">우리 반 친구들이 오늘 쓴 일기들 👧👦</div>
    </div>

    <div class="card" onclick="location.href='/diary/mine'">
        <div class="card-title">📔 내 일기</div>
        <div class="card-desc">내가 쓴 일기를 모아볼 수 있어요 ✨</div>
    </div>
</div>

</body>
</html>
