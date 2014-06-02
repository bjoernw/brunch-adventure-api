package org.bw.dao;

import com.google.common.base.Optional;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.User;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public interface IUserDAO
{
	public Optional<User> getUser(String username) throws DataAccessLayerException;
	public void saveUser(User user) throws DataAccessLayerException;
	public void deleteUser(String username) throws DataAccessLayerException;
	public User updateUser(User newUserObj) throws DataAccessLayerException;
}
