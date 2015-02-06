package br.com.sts.ddum.service.interfaces;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.sts.ddum.domain.entities.UserSystem;

public interface UserService extends UserDetailsService {

	void save(UserSystem entity);

	void remove(UserSystem entity);

	Iterable<UserSystem> find(UserSystem entity, Sort sort, int firstResult,
			int maxResults);

	@Override
	UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException;

	void changePassword(String currentPassword, String newPassword);

	UserDetails loadCurrentUser();

	UserSystem loadByUsername(String username);

}
