package com.donkey.service.impl;

import com.donkey.domain.entity.Message;
import com.donkey.mapper.MessageMapper;
import com.donkey.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 消息信息--考虑kafka接入 服务实现类
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {

}
