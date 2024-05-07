package com.example.schedulerEx.config;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import com.example.schedulerEx.job.UserNotificationJob;

@Configuration
public class SchedulerConfig {

	@Bean
	public JobDetail jobDetail() {
		System.out.println("jobDetail....");
		return JobBuilder.newJob().ofType(UserNotificationJob.class)
				.storeDurably()
				.withIdentity("UserNotificationJob")
				.withDescription("사용자 알림 작업")
				.build();
	}
	
	@Bean
	public Trigger trigger(JobDetail job) {
		return TriggerBuilder.newTrigger().forJob(job)
				.withIdentity("UserNotificationTrigger")
				.withDescription("사용자 알림 트리거")
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInSeconds(5))
				.build();
	}
	
	@Bean
	public Scheduler scheduler(Trigger trigger, JobDetail job) throws SchedulerException {
		StdSchedulerFactory factory = new StdSchedulerFactory();
		factory.initialize();
		
		Scheduler scheduler = factory.getScheduler();
        scheduler.setJobFactory(springBeanJobFactory());
        scheduler.scheduleJob(job, trigger);
        scheduler.start();

        return scheduler;
	}
	
	@Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        return new SpringBeanJobFactory();
    }
}
