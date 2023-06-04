package com.donkey.domain.needs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 需求表
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Needs implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 需求编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 发布校园ID--后期做区域隔离--暂不考虑
     */
    private Integer aId;

    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 需求详细内容
     */
    private String detail;

    /**
     * 是否限定男女，0不限定1男2女
     */
    private Integer genderLimited;

    /**
     * 起点
     */
    private String start;

    /**
     * 目的地点
     */
    private String destination;

    /**
     * 选择文件上传比如截图收货码
     */
    private String file;

    /**
     * 费用
     */
    private Integer fees;

    /**
     * 需求状态 0已创建-- 1进行中 -- 2已完成 --3已取消
     */
    private Integer status;

    /**
     * 最晚时间送达时间
     */
    private LocalDateTime deadline;

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
