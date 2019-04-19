package com.wjy.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wjy.pojo.Resource;
import com.wjy.pojo.JSONResult;

@RestController
public class ResourceController {

	@Autowired
	private Resource resource;

	@GetMapping(value = "/getResource")
	public JSONResult getResource() {

		Resource bean = new Resource();
		try {
			BeanUtils.copyProperties(resource, bean);
		} catch (Exception e) {
			return JSONResult.errorException("获取配置文件失败");
		}
		return JSONResult.ok(bean);

	}

}
