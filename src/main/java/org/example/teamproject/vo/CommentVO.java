package org.example.teamproject.vo;

import java.sql.Timestamp;

public class CommentVO {
    private int id;
    private int noticeId;
    private int writerId;
    private String content;
    private Timestamp createdAt;

    // getter / setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getNoticeId() { return noticeId; }
    public void setNoticeId(int noticeId) { this.noticeId = noticeId; }

    public int getWriterId() { return writerId; }
    public void setWriterId(int writerId) { this.writerId = writerId; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
