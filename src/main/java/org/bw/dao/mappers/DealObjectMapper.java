package org.bw.dao.mappers;

import org.bw.model.Deal;
import org.bw.model.Vendor;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bjoernweidlich on 6/1/14.
 */

public class DealObjectMapper implements ResultSetMapper<Deal>
{
	public Deal map(int index, ResultSet r, StatementContext ctx) throws SQLException
	{
		return new Deal(r.getInt("dealId"), r.getDate("startDate"), r.getDate("endDate"), r.getString("title"), new Vendor());
	}
}

