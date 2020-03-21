package com.example.order.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 9:19
 * @description：
 * @modified By：
 * @version:
 */
@Data
@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    /**
     *  购买用户的id
     */
    @Column(name = "username")
    private String userId;

    /**
     * 购买数量
     */
    @Column(name = "number")
    private int  number;

    /**
     *  商品id
     */
    @Column(name = "goodsId")
    private int goodsId;

    /**
     *  单价
     */
    @Column(name = "price")
    private BigDecimal price;

}
