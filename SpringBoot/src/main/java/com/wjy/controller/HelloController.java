package com.wjy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/getHello")
	public String getHello() {

		return "Hello SpringBoot !!!";

	}

}
