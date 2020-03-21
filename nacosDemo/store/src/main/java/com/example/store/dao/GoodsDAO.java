package com.example.store.dao;

import com.example.store.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 11:18
 * @description：
 * @modified By：
 * @version:
 */
public interface GoodsDAO extends JpaRepository<Goods,Integer> {
}
