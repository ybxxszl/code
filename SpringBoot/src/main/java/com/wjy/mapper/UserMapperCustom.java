package com.wjy.mapper;

import java.util.List;

import com.wjy.GeneralMapper;
import com.wjy.pojo.User;

public interface UserMapperCustom extends GeneralMapper<User> {

	List<User> selectUserbyAccountandPassword(User user);

	int countUserbyAccount(String account);

}