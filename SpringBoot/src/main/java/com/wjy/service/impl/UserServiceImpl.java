package com.wjy.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wjy.mapper.UserMapper;
import com.wjy.mapper.UserMapperCustom;
import com.wjy.pojo.User;
import com.wjy.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserMapperCustom userMapperCustom;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public User login(String account, String password) throws Exception {

		User user = new User();

		user.setAccount(account);
		user.setPassword(password);

		List<User> list = userMapperCustom.selectUserbyAccountandPassword(user);

		if (list.size() == 1) {
			return list.get(0);
		} else {
			throw new Exception();
		}

	}

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public int verify(String account) throws Exception {

		int temp = userMapperCustom.countUserbyAccount(account);

		return temp == 1 ? 0 : 1;

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int register(String account, String password) {

		User user = new User();

		user.setUserId(getUUID());
		user.setAccount(account);
		user.setPassword(password);

		int temp = userMapper.insert(user);

		return temp;
	}
	
	private static String getUUID() {
		
		return UUID.randomUUID().toString();
		
	}

}
