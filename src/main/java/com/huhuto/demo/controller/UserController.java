package com.huhuto.demo.controller;

import com.huhuto.demo.bean.UserBean;
import com.huhuto.demo.common.AjaxResult;
import com.huhuto.demo.common.tokenResult;
import com.huhuto.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@CrossOrigin
@Controller
public class UserController {

    private static final long EXPIRE_DATE=30*60*1000;
    //token秘钥
    private static final String TOKEN_SECRET = "4BEWba3QQ7tUVgwyVsGykjsTn5cp7fmy";

    @Autowired
    UserService userService;



        @RequestMapping("/")
        public String sayHello(){





            return "login";
        }

//登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(String username, String password,ModelMap modelMap){
        UserBean userBean = userService.user(username,password);
        System.out.println("userBean"+userBean);
        ModelAndView md =new ModelAndView();
        String token=tokenResult.token(username,password);
        if(userBean!=null){
            userService.updateToken(userBean.getId(),token);
            modelMap.addAttribute("username",userBean.getUsername());
            modelMap.addAttribute("password",userBean.getPassword());
            modelMap.addAttribute("id",userBean.getId());
            modelMap.addAttribute("userBean",userBean);
            modelMap.addAttribute("token",token);
            modelMap.addAttribute("state",1);
        }else {
            modelMap.addAttribute("state",0);
           return  "login";

        }
        return "admin";
    }
    //登录APi
    @RequestMapping(value = "/loginApi",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult loginApi(String username, String password){
        UserBean userBean = userService.user(username,password);
        String token=tokenResult.token(username,password);
        System.out.println("userBean"+userBean);
        ModelAndView md =new ModelAndView();
        if(userBean!=null){
            userService.updateToken(userBean.getId(),token);
            md.addObject("username",userBean.getUsername());
            md.addObject("password",userBean.getPassword());
            md.addObject("id",userBean.getId());
            md.addObject("userBean",userBean);
            md.addObject("token",token);
            return AjaxResult.successData(200,userBean);
        }else {
            return AjaxResult.error(400,"登录失败！！！");
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


