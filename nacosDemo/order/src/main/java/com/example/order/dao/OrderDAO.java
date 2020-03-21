package com.example.order.dao;

import com.example.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 10:47
 * @description：
 * @modified By：
 * @version:
 */
public interface OrderDAO extends JpaRepository<Order,String> {
}
