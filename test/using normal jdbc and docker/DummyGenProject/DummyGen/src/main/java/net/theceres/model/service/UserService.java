package net.theceres.model.service;

import net.theceres.model.vo.UserVo;

import java.util.ArrayList;

public interface UserService {
    void createUser(UserVo userVo);
    void updateUser(UserVo vo);
    void deleteUser(UserVo vo);
    ArrayList<UserVo> selectAllUser();
    UserVo selectUser(UserVo vo);
}
