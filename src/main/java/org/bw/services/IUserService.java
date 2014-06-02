package org.bw.services;

import com.google.common.base.Optional;
import org.bw.exceptions.DataAccessLayerException;
import org.bw.model.User;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public interface IUserService
{
	public Optional<User> getUser(String username) throws DataAccessLayerException;
	public void saveUser(User user) throws DataAccessLayerException;
	public void deleteUser(String username) throws DataAccessLayerException;
	public User updateUser(User newUserObj) throws DataAccessLayerException;
}
