package com.wjy.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TimeTask {

	private final static SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 60 * 1000)
	public void getCurrentTime() {

		System.out.println("时间：" + dateFormat.format(new Date()));

	}

}
