package com.gpdi.consumer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：黄雄
 * @date ：Created in 2019/10/14 10:24
 * @description：测试nacos config 的接口类
 *
 * @modified By：
 * @version: 1.0
 */
// @RefreshScope 标注改注解的类 底下的 value 注入 可实时更新
@RefreshScope
@RequestMapping("config")
@RestController
public class ConfigDemoController {

    @Value("${refreshVal}")
    private String refreshVal;

    @GetMapping
    public String get(){
        return refreshVal;
    }

    @Value("${me}")
    private String me;

    @GetMapping(value = "getMe")
    public String getMe(){
        return me;
    }
}
