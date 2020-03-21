package com.example.order.controller;

import com.example.order.dao.OrderDAO;
import com.example.order.entity.Order;
import com.example.order.fegin.GoodsService;
import com.example.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 9:28
 * @description：
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    GoodsService goodsService;

    @GetMapping("/initStore")
    public String initStore(){
        return goodsService.init();
    }

    @PostMapping("saveOrder")
    public ResponseEntity saveOrder(@RequestBody Order order){

        return ResponseEntity.ok(orderService.save(order));
    }

    @GetMapping("findAll")
    public ResponseEntity findAll(){

        return ResponseEntity.ok(orderService.findAll());
    }

    @PostMapping("buy")
    public ResponseEntity buy(@RequestBody Order order){
        return ResponseEntity.ok(orderService.buy(order));
    }


}
