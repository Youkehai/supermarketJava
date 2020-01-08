package com.example.demo.supermarket.user.service.impl;

import com.example.demo.supermarket.user.entity.TSetting;
import com.example.demo.supermarket.user.mapper.TSettingMapper;
import com.example.demo.supermarket.user.service.ITSettingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置表 服务实现类
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
@Service
public class TSettingServiceImpl extends ServiceImpl<TSettingMapper, TSetting> implements ITSettingService {

}
