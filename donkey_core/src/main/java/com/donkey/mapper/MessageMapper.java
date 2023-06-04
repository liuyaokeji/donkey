package com.donkey.mapper;

import com.donkey.domain.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 消息信息--考虑kafka接入 Mapper 接口
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
public interface MessageMapper extends BaseMapper<Message> {

}
