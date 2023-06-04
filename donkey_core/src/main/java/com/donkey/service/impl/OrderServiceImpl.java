package com.donkey.service.impl;

import com.donkey.domain.order.entity.Order;
import com.donkey.mapper.OrderMapper;
import com.donkey.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单表 服务实现类
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
