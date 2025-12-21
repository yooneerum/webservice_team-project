package org.example.teamproject.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.example.teamproject.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
;

@Repository
public class CommentDAO {

    @Autowired
    private SqlSession sqlSession;

    public List<CommentVO> findByNoticeId(int noticeId) {
        return sqlSession.selectList("CommentMapper.findByNoticeId", noticeId);
    }

    public void insert(CommentVO comment) {
        sqlSession.insert("CommentMapper.insert", comment);
    }

    public void update(CommentVO comment) {
        sqlSession.update("CommentMapper.update", comment);
    }

    public void delete(int id) {
        sqlSession.delete("CommentMapper.delete", id);
    }
}
