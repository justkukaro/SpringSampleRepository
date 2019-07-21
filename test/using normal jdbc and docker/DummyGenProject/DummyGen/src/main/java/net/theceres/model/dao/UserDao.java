package net.theceres.model.dao;

import net.theceres.model.JDBCUtil;
import net.theceres.model.vo.UserVo;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository("UserDao")
public class UserDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    private final String USER_CREATE = "insert into user(id, name, age) values(?,?,?)";
    private final String USER_UPDATE = "update user set age=? where id=?";
    private final String USER_DELETE = "delete user where id=?";
    private final String USER_READ_ALL = "select * from user";
    private final String USER_READ = "select * from user where id=?";

    public void createUser(UserVo vo) {
        System.out.println("create routine");
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_CREATE);
            pstmt.setString(1, vo.getId());
            pstmt.setString(2, vo.getName());
            pstmt.setInt(3, vo.getAge());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    public void updateUser(UserVo vo) {
        System.out.println("update routine");
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_UPDATE);
            pstmt.setInt(1, vo.getAge());
            pstmt.setString(2, vo.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    public void deleteUser(UserVo vo) {
        System.out.println("delete routine");
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_DELETE);
            pstmt.setString(1, vo.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
    }

    public ArrayList<UserVo> selectAllUser() {
        System.out.println("select all routine");
        ArrayList<UserVo> userVos = new ArrayList<UserVo>();
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_READ_ALL);
            rs = pstmt.executeQuery();
            while(rs.next()){
                UserVo userVo = new UserVo();
                userVo.setId(rs.getString("id"));
                userVo.setName(rs.getString("name"));
                userVo.setAge(rs.getInt("age"));
                userVos.add(userVo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
        return userVos;
    }

    public UserVo selectUser(UserVo vo){
        System.out.println("select routine");
        UserVo userVo = null;
        try {
            conn = JDBCUtil.getConnection();
            pstmt = conn.prepareStatement(USER_READ);
            pstmt.setString(1, vo.getId());
            rs = pstmt.executeQuery();
            while(rs.next()){
                userVo.setId(rs.getString("id"));
                userVo.setName(rs.getString("name"));
                userVo.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(pstmt, conn);
        }
        return userVo;
    }
}
