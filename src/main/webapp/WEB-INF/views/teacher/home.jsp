<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>선생님 홈</title>
    <style>
        body {
            font-family: Arial;
            background: #f4f6fb;
            padding: 40px;
        }
        h2 { margin-bottom: 30px; }
        .menu {
            display: grid;
            grid-template-columns: repeat(2, 1fr);
            gap: 20px;
            max-width: 600px;
        }
        a {
            display: block;
            padding: 25px;
            background: white;
            border-radius: 12px;
            text-align: center;
            text-decoration: none;
            color: #222;
            font-size: 18px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        a:hover { background: #eef1ff; }
    </style>
</head>
<body>

<h2>👩‍🏫 선생님 페이지</h2>

<div class="menu">
    <a href="${pageContext.request.contextPath}/teacher/class/new">🏫 학급 생성</a>
    <a href="${pageContext.request.contextPath}/teacher/class">📚 내 학급 조회</a>
    <a href="${pageContext.request.contextPath}/teacher/notice/new">📝 공지 작성</a>
    <a href="${pageContext.request.contextPath}/teacher/notice">📢 내가 쓴 공지</a>
</div>

</body>
</html>
