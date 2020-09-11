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
		String expCheckOutDI = "0 5 16,17,18,20,22,23 ? * MON-FRI";
    	String expCheckInDI1 = "0 9 6,9,10 ? * MON-FRI";
    	String expCheckInDI2 = "0 14 7,8 ? * MON-FRI";
    	
        Trigger triggerChekIn1 = TriggerBuilder.newTrigger().withIdentity("triggerChekInDI1")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckInDI1)).build();
        Trigger triggerChekIn2 = TriggerBuilder.newTrigger().withIdentity("triggerChekInDI2")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckInDI2)).build();
    	Trigger triggerChekOut2 = TriggerBuilder.newTrigger().withIdentity("triggerChekOut1")
                .withSchedule(CronScheduleBuilder.cronSchedule(expCheckOutDI)).build();
    	
    	Set<Trigger> triggers2 = new HashSet<Trigger>();
    	triggers2.add(triggerChekIn1);
    	triggers2.add(triggerChekIn2);
        triggers2.add(triggerChekOut2);
        
        JobDetail DirInovasiJob = JobBuilder.newJob(WfhDirInovasiJob.class).withIdentity("DirInovasiJob").build();
        Map<JobDetail, Set<? extends Trigger>> triggersAndJobsDI = new HashMap<JobDetail, Set<? extends Trigger>>();
        triggersAndJobsDI.put(DirInovasiJob, triggers2);
        
        Scheduler scheduler2 = new StdSchedulerFactory().getScheduler(); 
        scheduler2.start(); 
        scheduler2.scheduleJobs(triggersAndJobsDI, false);
	}
}
