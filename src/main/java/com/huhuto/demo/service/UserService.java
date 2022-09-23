package com.huhuto.demo.service;

import com.huhuto.demo.bean.UserBean;

import java.util.List;

public interface UserService {
    UserBean user(String username, String password);

    List<UserBean> allUser(int page, int limit,String sort,String title);

    boolean deleteUser(int id);

    boolean addUser(UserBean userBean);


    boolean updateUser(UserBean userBean);

    //更新用户登录状态
    boolean updateUserStatue(int id,int statue);
    //更新token
    boolean updateToken(int id,String token);

    UserBean userById(int id);
}
