package br.com.sts.ddum.service.impls;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import br.com.sts.ddum.model.springsecurity.entities.Role;
import br.com.sts.ddum.model.springsecurity.entities.User;

@Component("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@PersistenceContext
	private EntityManager entityManager;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return findByUsername(username);
	}

	private User findByUsername(String username) {
		try {
			Query createNativeQuery = entityManager
					.createNativeQuery("SELECT u.id, u.username, u.password, r.id as idRole, r.name FROM public.user u, role r, user_role ur WHERE u.username = :username AND ur.user_id = u.id  AND ur.roles_id = r.id");
			createNativeQuery.setParameter("username", username);
			Object[] obj = (Object[]) createNativeQuery.getResultList().get(0);
			User user = new User();
			List<Role> roles = new ArrayList<Role>();
			Role role = new Role();
			BigInteger idUser = ((BigInteger) obj[0]);
			user.setId(idUser.longValue());
			user.setUsername((String) obj[1]);
			user.setPassword((String) obj[2]);
			BigInteger idRole = ((BigInteger) obj[3]);
			role.setId(idRole.longValue());
			role.setName((String) obj[4]);
			roles.add(role);
			user.setRoles(roles);
			return user;

		} catch (NoResultException e) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
	}
}