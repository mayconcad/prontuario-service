package br.com.sts.ddum.service.impls;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.domain.entities.UserSystem;
import br.com.sts.ddum.domain.repository.interfaces.UserRepository;
import br.com.sts.ddum.domain.springsecurity.entities.User;
import br.com.sts.ddum.service.interfaces.UserService;

@Service("userServiceImpl")
@Transactional
@Lazy
public class UserServiceImpl implements UserService, Serializable {

	private static final long serialVersionUID = -2481803605810539357L;

	@Inject
	private UserRepository userRepository;

	@Inject
	private PasswordEncoder passwordEncoder;

	@Override
	public void save(User entity) {
		entity.setPassword(encodePassword(entity.getPassword()));
		entity.setAtivo(true);
		entity.setCreatedAt(new Date());
		userRepository.save(entity);
	}

	@Override
	public void remove(User entity) {
		entity.setAtivo(false);
		userRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<UserSystem> find(UserSystem entity, Sort sort,
			int firstResult, int maxResults) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.loadUserByUsername(username);
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), user.isEnabled(),
				user.isAccountNonExpired(), user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), user.getAuthorities());
	}

	@Override
	public void changePassword(String currentPassword, String newPassword) {

	}

	@Override
	public UserDetails loadCurrentUser() {
		User user = userRepository.loadCurrentUser();
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(), user.getPassword(), user.isEnabled(),
				user.isAccountNonExpired(), user.isCredentialsNonExpired(),
				user.isAccountNonLocked(), user.getAuthorities());

	}

	@Override
	public User loadByUsername(String username) {
		return userRepository.loadUserByUsername(username);
	}

	private String encodePassword(String password) {
		return passwordEncoder.encodePassword(password, null);
	}

	@Override
	public void edite(User entity) {
		entity.setPassword(encodePassword(entity.getPassword()));
		userRepository.save(entity);
	}

	@Override
	public List<User> buscar(Map<String, Object> params) {
		return userRepository.buscar(params);
	}

}
