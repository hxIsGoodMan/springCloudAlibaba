package com.gpdi.consumer.controller;

import com.gpdi.consumer.fegin.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：黄雄
 * @date ：Created in 2019/10/13 16:27
 * @description：消息消费者测试接口类
 * @modified By：
 * @version: 1.0
 */
@RestController
public class EchoController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("/init/{message}")
    public String echo(@PathVariable String message){
       return producerService.echo(message);
    }


}
