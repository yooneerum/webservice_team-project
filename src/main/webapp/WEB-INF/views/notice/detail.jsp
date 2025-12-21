<h2>${notice.title}</h2>
<p>${notice.content}</p>

<hr/>

<h3>💬 댓글</h3>

<c:forEach var="c" items="${comments}">
    <p>
        <b>${c.writer}</b>: ${c.content}

        <c:if test="${sessionScope.loginUser.username == c.writer}">
            <a href="/comment/delete?id=${c.id}&noticeId=${notice.id}">삭제</a>
        </c:if>
    </p>
</c:forEach>

<form action="/comment/write" method="post">
    <input type="hidden" name="noticeId" value="${notice.id}">
    <textarea name="content" required></textarea><br/>
    <button>댓글 작성</button>
</form>
