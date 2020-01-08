package com.example.demo.api.jwt;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.config.common.BaseContant;
import com.example.demo.config.common.BaseController;
import com.example.demo.config.common.WebResult;
import com.example.demo.config.enums.BaseErrorEnum;
import com.example.demo.config.utils.JWTUtils;
import com.example.demo.supermarket.shop.entity.TShop;
import com.example.demo.supermarket.shop.entity.TShopType;
import com.example.demo.supermarket.shop.entity.TSrmInfo;
import com.example.demo.supermarket.shop.entity.TWarehouse;
import com.example.demo.supermarket.shop.mapper.TShopMapper;
import com.example.demo.supermarket.shop.mapper.TShopTypeMapper;
import com.example.demo.supermarket.shop.mapper.TSrmInfoMapper;
import com.example.demo.supermarket.shop.mapper.TWarehouseMapper;
import com.example.demo.supermarket.shop.service.impl.TShopServiceImpl;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(BaseController.JWT_URL+"/shop")
@Api(description = "商品相关接口 ",tags="商品接口  ")
@MapperScan("com.example.demo.supermarket.shop.mapper")
public class YkhShopController  extends BaseController{

	@Autowired
	private TShopTypeMapper tShopTypeMapper;
	@Autowired
	private TShopMapper tShopMapper;
	@Autowired
	private TWarehouseMapper tWarehouseMapper;
	@Autowired
	private TSrmInfoMapper tSrmInfoMapper;
	@Autowired
	private TShopServiceImpl tShopServiceImpl;
	
	@ApiOperation(value = "查询所有商品类型", notes = "")
	@GetMapping("/shopType")
	public WebResult getShopType(@RequestHeader(Authorization)String token,String name,Page page) throws UnsupportedEncodingException {
		QueryWrapper<TShopType> queryWrapper= new QueryWrapper<>();
		if(StrUtil.isNotBlank(name)) {
			queryWrapper.like("name", name);
		}
		@SuppressWarnings("unchecked")
		Page<TShopType> pageList=tShopTypeMapper.selectPage(page, queryWrapper);
		//List<TShopType> typeList=tShopTypeMapper.selectList(queryWrapper);
		if(pageList.getRecords()!=null && !pageList.getRecords().isEmpty()) {
			return selectSuccess(pageList);
		}
		return selectNotFound();
	}
	
	@ApiOperation(value = "商品类型新增", notes = "")
	@PostMapping("/shopType")
	public WebResult insertShopType(@RequestHeader(Authorization)String token,@RequestBody TShopType type) throws UnsupportedEncodingException {
		 Claims userMap=JWTUtils.verifyToken(token);
		 type.setCreateId(userMap.get("uid",String.class));
		 type.setCreateName(userMap.get("username",String.class));
		 type.setCreateDate(LocalDateTime.now());
		int i=tShopTypeMapper.insert(type);
		if(i>0) {
			return insertSuccess(type);
		}
		return insertDataRepeat();
	}
	
	@ApiOperation(value = "商品类型修改", notes = "")
	@PutMapping("/shopType")
	public WebResult updateShopType(@RequestHeader(Authorization)String token,@RequestBody @Validated TShopType type) throws UnsupportedEncodingException {
		int i=tShopTypeMapper.updateById(type);
		if(i>0) {
			return updateSuccess(type);
		}
		return updateNotFound();
	}
	
	@ApiOperation(value = "商品类型删除", notes = "")
	@DeleteMapping("/shopType/{id}")
	public WebResult deleteShopType(@RequestHeader(Authorization)String token,@PathVariable("id") String id) throws UnsupportedEncodingException {
		QueryWrapper<TShop> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("type_id", id);
		List<TShop> shopList=tShopMapper.selectList(queryWrapper);
		if(shopList!=null && shopList.size()>0) {
			return error(BaseErrorEnum.ERR_DELETE_DATA_USE);
		}
		int i=tShopTypeMapper.deleteById(id);
		if(i>0) {
			return deleteSuccess(id);
		}
		return deleteNotFound();
	}
	
	
	@ApiOperation(value = "查询所有商品信息", notes = "")
	@GetMapping("/shopInfo")
	public WebResult getShopInfo(@RequestHeader(Authorization)String token,String name,Page<TShop> page) throws UnsupportedEncodingException {
		QueryWrapper<TShop> queryWrapper= new QueryWrapper<>();
		if(StrUtil.isNotBlank(name)) {
			queryWrapper.like("name", name);
		}
		Page<TShop> pageList=tShopMapper.selectSrmAndTypeInfoPage(page, queryWrapper);
		//List<TShopType> typeList=tShopTypeMapper.selectList(queryWrapper);
		if(pageList.getRecords()!=null && !pageList.getRecords().isEmpty()) {
			return selectSuccess(pageList);
		}
		return selectNotFound();
	}
	
	@ApiOperation(value = "商品信息新增", notes = "")
	@PostMapping("/shopInfo")
	public WebResult insertShopInfo(@RequestHeader(Authorization)String token,@RequestBody TShop shop) throws UnsupportedEncodingException {
		 Claims userMap=JWTUtils.verifyToken(token);
		 shop.setCreateId(userMap.get("uid",String.class));
		 shop.setCreateName(userMap.get("username",String.class));
		 shop.setCreateDate(LocalDateTime.now());
		int i= tShopServiceImpl.insertAndUpdate(shop);
		//int i=tShopMapper.insert(shop);
		if(i>0) {
			return insertSuccess(shop);
		}
		return insertDataRepeat();
	}
	
