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
    public List<UserBean> allUser() {
        return  UserMapper.allUser();
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


}
