<h2>📢 학급 공지</h2>

<ul>
    <c:forEach var="n" items="${notices}">
        <li>
            <a href="${pageContext.request.contextPath}/notice/detail?id=${n.id}">
                    ${n.title}
            </a>
        </li>
    </c:forEach>
</ul>

<a href="/parent/home">← 학부모 홈</a>
