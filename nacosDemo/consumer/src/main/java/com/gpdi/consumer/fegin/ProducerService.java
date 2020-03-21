package com.gpdi.consumer.fegin;

import com.gpdi.consumer.sentinel.EchoProducerServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ：黄雄
 * @date ：Created in 2019/10/13 16:25
 * @description：服务提供者 fegin 接口类
 * @modified By：
 * @version: 1.0$
 */
@FeignClient(value = "nacos-producer", fallback = EchoProducerServiceFallback.class)
public interface ProducerService {

    @GetMapping(value = "/init/{message}")
    String echo(@PathVariable("message") String message);
}
