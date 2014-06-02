package org.bw.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public class User
{
	@JsonProperty
	private List<Deal> deals;

	@NotNull
	@NotEmpty
	@JsonProperty
	private String username;

	@NotNull
	@NotEmpty
	@JsonProperty
	private String password;

	@JsonProperty
	private String firstName;

	@JsonProperty
	private String lastName;

	public User()
	{}


	public User(List<Deal> deals, String username, String password, String firstName, String lastName)
	{
		this.deals = deals;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public List<Deal> getDeals()
	{
		return deals;
	}

	public String getUsername()
	{
		return username;
	}

	public String getPassword()
	{
		return password;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getLastName()
	{
		return lastName;
	}
}
