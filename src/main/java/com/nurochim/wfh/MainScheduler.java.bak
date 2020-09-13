package com.nurochim.wfh;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class MainScheduler {
	
	public static void main(String[] args) {
        try {
            SchedulerCpns();
            SchedulerDirInovasi();
        }
        catch(Exception e){ 
            e.printStackTrace();
        }
	}
	
	private static void SchedulerCpns() throws SchedulerException {
    	String expCheckOutCpns = "0 0 19,21 ? * MON-FRI";
    	String expCheckInCpns = "0 20 7,8 ? * MON-FRI";
    	
    	String exp = "0 40,59 21,21 ? * MON-FRI";
    	
    	Trigger triggerChekIn = TriggerBuilder.newTrigger().withIdentity("triggerChekIn")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckInCpns)).build();
    	Trigger triggerChekOut = TriggerBuilder.newTrigger().withIdentity("triggerChekOut")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckOutCpns)).build();
    	
    	Set<Trigger> triggers = new HashSet<Trigger>();
        triggers.add(triggerChekIn);
        triggers.add(triggerChekOut);

        JobDetail CpnsJob = JobBuilder.newJob(WfhCpnsJob.class).withIdentity("CpnsJob").build();
        Map<JobDetail, Set<? extends Trigger>> triggersAndJobsCpns = new HashMap<JobDetail, Set<? extends Trigger>>();
        triggersAndJobsCpns.put(CpnsJob, triggers);
        
        // Direktorat Inovasi
        Scheduler scheduler1 = new StdSchedulerFactory().getScheduler(); 
        scheduler1.start(); 
        scheduler1.scheduleJobs(triggersAndJobsCpns, false);
        
	}
	
	private static void SchedulerDirInovasi() throws SchedulerException {
		
		String expCheckOutDI1 = "0 10/15 16 ? * 1-7";
		String expCheckOutDI2 = "0 45 15 ? * 1-7";
		String expCheckOutDI3 = "0 5 17,18,20,22,23 ? * 1-7";
    	
    	String expCheckInDI1 = "0 55 5 ? * 1-7";
    	String expCheckInDI2 = "0 9,30,45 6 ? * 1-7";
    	String expCheckInDI3 = "0 5,20,45 7 ? * 1-7";
    	String expCheckInDI4 = "0 14 8,9,10 ? * 1-7";
    	
        Trigger triggerChekIn1 = TriggerBuilder.newTrigger().withIdentity("triggerChekInDI1")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckInDI1)).build();
        Trigger triggerChekIn2 = TriggerBuilder.newTrigger().withIdentity("triggerChekInDI2")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckInDI2)).build();
    	Trigger triggerChekIn3 = TriggerBuilder.newTrigger().withIdentity("triggerChekInDI3")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckInDI3)).build();
    	Trigger triggerChekIn4 = TriggerBuilder.newTrigger().withIdentity("triggerChekInDI4")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckInDI4)).build();
    	Trigger triggerChekOut1 = TriggerBuilder.newTrigger().withIdentity("triggerChekOut1")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckOutDI1)).build();
    	Trigger triggerChekOut2 = TriggerBuilder.newTrigger().withIdentity("triggerChekOut2")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckOutDI2)).build();
    	Trigger triggerChekOut3 = TriggerBuilder.newTrigger().withIdentity("triggerChekOut3")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckOutDI3)).build();
    	
    	
    	
    	Set<Trigger> triggers2 = new HashSet<Trigger>();
    	triggers2.add(triggerChekIn1);
    	triggers2.add(triggerChekIn2);
    	triggers2.add(triggerChekIn3);
    	triggers2.add(triggerChekIn4);
        triggers2.add(triggerChekOut1);
        triggers2.add(triggerChekOut2);
        triggers2.add(triggerChekOut3);
        
        JobDetail DirInovasiJob = JobBuilder.newJob(WfhDirInovasiJob.class).withIdentity("DirInovasiJob").build();
        Map<JobDetail, Set<? extends Trigger>> triggersAndJobsDI = new HashMap<JobDetail, Set<? extends Trigger>>();
        triggersAndJobsDI.put(DirInovasiJob, triggers2);
        
        Scheduler scheduler2 = new StdSchedulerFactory().getScheduler(); 
        scheduler2.start(); 
        scheduler2.scheduleJobs(triggersAndJobsDI, false);
	}
}
