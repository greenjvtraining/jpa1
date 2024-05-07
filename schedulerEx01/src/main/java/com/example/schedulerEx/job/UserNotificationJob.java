package com.example.schedulerEx.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.schedulerEx.service.UserService;

public class UserNotificationJob implements Job{

	@Autowired
	private UserService userService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		userService.notifyInactiveUsers();
	}
}
