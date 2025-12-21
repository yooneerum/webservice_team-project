package org.example.teamproject.DAO;

import org.apache.ibatis.session.SqlSession;
import org.example.teamproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {

    @Autowired
    private SqlSession sqlSession;

    // 로그인
    public UserVO findByUsernameAndPassword(String username, String password) {
        UserVO param = new UserVO();
        param.setUsername(username);
        param.setPassword(password);

        return sqlSession.selectOne(
                "UserMapper.findByUsernameAndPassword",
                param
        );
    }

    // 회원가입
    public void insertUser(UserVO user) {
        sqlSession.insert("UserMapper.insertUser", user);
    }

    // 🔥 학생 목록
    public List<UserVO> findStudentsByClassCode(String classCode) {
        return sqlSession.selectList(
                "UserMapper.findStudentsByClassCode",
                classCode
        );
    }

    // 🔥 학부모 목록
    public List<UserVO> findParentsByClassCode(String classCode) {
        return sqlSession.selectList(
                "UserMapper.findParentsByClassCode",
                classCode
        );
    }
}
