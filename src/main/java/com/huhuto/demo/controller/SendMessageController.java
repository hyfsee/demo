package com.huhuto.demo.controller;


import com.huhuto.demo.config.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/sendMessage")
public class SendMessageController {

    private Logger logger = LoggerFactory.getLogger(SendMessageController.class);

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //推送数据接口
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid, String message) {
        try {

               WebSocketServer.sendInfo(message,cid);


        } catch (IOException e) {
            e.printStackTrace();
            return "ERROR " + cid + " : send message is error";
        }
        return "SUCCESS " + cid + " : send message is success";
    }


}