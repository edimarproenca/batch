package com.learn.batch.job;

import javax.batch.runtime.BatchStatus;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JobNotification extends JobExecutionListenerSupport {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("Before Job! | ID -> " + jobExecution.getJobId() );
	}
	
	
	
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {
			log.info("Job Finished");
		}
	}
	
}
