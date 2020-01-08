package com.example.demo.api.jwt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.config.common.BaseController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(BaseController.JWT_URL+"/order")
@Api(description = "订单相关接口 ",tags="订单接口  ")
@MapperScan("com.example.demo.supermarket.order.mapper")
public class YkhOrderController {

}
