package com.donkey.domain.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单编号--优化方案编号为年月日+uuid
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 接单人ID
     */
    private Integer takerId;

    /**
     * 0待付款 1待接单 2待完成 3已完成 4已取消
     */
    private Integer state;

    private LocalDateTime payTime;

    private LocalDateTime takeTime;

    private LocalDateTime doneTime;

    private LocalDateTime cancelTime;


}
