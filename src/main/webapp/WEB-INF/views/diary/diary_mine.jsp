<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>📘 내 일기</h2>

<a href="${pageContext.request.contextPath}/diary/write">
  ✏️ 새 일기 쓰기
</a>

<table border="1">
  <tr>
    <th>번호</th>
    <th>제목</th>
    <th>내용</th>
    <th>작성일</th>
    <th>관리</th>
  </tr>

  <c:forEach var="d" items="${diaries}">
    <tr>
      <td>${d.postId}</td>
      <td>${d.title}</td>
      <td>${d.content}</td>
      <td>${d.createdAt}</td>
      <td>
        <a href="${pageContext.request.contextPath}/diary/edit?postId=${d.postId}">
          ✏️ 수정
        </a>
        |
        <a href="${pageContext.request.contextPath}/diary/delete?postId=${d.postId}"
           onclick="return confirm('삭제할까요?');">
          🗑 삭제
        </a>
      </td>
    </tr>
  </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/student/home">← 학생 홈</a>
