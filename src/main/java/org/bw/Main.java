package org.bw;

/**
 * Created by bjoernweidlich on 5/18/14.
 */

import com.codahale.metrics.JmxReporter;
import com.google.common.collect.ImmutableMultimap;
import com.sun.jersey.api.client.Client;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.servlets.tasks.Task;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.bw.applicationconfig.AppConfiguration;
import org.bw.client.ConsumerResource;
import org.bw.controllers.HelloWorldController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.PrintWriter;


public class Main extends Application<AppConfiguration>
{
	public static void main(String[] args) throws Exception
	{
		if (args == null || args.length < 1) {
			new Main().run(new String[]{"server", "src/main/resources/config.yml"});
		}
		else if (args != null) {
			new Main().run(args);
		}
		else {
			new Main().run(new String[]{"server", System.getProperty("dropwizard.config")});
		}

		ApplicationContext context =
				new ClassPathXmlApplicationContext("main_context.xml");
	}

	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap)
	{
		bootstrap.addBundle(new AssetsBundle());
	}

	@Override
	public void run(AppConfiguration cfg, Environment env)
	{
		JmxReporter.forRegistry(env.metrics()).build().start(); // Manually add JMX reporting (Dropwizard regression)

		env.jersey().register(new HelloWorldController(cfg));
		Client client = new JerseyClientBuilder(env).using(cfg.getJerseyClientConfiguration()).build("client");
		env.jersey().register(new ConsumerResource(client));

		env.admin().addTask(new Task("sometask")
		{
			@Override
			public void execute(ImmutableMultimap<String, String> parameters, PrintWriter output) throws Exception
			{
				System.out.println("whatup");
			}
		});

		//initializeAtmosphere(cfg, env);

		//DBI dbi = null;
//        try {
//            dbi = new DBIFactory().build(env, cfg.getDataSourceFactory(), "db");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        env.jersey().register(new DBResource(dbi));

	}

//	void initializeAtmosphere(AppConfiguration configuration, Environment environment)
//	{
//		FilterRegistration.Dynamic filter = environment.servlets().addFilter("/chat", new CrossOriginFilter());
//		filter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
//
//		AtmosphereServlet atmosphereServlet = new AtmosphereServlet();
//		atmosphereServlet.framework().addInitParameter("com.sun.jersey.config.property.packages", "org.bw.controllers.atmosphere");
//		atmosphereServlet.framework().addInitParameter("org.atmosphere.websocket.messageContentType", "application/json");
//		//atmosphereServlet.framework().addInitParameter("org.atmosphere.cpr.broadcastFilterClasses", "com.example.helloworld.filters.BadWordFilter");
//
//		ServletHolder holder = new ServletHolder();
//		holder.setServlet(atmosphereServlet);
//
//		environment.getAdminContext().addServlet(holder, "/chat/*");
//
//	}
}
