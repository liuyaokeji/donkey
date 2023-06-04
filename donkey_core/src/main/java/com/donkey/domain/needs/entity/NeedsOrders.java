package com.donkey.domain.needs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 需求订单关联表
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NeedsOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 需求id
     */
    private Integer needId;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 顾客
     */
    private String customer;

    /**
     * 接单员
     */
    private String taker;


}
