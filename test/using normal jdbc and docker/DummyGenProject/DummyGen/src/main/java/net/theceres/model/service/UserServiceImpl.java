package net.theceres.model.service;

import net.theceres.model.dao.UserDao;
import net.theceres.model.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void createUser(UserVo vo) {
        userDao.createUser(vo);
    }

    @Override
    public void updateUser(UserVo vo) {
        userDao.updateUser(vo);
    }

    @Override
    public void deleteUser(UserVo vo) {
        userDao.deleteUser(vo);
    }

    @Override
    public ArrayList<UserVo> selectAllUser() {
        return userDao.selectAllUser();
    }

    @Override
    public UserVo selectUser(UserVo vo) {
        return userDao.selectUser(vo);
    }
}
