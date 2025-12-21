package org.example.teamproject.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.teamproject.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAO {

    @Autowired
    private SqlSession sqlSession;

    /* ======================
       댓글 조회
     ====================== */

    // 공지별 댓글 목록
    public List<CommentVO> findByNoticeId(int noticeId) {
        return sqlSession.selectList(
                "CommentMapper.findByNoticeId",
                noticeId
        );
    }

    // 댓글 단일 조회 (본인 확인용)
    public CommentVO findById(int id) {
        return sqlSession.selectOne(
                "CommentMapper.findById",
                id
        );
    }

    /* ======================
       댓글 작성
     ====================== */

    public void insert(CommentVO comment) {
        sqlSession.insert(
                "CommentMapper.insert",
                comment
        );
    }

    /* ======================
       댓글 수정
     ====================== */

    public void update(CommentVO comment) {
        sqlSession.update(
                "CommentMapper.update",
                comment
        );
    }

    /* ======================
       댓글 삭제
     ====================== */

    public void delete(int id) {
        sqlSession.delete(
                "CommentMapper.delete",
                id
        );
    }
}
