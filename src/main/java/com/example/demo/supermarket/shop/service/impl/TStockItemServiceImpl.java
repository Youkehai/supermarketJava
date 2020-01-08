package com.example.demo.supermarket.shop.service.impl;

import com.example.demo.supermarket.shop.entity.TStockItem;
import com.example.demo.supermarket.shop.mapper.TStockItemMapper;
import com.example.demo.supermarket.shop.service.ITStockItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 库存表 服务实现类
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
@Service
public class TStockItemServiceImpl extends ServiceImpl<TStockItemMapper, TStockItem> implements ITStockItemService {

}
