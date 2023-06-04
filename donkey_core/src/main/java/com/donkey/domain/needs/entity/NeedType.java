package com.donkey.domain.needs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 服务类型表
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class NeedType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 服务项编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 服务项名称
     */
    private String name;

    /**
     * 0关闭，1开启
     */
    private Integer isShow;

    /**
     * 是否删除
     */
    private Boolean isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;


}
