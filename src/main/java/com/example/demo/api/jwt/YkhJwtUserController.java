package com.example.demo.api.jwt;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.config.common.BaseController;
import com.example.demo.config.common.WebResult;
import com.example.demo.config.utils.JWTUtils;
import com.example.demo.supermarket.user.entity.TUser;
import com.example.demo.supermarket.user.mapper.TSettingMapper;
import com.example.demo.supermarket.user.mapper.TUserBuyMapper;
import com.example.demo.supermarket.user.mapper.TUserMapper;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(BaseController.JWT_URL+"/user")
@Api(description = "用户相关接口 ",tags="用户接口  ")
@MapperScan("com.example.demo.supermarket.user.mapper")
public class YkhJwtUserController extends BaseController{

	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TUserBuyMapper tUserBuyMapper;
	@Autowired
	private TSettingMapper tSettingMapper;
	
	
	@ApiOperation(value = "获取自己登录的信息", notes = "")
	@GetMapping("/userInfo")
	public WebResult getUserInfo(@RequestHeader(Authorization)String token) throws UnsupportedEncodingException {
		 Claims userMap=JWTUtils.verifyToken(token);
		 String userId=userMap.get("uid",String.class);
		 String role=userMap.get("role",String.class);
		 String username=userMap.get("username",String.class);
		 TUser user=new TUser();
		 user.setUsername(username);
		 user.setId(userId);
		 user.setRole(role);
		return selectSuccess(user);
	}
	
	@ApiOperation(value = "查询所有用户", notes = "")
	@GetMapping("/user")
	public WebResult getWarehouse(@RequestHeader(Authorization)String token,String name,Page<TUser> page) throws UnsupportedEncodingException {
		QueryWrapper<TUser> queryWrapper= new QueryWrapper<>();
		if(StrUtil.isNotBlank(name)) {
			queryWrapper.like("name", name);
		}
		//queryWrapper.eq("role", "user");
		Page<TUser> pageList=tUserMapper.selectPage(page, queryWrapper);
		//List<TShopType> typeList=tShopTypeMapper.selectList(queryWrapper);
		if(pageList.getRecords()!=null && !pageList.getRecords().isEmpty()) {
			return selectSuccess(pageList);
		}
		return selectNotFound();
	}
	
	@ApiOperation(value = "新增用户", notes = "")
	@PostMapping("/user")
	public WebResult getWarehouse(@RequestHeader(Authorization)String token,String name,@RequestBody TUser user) throws UnsupportedEncodingException {
		user.setRole("user");
		user.setCreateDate(LocalDateTime.now());
		String password=user.getPassword();
		String s2 = HexUtil.encodeHexStr(password);//密码通过加密，数据库不会存储真实密码
		//user.setCreateDate(LocalDateTime.now());
		user.setPassword(s2);
		int i=tUserMapper.insert(user);
		//List<TShopType> typeList=tShopTypeMapper.selectList(queryWrapper);
		if(i>0) {
			return insertSuccess(user);
		}
		return insertDataRepeat();
	}
	
}
