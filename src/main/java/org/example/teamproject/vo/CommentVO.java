package org.example.teamproject.vo;

public class CommentVO {
    private int id;
    private int noticeId;
    private String writer;
    private String content;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNoticeId() { return noticeId; }
    public void setNoticeId(int noticeId) { this.noticeId = noticeId; }

    public String getWriter() { return writer; }
    public void setWriter(String writer) { this.writer = writer; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
}
