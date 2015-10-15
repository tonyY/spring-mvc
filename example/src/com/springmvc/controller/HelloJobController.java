package com.springmvc.controller;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloJobController {

	//@Scheduled(cron = "*/5 * * * * ?")
	 @Scheduled(fixedDelay = 5000)
	public void demoServiceMethod() {
		System.out.println("Method executed at every 5 seconds. Current time is :: "
				+ (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));

	}

}
