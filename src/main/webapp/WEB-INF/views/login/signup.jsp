<%--
  Created by IntelliJ IDEA.
  User: yooneerum
  Date: 25. 12. 18.
  Time: 오전 1:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet"
        href="${pageContext.request.contextPath}/resources/css/app.css">

  <title>회원가입</title>
  <style>
    body {
      font-family: Arial;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background: #f6f7fb;
    }
    .box {
      background: white;
      padding: 40px;
      border-radius: 12px;
      width: 320px;
      box-shadow: 0px 4px 14px rgba(0,0,0,0.15);
    }
    input, select {
      width: 100%;
      padding: 12px;
      margin-bottom: 14px;
      border-radius: 6px;
      border: 1px solid #ccc;
    }
    button {
      width: 100%;
      padding: 12px;
      border: none;
      border-radius: 6px;
      background-color: #0d0d2b;
      color: white;
      font-size: 16px;
      cursor: pointer;
    }
  </style>

  <script>
    function toggleClassCode() {
      const role = document.getElementById("role").value;
      const classCode = document.getElementById("classCodeBox");

      if (role === 'TEACHER') {
        classCode.style.display = 'none';
      } else {
        classCode.style.display = 'block';
      }
    }
  </script>
</head>

<body>

<div class="box">
  <h2 style="text-align:center;">회원가입</h2>

  <form action="${pageContext.request.contextPath}/signup" method="post">
    <input type="text" name="username" placeholder="아이디" required>
    <input type="password" name="password" placeholder="비밀번호" required>
    <input type="email" name="email" placeholder="이메일" required>

    <select name="role" id="role" onchange="toggleClassCode()" required>
      <option value="">역할 선택</option>
      <option value="STUDENT">학생</option>
      <option value="PARENT">학부모</option>
      <option value="TEACHER">교사</option>
    </select>

    <div id="classCodeBox">
      <input type="text" name="classCode" placeholder="학급 코드 (학생/학부모 필수)">
    </div>

    <button type="submit">회원가입</button>
  </form>
</div>
</body>
</html>
