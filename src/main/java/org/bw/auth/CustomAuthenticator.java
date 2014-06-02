package org.bw.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.basic.BasicCredentials;
import org.bw.model.User;
import org.bw.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Nullable;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public class CustomAuthenticator implements io.dropwizard.auth.Authenticator<io.dropwizard.auth.basic.BasicCredentials, org.bw.model.User>
{
	@Autowired
	IUserService userService;

	@Override
	public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException
	{
		@Nullable
		User user = new User();

		return Optional.fromNullable(user);
	}
}
