package com.zyh.controller;

import com.zyh.config.ConsulConfigInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController1 {
    @Autowired
    private ConsulConfigInfo consulConfigInfo;
    @RequestMapping("getConfig")
    public Object getConfigInfo(){

    return consulConfigInfo;
 }
}
