package com.donkey.service.impl;

import com.donkey.entity.Employee;
import com.donkey.mapper.EmployeeMapper;
import com.donkey.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表--暂不考虑 服务实现类
 * </p>
 *
 * @author liu'yao
 * @since 2023-06-04
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
