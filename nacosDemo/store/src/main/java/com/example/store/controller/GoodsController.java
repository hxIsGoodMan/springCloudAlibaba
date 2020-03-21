package com.example.store.controller;

import com.example.store.entity.Goods;
import com.example.store.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 11:21
 * @description：
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping("save")
    public ResponseEntity save(@RequestBody Goods goods){

        return ResponseEntity.ok(goodsService.save(goods));

    }

    @GetMapping("findAll")
    public ResponseEntity findAll(){

        return ResponseEntity.ok(goodsService.findAll());

    }

    @GetMapping("buckleInventory")
    public ResponseEntity<String> buckleInventory(Integer id,Integer number){

        return ResponseEntity.ok(goodsService.buckleInventory(id,number));

    }

    @GetMapping("/init")
    public String init(){
        return "SUCCESS";
    }
}
