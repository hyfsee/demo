package com.huhuto.demo.serviceImpl;

import com.huhuto.demo.bean.UserBean;
import com.huhuto.demo.mapper.UserMapper;
import com.huhuto.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

 @Autowired
 private UserMapper UserMapper;

    @Override
    public UserBean user(String username, String password) {
        return UserMapper.getInfo(username,password);
    }

    @Override
    public List<UserBean> allUser(int page, int limit,String sort,String title) {
        return  UserMapper.allUser(page,limit,sort,title);
    }

    @Override
    public boolean deleteUser(int id) {
        return UserMapper.deleteUser(id);
    }

    @Override
    public boolean addUser(UserBean userBean) {
        return UserMapper.addUser(userBean);
    }

    @Override
    public boolean updateUser(UserBean userBean) {
        return UserMapper.updateUser(userBean);
    }

    @Override
    public boolean updateUserStatue(int id,int statue) {
        return UserMapper.updateUserStatue(id,statue);
    }

    @Override
    public boolean updateToken(int id,String token) {
        return UserMapper.updateToken(id,token);
    }

    @Override
    public UserBean userById(int id) {
        return UserMapper.userById(id);
    }


}
