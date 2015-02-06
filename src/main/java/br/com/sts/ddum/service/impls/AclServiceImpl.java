package br.com.sts.ddum.service.impls;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.domain.entities.AuthoritySystem;
import br.com.sts.ddum.domain.repository.interfaces.AclRepository;
import br.com.sts.ddum.service.interfaces.AclService;

@Service
@Transactional
public class AclServiceImpl implements AclService, Serializable {

	private static final long serialVersionUID = -8697436334874823906L;

	@Inject
	private AclRepository aclRepository;

	@Override
	public void create(AuthoritySystem entity) {
		aclRepository.save(entity);
	}

	@Override
	public void createAll(List<AuthoritySystem> entities) {
		aclRepository.save(entities);
	}

	@Override
	@Transactional(readOnly = true)
	public GrantedAuthority load(Long id) {

		GrantedAuthority authority = aclRepository.findOne(id);

		return authority;
	}

	@Override
	@Transactional(readOnly = true)
	public List<AuthoritySystem> findAll() {
		return aclRepository.findAll();
	}

	@Override
	public void remove(AuthoritySystem entity) {
		aclRepository.delete(entity);
	}

}
