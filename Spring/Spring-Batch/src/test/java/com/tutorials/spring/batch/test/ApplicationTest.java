/**
 * 
 */
package com.tutorials.spring.batch.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Siddhant sahu
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/Spring-Application-Config.xml", "classpath*:/test-context.xml" })
public class ApplicationTest {
	@Autowired
	private ApplicationContext context;
	/*@Autowired
	@Qualifier("employeeJob")
	private JobLauncherTestUtils jobLauncherTestUtils;*/

	@Test
	public void launchJob() throws Exception {
		// Creating the job launcher
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

		// Creating the job
		Job job = (Job) context.getBean("employeeJob");

		final JobParameters param = new JobParametersBuilder().addString("EMPID", "100").toJobParameters();
		// Executing the JOB
		JobExecution execution = jobLauncher.run(job, param);
		System.out.println("Exit Status : " + execution.getStatus());
	}

	@Ignore
	public void launchJobemployeeXMLToCSVJob() throws Exception {
		// Creating the job launcher
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");

		// Creating the job
		Job job = (Job) context.getBean("employeeXMLToCSVJob");

		// Executing the JOB
		JobExecution execution = jobLauncher.run(job, new JobParameters());
		System.out.println("Exit Status : " + execution.getStatus());
	}
	@Ignore
	public void launchJobAssert() throws Exception {
		/*JobExecution jobExecution = jobLauncherTestUtils.launchJob();
		// JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());*/
	}
}
