package com.donkey.service.impl;

import com.donkey.domain.User.entity.User;
import com.donkey.mapper.UserMapper;
import com.donkey.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
