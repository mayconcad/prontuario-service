package br.com.sts.ddum.service.interfaces;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import br.com.sts.ddum.model.entities.AuthoritySystem;

public interface AclService {

	public void create(AuthoritySystem entity);

	public void createAll(List<AuthoritySystem> entities);

	public GrantedAuthority load(Long id);

	public List<AuthoritySystem> findAll();

	public void remove(AuthoritySystem entity);

}
