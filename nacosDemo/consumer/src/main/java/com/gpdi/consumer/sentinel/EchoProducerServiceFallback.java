package com.gpdi.consumer.sentinel;

import com.gpdi.consumer.fegin.ProducerService;
import org.springframework.stereotype.Component;

/**
 * @author ：黄雄
 * @date ：Created in 2019/10/16 16:49
 * @description：熔断器 nacos-provider 回调类 demo
 * @modified By：
 * @version: 1.0
 */
@Component
public class EchoProducerServiceFallback implements ProducerService {

    @Override
    public String echo(String message) {
        return " nacos-provider 崩溃啦 崩溃啦";
    }
}
