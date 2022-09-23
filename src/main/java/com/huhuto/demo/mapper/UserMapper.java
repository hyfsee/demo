package com.huhuto.demo.mapper;

import com.huhuto.demo.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

 UserBean getInfo(String username, String password) ;

 List<UserBean> allUser(int page, int limit,String sort,String title);

 boolean deleteUser(int id);

 boolean addUser(UserBean userBean);

 boolean updateUserStatue(int id,int statue);

 boolean updateUser(UserBean userBean);

 boolean updateToken(int id,String token);

 UserBean userById(int id);
}