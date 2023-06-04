package com.donkey.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 结构信息----暂不考虑
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Structure implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 结构id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学校
     */
    private String school;

    /**
     * 学院
     */
    private String college;

    /**
     * 专业	
     */
    private String major;


}
