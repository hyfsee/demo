package com.huhuto.demo.controller;

import com.huhuto.demo.common.AjaxResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@CrossOrigin
@Controller
public class requestController {

    @RequestMapping(value = "/weather",method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult Weather(String city) {


        return AjaxResult.successData(200,city);

    }
}
