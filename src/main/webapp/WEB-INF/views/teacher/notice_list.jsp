<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>📢 내가 쓴 공지</h2>

<c:if test="${empty notices}">
    <p>작성한 공지가 없습니다.</p>
</c:if>

<c:if test="${not empty notices}">
    <ul>
        <c:forEach var="n" items="${notices}">
            <li>
                <a href="${pageContext.request.contextPath}/notice/detail?id=${n.id}">
                        ${n.title}
                </a>
            </li>
        </c:forEach>
    </ul>
</c:if>

<a href="${pageContext.request.contextPath}/teacher/home">← 교사 홈</a>
