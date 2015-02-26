package br.com.sts.ddum.service.impls;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.model.repository.interfaces.RoleRepository;
import br.com.sts.ddum.model.springsecurity.entities.Role;
import br.com.sts.ddum.service.interfaces.RoleService;

@Service("roleServiceImpl")
@Transactional
@Lazy
public class RoleServiceImpl implements RoleService, Serializable {

	private static final long serialVersionUID = -2481803605810539357L;

	@Inject
	private RoleRepository roleRepository;

	@Override
	public void save(Role entity) {
		entity.setAtivo(true);
		roleRepository.save(entity);
	}

	@Override
	public void remove(Role entity) {
		entity.setAtivo(false);
		roleRepository.save(entity);
	}

	@Override
	public void edite(Role entity) {
		roleRepository.save(entity);
	}

	@Override
	public List<Role> buscar(Map<String, Object> params) {
		return roleRepository.buscar(params);
	}

	@Override
	public List<Role> autocompletar(String valor) {

		return roleRepository.autocompletar(valor);
	}

}
