package com.example.order.service;

import com.example.order.dao.OrderDAO;
import com.example.order.entity.Order;
import com.example.order.fegin.GoodsService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 12:07
 * @description：
 * @modified By：
 * @version:
 */
@Service
@Slf4j
public class OrderService {

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderDAO orderDAO;


    public Order save( Order order){
        return orderDAO.save(order);
    }

    public List<Order> findAll(){
        List<Order> orderList = orderDAO.findAll();
        return orderList;
    }

    @GlobalTransactional(rollbackFor = Exception.class)
    public String buy( Order order){
        String result =  goodsService.buckleInventory(
                order.getGoodsId(), order.getNumber()
        ).getBody();

        if("梁朝伟".equals(order.getUserId())){
            log.info("有内鬼，交易取消！！！");
            throw new RuntimeException("有内鬼，交易取消！！！");
        }

        if(result == null){
            result="交易成功";
            orderDAO.save(order);
        }
        return result;
    }

}