	@ApiOperation(value = "商品信息修改", notes = "")
	@PutMapping("/shopInfo")
	public WebResult updateShopInfo(@RequestHeader(Authorization)String token,@RequestBody @Validated TShop shop) throws UnsupportedEncodingException {
		boolean update=tShopServiceImpl.updateAndUpdate(shop);
		//int i=tShopMapper.updateById(shop);
		if(update) {
			return updateSuccess(shop);
		}
		return updateNotFound();
	}
	
	@ApiOperation(value = "商品信息删除", notes = "")
	@DeleteMapping("/shopInfo/{id}")
	public WebResult deleteShopInfo(@RequestHeader(Authorization)String token,@PathVariable("id") String id) throws UnsupportedEncodingException {
		int i=tShopMapper.deleteById(id);
		if(i>0) {
			return deleteSuccess(id);
		}
		return deleteNotFound();
	}
	
	@ApiOperation(value = "查询所有供应商", notes = "")
	@GetMapping("/srm")
	public WebResult getSrmInfo(@RequestHeader(Authorization)String token,String name,Page<TSrmInfo> page) throws UnsupportedEncodingException {
		QueryWrapper<TSrmInfo> queryWrapper= new QueryWrapper<>();
		if(StrUtil.isNotBlank(name)) {
			queryWrapper.like("name", name);
		}
		Page<TSrmInfo> pageList=tSrmInfoMapper.selectPage(page, queryWrapper);
		//List<TShopType> typeList=tShopTypeMapper.selectList(queryWrapper);
		if(pageList.getRecords()!=null && !pageList.getRecords().isEmpty()) {
			return selectSuccess(pageList);
		}
		return selectNotFound();
	}
	
	@ApiOperation(value = "供应商信息新增", notes = "")
	@PostMapping("/srm")
	public WebResult insertSrmInfo(@RequestHeader(Authorization)String token,@RequestBody TSrmInfo srm) throws UnsupportedEncodingException {
		 Claims userMap=JWTUtils.verifyToken(token);
		 srm.setCreateId(userMap.get("uid",String.class));
		 srm.setCreateName(userMap.get("username",String.class));
		 srm.setCreateDate(LocalDateTime.now());
		 srm.setStatus(BaseContant.SRM_STATUS_NOT_NORMAL);
		int i=tSrmInfoMapper.insert(srm);
		if(i>0) {
			return insertSuccess(srm);
		}
		return insertDataRepeat();
	}
	
	@ApiOperation(value = "供应商信息修改", notes = "")
	@PutMapping("/srm")
	public WebResult updateSrmInfo(@RequestHeader(Authorization)String token,@RequestBody @Validated TSrmInfo srm) throws UnsupportedEncodingException {
		int i=tSrmInfoMapper.updateById(srm);
		if(i>0) {
			return updateSuccess(srm);
		}
		return updateNotFound();
	}
	
	@ApiOperation(value = "供应商信息删除", notes = "")
	@DeleteMapping("/srm/{id}")
	public WebResult deleteSrmInfo(@RequestHeader(Authorization)String token,@PathVariable("id") String id) throws UnsupportedEncodingException {
		
		QueryWrapper<TShop> queryWrapper=new QueryWrapper<>();
		queryWrapper.eq("srm_id", id);
		List<TShop> shopList=tShopMapper.selectList(queryWrapper);
		if(shopList!=null && shopList.size()>0) {
			return error(BaseErrorEnum.ERR_DELETE_DATA_USE);
		}
		int i=tSrmInfoMapper.deleteById(id);
		if(i>0) {
			return deleteSuccess(id);
		}
		return deleteNotFound();
	}
	
	@ApiOperation(value = "查询所有仓库", notes = "")
	@GetMapping("/warehouse")
	public WebResult getWarehouse(@RequestHeader(Authorization)String token,String name,Page<TWarehouse> page) throws UnsupportedEncodingException {
		QueryWrapper<TWarehouse> queryWrapper= new QueryWrapper<>();
		if(StrUtil.isNotBlank(name)) {
			queryWrapper.like("name", name);
		}
		Page<TWarehouse> pageList=tWarehouseMapper.selectPage(page, queryWrapper);
		//List<TShopType> typeList=tShopTypeMapper.selectList(queryWrapper);
		if(pageList.getRecords()!=null && !pageList.getRecords().isEmpty()) {
			return selectSuccess(pageList);
		}
		return selectNotFound();
	}
	
	@ApiOperation(value = "仓库信息新增", notes = "")
	@PostMapping("/warehouse")
	public WebResult insertWarehouse(@RequestHeader(Authorization)String token,@RequestBody TWarehouse warehouse) throws UnsupportedEncodingException {
		 Claims userMap=JWTUtils.verifyToken(token);
		 warehouse.setCreateId(userMap.get("uid",String.class));
		 warehouse.setCreateName(userMap.get("username",String.class));
		 warehouse.setCreateDate(LocalDateTime.now());
		int i=tWarehouseMapper.insert(warehouse);
		if(i>0) {
			return insertSuccess(warehouse);
		}
		return insertDataRepeat();
	}
	
	@ApiOperation(value = "仓库信息修改", notes = "")
	@PutMapping("/warehouse")
	public WebResult updateWarehouse(@RequestHeader(Authorization)String token,@RequestBody @Validated TWarehouse warehouse) throws UnsupportedEncodingException {
		int i=tWarehouseMapper.updateById(warehouse);
		if(i>0) {
			return updateSuccess(warehouse);
		}
		return updateNotFound();
	}
	
	@ApiOperation(value = "仓库信息删除", notes = "")
	@DeleteMapping("/warehouse/{id}")
	public WebResult deleteWarehouse(@RequestHeader(Authorization)String token,@PathVariable("id") String id) throws UnsupportedEncodingException {
		int i=tWarehouseMapper.deleteById(id);
		if(i>0) {
			return deleteSuccess(id);
		}
		return deleteNotFound();
	}
}
