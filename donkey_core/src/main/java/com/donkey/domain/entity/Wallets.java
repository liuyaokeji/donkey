package com.donkey.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户钱包
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Wallets implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户主键
     */
    private Integer uid;

    /**
     * 用户类型-0普通用户-1员工用户
     */
    private Integer type;

    /**
     * 总金额
     */
    private BigDecimal incomeTotal;

    /**
     * 提现金额
     */
    private BigDecimal cash;

    /**
     * 1可提现 2冻结
     */
    private Integer state;

    /**
     * 是否删除0-未删除 1删除
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime ceateTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
