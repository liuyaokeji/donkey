package com.donkey.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 消息信息--考虑kafka接入
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 消息ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 需求ID
     */
    private Integer needId;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 顾客ID
     */
    private String customerId;

    /**
     * 接单员ID
     */
    private String takerId;

    /**
     * 消息类型 0未知 1.已被接单，2.物品已到达 3 物品被签收 4顾客申请退款 5接单员申请取消  
     */
    private Integer status;


}
