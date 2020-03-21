package com.example.store.entity;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author ：HuangXiong
 * @date ：Created in 2020/3/20 11:04
 * @description： 商品实体
 * @modified By：
 * @version:
 */
@Data
@Table(name = "tb_goods")
@Entity
public class Goods implements Serializable {

    /**
     *  id
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    /**
     *  商品名称
     */
    @Column
    private String name;

    /**
     *  库存
     */
    @Column
    private int inventory;
}
