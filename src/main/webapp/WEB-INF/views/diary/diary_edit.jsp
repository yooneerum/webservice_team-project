<%@ page contentType="text/html; charset=UTF-8" %>

<h2>✏️ 일기 수정</h2>

<form action="${pageContext.request.contextPath}/diary/edit" method="post">
    <input type="hidden" name="postId" value="${post.postId}"/>

    제목<br/>
    <input type="text" name="title" value="${post.title}" required/><br/><br/>

    내용<br/>
    <textarea name="content" rows="5" required>${post.content}</textarea><br/><br/>

    <button type="submit">수정 완료</button>
    <a href="${pageContext.request.contextPath}/diary/mine">취소</a>
</form>
