package org.bw.auth;

import com.google.common.base.Optional;
import io.dropwizard.auth.AuthenticationException;
import org.bw.model.User;

/**
 * Created by bjoernweidlich on 6/1/14.
 */
public class TokenAuthenticator implements io.dropwizard.auth.Authenticator<String, org.bw.model.User>
{
	@Override
	public Optional<User> authenticate(String credentials) throws AuthenticationException
	{
		return null;
	}
}
