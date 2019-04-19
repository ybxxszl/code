package com.wjy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wjy.pojo.User;
import com.wjy.service.UserService;
import com.wjy.pojo.JSONResult;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	public JSONResult login(@Param(value = "account") String account, @Param(value = "password") String password) {

		log.info("登录");

		User u = null;
		try {
			u = userService.login(account, password);
		} catch (Exception e) {
			return JSONResult.errorMsg("网络不太好呢。。。");
		}
		return JSONResult.ok(u);

	}

	@PostMapping(value = "/verify")
	public JSONResult verify(@Param(value = "account") String account) {

		log.info("验证");

		int temp;
		try {
			temp = userService.verify(account);
		} catch (Exception e) {
			return JSONResult.errorMsg("网络不太好呢。。。");
		}
		return JSONResult.ok(temp);

	}

	@PostMapping(value = "/register")
	public JSONResult register(@Param(value = "account") String account, @Param(value = "password") String password) {

		log.info("注册");

		int temp;
		try {
			temp = userService.register(account, password);
		} catch (Exception e) {
			return JSONResult.errorMsg("网络不太好呢。。。");
		}
		return JSONResult.ok(temp);

	}

}
