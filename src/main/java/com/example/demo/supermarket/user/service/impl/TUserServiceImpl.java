package com.example.demo.supermarket.user.service.impl;

import com.example.demo.supermarket.user.entity.TUser;
import com.example.demo.supermarket.user.mapper.TUserMapper;
import com.example.demo.supermarket.user.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}
