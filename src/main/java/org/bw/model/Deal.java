package org.bw.model;


import java.util.Date;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public class Deal
{
	int dealId;
	String title;
	Date startDate;
	Date endDate;
	Vendor vendor;

	public Deal()
	{

	}

	public Deal(int dealId, Date startDate, Date endDate, String title, Vendor vendor)
	{
		this.endDate = endDate;
		this.startDate = startDate;
		this.title = title;
		this.dealId = dealId;
		this.vendor = vendor;
	}
}
