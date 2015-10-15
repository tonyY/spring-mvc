package com.springmvc.controller;

import java.text.ParseException;
import java.util.Random;

import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class ScheduleInfoAction {

	@Autowired
	org.springframework.scheduling.quartz.SchedulerFactoryBean myScheduler;
	@Autowired
	org.springframework.scheduling.quartz.SimpleTriggerFactoryBean oldTrigger;

	@RequestMapping(value="/reSheduleTrigger",method=RequestMethod.GET)
	public void retScheduleJob() throws SchedulerException, ParseException {
		TriggerBuilder<SimpleTrigger> tb = oldTrigger.getObject().getTriggerBuilder();
		int number = new Random().nextInt(10) + 1;
		//System.out.println("动态改变执行时间为"+number+"秒");
		Trigger newTrigger = tb.withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(number)).build();
		//Trigger trigger = tb.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		myScheduler.getObject().rescheduleJob(oldTrigger.getObject().getKey(), newTrigger);
	}
}
