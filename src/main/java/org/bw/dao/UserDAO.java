package org.bw.dao;

import com.google.common.base.Optional;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.User;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public class UserDAO implements IUserDAO
{
	@Override
	public Optional<User> getUser(String username) throws DataAccessLayerException
	{
		return null;
	}

	@Override
	public void saveUser(User user) throws DataAccessLayerException
	{

	}

	@Override
	public void deleteUser(String username) throws DataAccessLayerException
	{

	}

	@Override
	public User updateUser(User newUserObj) throws DataAccessLayerException
	{
		return null;
	}
}
