package org.example.teamproject.DAO;
import java.util.List;
import org.example.teamproject.vo.NoticeVO;


import org.apache.ibatis.session.SqlSession;
import org.example.teamproject.vo.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeDAO {

    @Autowired
    private SqlSession sqlSession;

    // 전체 공지 목록
    public List<NoticeVO> findAll() {
        return sqlSession.selectList("NoticeMapper.findAll");
    }

    // 학급별 공지 목록 (교사용)
    public List<NoticeVO> findByClassCode(String classCode) {
        return sqlSession.selectList("NoticeMapper.findByClassCode", classCode);
    }


    // 공지 상세
    public NoticeVO findById(int id) {
        return sqlSession.selectOne("NoticeMapper.findById", id);
    }

    // 공지 작성
    public void insert(NoticeVO notice) {
        sqlSession.insert("NoticeMapper.insert", notice);
    }

    // 공지 수정
    public void update(NoticeVO notice) {
        sqlSession.update("NoticeMapper.update", notice);
    }

    // 공지 삭제
    public void delete(int id) {
        sqlSession.delete("NoticeMapper.delete", id);
    }
}
