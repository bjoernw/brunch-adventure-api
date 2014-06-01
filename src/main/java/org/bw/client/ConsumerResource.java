package org.bw.client;

/**
 * Created by bjoernweidlich on 5/18/14.
 */

import com.codahale.metrics.annotation.Timed;
import com.sun.jersey.api.client.Client;
import org.bw.model.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

@Path("/consumer")
@Produces(MediaType.TEXT_PLAIN)
public class ConsumerResource
{
	private final Client client;

	public ConsumerResource(Client client)
	{
		this.client = client;
	}

	@Timed
	@GET
	public String consume()
	{
		Saying saying = client.resource(UriBuilder.fromUri("http://localhost:8080/hello-world").queryParam("name", "consumer").build())
				.get(Saying.class);
		return String.format("The service is saying: %s (id: %d)", saying.getContent(), saying.getId());
	}
}
