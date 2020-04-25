package com.zyh.controller;

import com.alibaba.fastjson.JSON;
import com.zyh.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String test(){
        User user = new User();
        user.setId(1);
        user.setName("張宇浩");
        return JSON.toJSONString(user);
    }


}
