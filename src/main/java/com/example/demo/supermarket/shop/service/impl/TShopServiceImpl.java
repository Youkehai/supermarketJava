package com.example.demo.supermarket.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.config.common.BaseContant;
import com.example.demo.supermarket.shop.entity.TShop;
import com.example.demo.supermarket.shop.entity.TSrmInfo;
import com.example.demo.supermarket.shop.mapper.TShopMapper;
import com.example.demo.supermarket.shop.mapper.TSrmInfoMapper;
import com.example.demo.supermarket.shop.service.ITShopService;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author youkehai
 * @since 2019-12-26
 */
@Service
public class TShopServiceImpl extends ServiceImpl<TShopMapper, TShop> implements ITShopService {
	@Autowired
	private TSrmInfoMapper tSrmInfoMapper;
	/***
	 * 新增商品信息和修改供应商状态
	 * @param shop
	 * @return
	 */
	@Transactional
	public int insertAndUpdate(TShop shop) {
		save(shop);
		TSrmInfo update=new TSrmInfo();
		update.setId(shop.getSrmId());
		update.setStatus(BaseContant.SRM_STATUS_NORMAL);
		int i=tSrmInfoMapper.updateById(update);
		return i;
	}
	
	/***
	 * 修改商品信息和修改供应商状态
	 * @param shop
	 * @return
	 */
	@Transactional
	public boolean updateAndUpdate(TShop shop) {
		//先查询之前这个商品的供应商
		TShop oldShop=getById(shop.getId());
		//如果改了供应商
		if(!shop.getSrmId().equals(oldShop.getSrmId())) {
			//在查询这个供应商是否还在和其他商品合作，如果没有，则修改状态为1
			QueryWrapper<TShop> queryWrapper=new QueryWrapper<>();
			queryWrapper.eq("srm_id", oldShop.getSrmId());
			List<TShop> shopList=list(queryWrapper);
			//如果没有合作了，则修改
			if(shopList==null || shopList.isEmpty()) {
				TSrmInfo update=new TSrmInfo();
				update.setId(oldShop.getSrmId());
				update.setStatus(BaseContant.SRM_STATUS_NOT_NORMAL);
				tSrmInfoMapper.updateById(update);
			}
			TSrmInfo update=new TSrmInfo();
			update.setId(shop.getSrmId());
			update.setStatus(BaseContant.SRM_STATUS_NORMAL);
			//修改新的供应商状态为合作中
			tSrmInfoMapper.updateById(update);
		}
		//修改商品信息
		return updateById(shop);
	}

}
