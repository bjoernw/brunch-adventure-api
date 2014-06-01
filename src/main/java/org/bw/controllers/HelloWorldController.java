package org.bw.controllers;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import org.bw.applicationconfig.AppConfiguration;
import org.bw.model.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by bjoernweidlich on 5/27/14.
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldController
{
	private final AtomicLong counter = new AtomicLong();
	private final String template;
	private final String defaultName;

	public HelloWorldController(AppConfiguration cfg)
	{
		this.template = cfg.getTemplate();
		this.defaultName = cfg.getDefaultName();
	}

	@Timed // monitor timing of this service with Metrics
	@GET
	public Saying sayHello(@QueryParam("name") Optional<String> name) throws InterruptedException
	{
		final String value = String.format(template, name.or(defaultName));
		Thread.sleep(ThreadLocalRandom.current().nextInt(10, 500));
		return new Saying(counter.incrementAndGet(), value);
	}
}
