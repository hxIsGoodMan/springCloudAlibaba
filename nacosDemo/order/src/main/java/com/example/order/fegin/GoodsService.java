package com.example.order.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：黄雄
 * @date ：Created in 2019/10/13 16:25
 * @description： fegin 接口类
 * @modified By：
 * @version: 1.0$
 */
@FeignClient(value = "seata-store")
public interface GoodsService {

    @GetMapping(value = "/goods/buckleInventory")
    ResponseEntity<String> buckleInventory(@RequestParam("id") Integer id, @RequestParam("number")Integer number);

    @GetMapping(value = "/goods/init")
    String init();
}
