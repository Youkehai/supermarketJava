package com.example.demo.supermarket.shop.mapper;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.supermarket.shop.entity.TShop;

/**
 * <p>
 * 商品表 Mapper 接口
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
public interface TShopMapper extends BaseMapper<TShop> {

	Page<TShop> selectSrmAndTypeInfoPage(Page<TShop> page,@Param(Constants.WRAPPER) QueryWrapper<TShop> queryWrapper);

	int insertAndUpdate(TShop shop);
}
