package org.example.teamproject.DAO;

import org.example.teamproject.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 로그인용 조회
    public UserVO findByUsernameAndPassword(String username, String password) {
        System.out.println("▶ username = [" + username + "]");
        System.out.println("▶ password = [" + password + "]");

        String sql = "SELECT * FROM user WHERE username = ? AND password = ?";

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    (rs, rowNum) -> {
                        UserVO user = new UserVO();
                        user.setId(rs.getInt("id"));
                        user.setUsername(rs.getString("username"));
                        user.setPassword(rs.getString("password"));
                        user.setEmail(rs.getString("email"));
                        user.setRole(rs.getString("role"));
                        user.setClassCode(rs.getString("class_code"));
                        return user;
                    },
                    username,
                    password
            );
        } catch (Exception e) {
            // 조회 결과 없음 (로그인 실패)
            return null;
        }
    }

    // 회원가입
    public void insertUser(UserVO user) {
        String sql = "INSERT INTO user (username, password, email, role, class_code) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRole(),
                user.getClassCode()
        );
    }
}
