package com.nurochim.wfh;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class WfhDirInovasiJob implements Job{
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			ProcessBuilder builder = new ProcessBuilder(
	            "cmd.exe", "/c", "cd \"D:\\Programmer Study\\Automated Test\\Selenium\\SeleniumMavenTemplate\" && mvn -Dbrowser=chrome -Dit.test=WfhDirInovasiIT verify");
	        builder.redirectErrorStream(true);
	        Process p = builder.start();
	        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
	        String line;
	        while (true) {
	            line = r.readLine();
	            if (line == null) { break; }
	            System.out.println(line);
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
    } 
}
