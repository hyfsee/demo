package com.huhuto.demo.controller;

import com.huhuto.demo.bean.UserBean;
import com.huhuto.demo.common.AjaxResult;
import com.huhuto.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;



        @RequestMapping("/")
        public String sayHello(){

            return "login";
        }

//登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult login(String username, String password, ModelMap mo){
        UserBean userBean = userService.user(username,password);
        System.out.println("userBean"+userBean);
        if(userBean!=null){
            mo.put("user",userBean);
            return AjaxResult.successData(200,userBean);
        }else {
            return AjaxResult.error(400,"输入的账号密码是错误的，请重新尝试！！！");
        }
    }


//查询所有用户
    @RequestMapping(value = "/allUser",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult allUser(){
        List<UserBean> userBean = userService.allUser();
        System.out.println("userBean"+userBean);
        if(userBean!=null){

            return AjaxResult.successData(200,userBean);
        }else {
            return AjaxResult.error(400,"没有数据没有哦！！！");
        }
    }




    //根据id删除用户
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult deleteUser(@RequestBody UserBean userBean){

        System.out.println("userBean:"+userBean.getId());
        boolean a = userService.deleteUser(userBean.getId());

        if(a==true){

            return AjaxResult.success("删除成功");
        }else {
            return AjaxResult.error(400,"删除失败！！！");
        }
    }




    //新增用户
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult addUser(@RequestBody UserBean userBean){

        System.out.println("userBean:"+userBean);
        boolean a = userService.addUser(userBean);

        if(a==true){

            return AjaxResult.success("新增成功");
        }else {
            return AjaxResult.error(400,"新增失败！！！");
        }
    }

    //修改用户
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult updateUser(@RequestBody UserBean userBean){

        System.out.println("userBean:"+userBean);
        boolean a = userService.updateUser(userBean);

        if(a==true){

            return AjaxResult.success("修改成功");
        }else {
            return AjaxResult.error(400,"修改失败！！！");
        }
    }
}
