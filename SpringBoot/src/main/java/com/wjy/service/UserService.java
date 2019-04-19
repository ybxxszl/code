package com.wjy.service;

import com.wjy.pojo.User;

public interface UserService {

	User login(String account, String password) throws Exception;

	int verify(String account) throws Exception;

	int register(String account, String password);

}
