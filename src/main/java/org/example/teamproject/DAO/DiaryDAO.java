package org.example.teamproject.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.teamproject.vo.PostVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class DiaryDAO {

    @Autowired
    private SqlSession sqlSession;

    // 전체 일기
    public List<PostVO> findAll() {
        return sqlSession.selectList("DiaryMapper.findAll");
    }

    // 학급 일기
    public List<PostVO> findByClassCode(String classCode) {
        return sqlSession.selectList(
                "DiaryMapper.findByClassCode",
                classCode
        );
    }

    // 내 일기
    public List<PostVO> findByUserId(int userId) {
        return sqlSession.selectList(
                "DiaryMapper.findByUserId",
                userId
        );
    }

    // 단일 조회
    public PostVO findById(int postId) {
        return sqlSession.selectOne("DiaryMapper.findById", postId);
    }

    // 작성
    public void insert(PostVO post) {
        sqlSession.insert("DiaryMapper.insert", post);
    }

    // 수정
    public void update(PostVO post) {
        sqlSession.update("DiaryMapper.update", post);
    }

    // 삭제 (🔥 param1 문제 해결)
    public void deleteByPostIdAndUserId(int postId, int userId) {
        sqlSession.delete(
                "DiaryMapper.deleteByPostIdAndUserId",
                Map.of("postId", postId, "userId", userId)
        );
    }
}
