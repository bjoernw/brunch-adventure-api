package org.bw.jdbi;

import com.codahale.metrics.annotation.Timed;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.util.IntegerMapper;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

/**
 * Created by bjoernweidlich on 5/18/14.
 */
@Path("/db")
@Produces(MediaType.APPLICATION_JSON)
public class DBResource
{
	@NotNull
	private final DBI dbi;

	public DBResource(DBI dbi)
	{
		this.dbi = dbi;

//        try (Handle h = dbi.open()) {
//            h.execute("create table something (id SERIAL, name varchar(100))");
//            String[] names = { "Gigantic", "Bone Machine", "Hey", "Cactus" };
//            Arrays.stream(names).forEach(name -> h.insert("insert into something (name) values (?)", name));
//        }
	}

	@Timed
	@POST
	@Path("/add")
	public Map<String, Object> add(String name)
	{
		try (Handle h = dbi.open()) {
			int id = h.createStatement("insert into something (name) values (:name)").bind("name", name)
					.executeAndReturnGeneratedKeys(IntegerMapper.FIRST).first();
			return find(id);
		}
	}

	@Timed
	@GET
	@Path("/item/{id}")
	public Map<String, Object> find(@PathParam("id") Integer id)
	{
		try (Handle h = dbi.open()) {
			return h.createQuery("select id, name from something where id = :id").bind("id", id).first();
		}
	}

	@Timed
	@GET
	@Path("/all")
	public List<Map<String, Object>> all(@PathParam("id") Integer id)
	{
		try (Handle h = dbi.open()) {
			return h.createQuery("select * from something").list();
		}
	}
}