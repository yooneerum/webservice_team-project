<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>일기장 메인</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: 'Pretendard', sans-serif;
            background-color: #f7f8fa;
        }

        .container {
            width: 90%;
            max-width: 1100px;
            margin: 0 auto;
            text-align: center;
            padding-top: 60px;
        }

        .title {
            font-size: 32px;
            font-weight: bold;
            margin-bottom: 40px;
        }

        .card-wrapper {
            display: flex;
            justify-content: space-between;
            gap: 20px;
            flex-wrap: wrap;
        }

        .card {
            background-color: #f4de59;
            width: 32%;
            min-width: 260px;
            padding: 40px 20px;
            border-radius: 15px;
            box-shadow: 0 6px 12px rgba(0,0,0,0.1);
            transition: 0.25s;
            cursor: pointer;
        }

        .card:hover {
            transform: translateY(-6px);
            box-shadow: 0 12px 18px rgba(0,0,0,0.15);
        }

        .card-title {
            font-size: 26px;
            font-weight: bold;
            margin-top: 10px;
        }

        .card-desc {
            margin-top: 12px;
            font-size: 15px;
            color: #555;
        }

        /* 반응형 */
        @media(max-width: 800px) {
            .card {
                width: 100%;
            }
        }
    </style>
</head>

<body>
<div class="container">
    <div class="title">📘 일기장 메인 페이지</div>

    <div class="card-wrapper">

        <!-- 모두의 일기장 -->
        <div class="card" onclick="location.href='/diary/all'">
            <div style="font-size:40px;">🌍</div>
            <div class="card-title">모두의 일기장</div>
            <div class="card-desc">전체 공개된 일기를 볼 수 있어요 😊</div>
        </div>

        <!-- 우리반 일기장 -->
        <div class="card" onclick="location.href='/diary/class'">
            <div style="font-size:40px;">🏫</div>
            <div class="card-title">우리반 일기장</div>
            <div class="card-desc">우리 반 친구들이 작성한 일기 🧑‍🤝‍🧑</div>
        </div>

        <!-- 내 일기장 -->
        <div class="card" onclick="location.href='/diary/mine'">
            <div style="font-size:40px;">📘</div>
            <div class="card-title">내 일기장</div>
            <div class="card-desc">내가 쓴 일기들을 모아볼 수 있어요 ✨</div>
        </div>

    </div>
</div>
</body>
</html>
