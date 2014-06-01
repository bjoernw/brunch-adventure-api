package org.bw.tasks;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * Created by bjoernweidlich on 5/21/14.
 */
public final class WebScrapeJob extends QuartzJobBean
{
	private IScrapeTask task;

	public void setTask(final IScrapeTask task)
	{
		this.task = task;
	}

	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException
	{
		task.scrape();
	}
}