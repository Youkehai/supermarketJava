package com.example.demo.api.open;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.config.common.BaseController;
import com.example.demo.config.common.WebResult;
import com.example.demo.config.utils.JWTUtils;
import com.example.demo.supermarket.user.entity.TUser;
import com.example.demo.supermarket.user.mapper.TSettingMapper;
import com.example.demo.supermarket.user.mapper.TUserBuyMapper;
import com.example.demo.supermarket.user.mapper.TUserMapper;

import cn.hutool.core.util.HexUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(BaseController.OPEN_URL+"/user")
@Api(description = "用户相关接口 ",tags="用户接口  ")
@MapperScan("com.example.demo.supermarket.user.mapper")
public class YkhOpenUserController extends BaseController{

	@Autowired
	private TUserMapper tUserMapper;
	@Autowired
	private TUserBuyMapper tUserBuyMapper;
	@Autowired
	private TSettingMapper tSettingMapper;
	
	@ApiOperation(value = "注册", notes = "")
	@PostMapping("/user")
	public WebResult selectAllUser(@RequestBody TUser user) {
		String password=user.getPassword();
		String s2 = HexUtil.encodeHexStr(password);
		//user.setCreateDate(LocalDateTime.now());
		user.setPassword(s2);
		tUserMapper.insert(user);
		return insertSuccess(user);
	}
	
	@ApiOperation(value = "登录", notes = "登录")
	@PostMapping("/login")
	public WebResult login(@RequestBody TUser user) throws UnsupportedEncodingException {
		String password=user.getPassword();
		String s2 = HexUtil.encodeHexStr(password);
		QueryWrapper<TUser> queryWrapper= new QueryWrapper<>();
		queryWrapper.eq("password", s2).eq("username", user.getUsername());
		TUser users=tUserMapper.selectOne(queryWrapper);
		if(users!=null) {
			//设置jwt过期时间为十个小时36000000
			String token=JWTUtils.createToken(users,36000000);
			WebResult result=WebResult.success("登录成功",user);
			result.setAttribute("token", token);
			return result;
		}
		return selectNotFound();
	}
	
	
	
	@ApiOperation(value = "查询所有用户的数据", notes = "")
	@GetMapping("/jwt/user")
	public WebResult selectAllUser() {
		QueryWrapper<TUser> queryWrapper= new QueryWrapper<>();
		queryWrapper.eq("role", "user");
		List<TUser> userList=tUserMapper.selectList(queryWrapper);
		return selectSuccess(userList);
	}
}
