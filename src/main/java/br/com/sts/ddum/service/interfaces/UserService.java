package br.com.sts.ddum.service.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.sts.ddum.domain.entities.UserSystem;
import br.com.sts.ddum.domain.springsecurity.entities.User;

public interface UserService extends UserDetailsService {

	void save(User entity);

	void edite(User entity);

	void remove(User entity);

	Iterable<UserSystem> find(UserSystem entity, Sort sort, int firstResult,
			int maxResults);

	@Override
	UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException;

	void changePassword(String currentPassword, String newPassword);

	UserDetails loadCurrentUser();

	User loadByUsername(String username);

	List<User> buscar(Map<String, Object> params);
}
