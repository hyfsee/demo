package com.huhuto.demo.service;

import com.huhuto.demo.bean.UserBean;

import java.util.List;

public interface UserService {
    UserBean user(String username, String password);

    List<UserBean> allUser();

    boolean deleteUser(int id);

    boolean addUser(UserBean userBean);


    boolean updateUser(UserBean userBean);
    //更新token
    boolean updateToken(int id,String token);
}
