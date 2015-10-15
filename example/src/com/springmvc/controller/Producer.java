package com.springmvc.controller;

import java.util.Date;

public class Producer {
	public void executeListener() {
		System.out.println(
				"执行任务 ，当前执行时间 :: " + (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date()));
	}
}
