package com.huhuto.demo.mapper;

import com.huhuto.demo.bean.UserBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

 UserBean getInfo(String username, String password) ;

 List<UserBean> allUser();

 boolean deleteUser(int id);

 boolean addUser(UserBean userBean);


 boolean updateUser(UserBean userBean);

}