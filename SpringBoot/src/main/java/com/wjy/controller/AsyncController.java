package com.wjy.controller;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wjy.task.AsyncTask;

@RestController
public class AsyncController {

	@Autowired
	private AsyncTask asyncTask;

	@GetMapping(value = "/getConsumingTime")
	public String getConsumingTime() throws InterruptedException {

		long start = System.currentTimeMillis();

		Future<Boolean> asyncResult1 = asyncTask.asyncTask1();
		Future<Boolean> asyncResult2 = asyncTask.asyncTask2();

		while (!asyncResult1.isDone() || !asyncResult2.isDone()) {
			if (asyncResult1.isDone() && asyncResult2.isDone()) {
				break;
			}
		}

		long end = System.currentTimeMillis();

		String time = "总耗时：" + (end - start) + "毫秒";

		System.out.println(time);

		return time;

	}

}
