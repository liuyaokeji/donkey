package com.donkey.service.impl;

import com.donkey.domain.needs.entity.NeedsOrders;
import com.donkey.mapper.NeedsOrdersMapper;
import com.donkey.service.NeedsOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 需求订单关联表 服务实现类
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Service
public class NeedsOrdersServiceImpl extends ServiceImpl<NeedsOrdersMapper, NeedsOrders> implements NeedsOrdersService {

}
