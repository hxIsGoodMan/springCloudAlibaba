package com.example.store.service;

import com.example.store.dao.GoodsDAO;
import com.example.store.entity.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 11:23
 * @description：
 * @modified By：
 * @version:
 */
@Service
@Slf4j
public class GoodsService {

    @Autowired
    GoodsDAO goodsDAO;

   public Integer save(Goods goods){
       return goodsDAO.save(goods).getId();
   }

   public List<Goods> findAll(){
       return goodsDAO.findAll();
   }

   @Transactional
   public String buckleInventory(Integer goodsId,Integer number){
       log.info("进入减库存方法 :::::::: 商品id {} , 购买数量 {}",goodsId,number);
       Goods goods = goodsDAO.getOne(goodsId);
       goodsDAO.flush();
       if(goods == null ){
           log.info("购买数量大于库存 OR goods 为 null ::::::: [{}]",goods);
           return "货物ID 有误";
       }else if(goods.getInventory() < number){
           return "购买数量大于库存";
       }
       goods.setInventory(goods.getInventory()-number);
        goodsDAO.save(goods);
       return null;
   }



}
