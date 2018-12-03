package com.grts.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grts.service.IRedisService;
import com.grts.service.IUserService;

@Controller
@RequestMapping("/redis")
public class RedisTest {

	@Resource
	private IRedisService redisService;
	@Resource
	private IUserService userService;
	@RequestMapping("/user")
	public String user(){
		String user=redisService.get("user");
		if(user!=null){
			System.out.println("存在："+user);
		}else{
			System.out.println("不存在："+user);
			redisService.set("user", userService.selectByPrimaryKey(10).toString());
		}
		return ""+user;
	}
}
