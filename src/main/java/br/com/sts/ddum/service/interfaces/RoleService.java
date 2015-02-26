package br.com.sts.ddum.service.interfaces;

import java.util.List;
import java.util.Map;

import br.com.sts.ddum.domain.springsecurity.entities.Role;

public interface RoleService {

	void save(Role entity);

	void edite(Role entity);

	void remove(Role entity);

	List<Role> autocompletar(String valor);

	List<Role> buscar(Map<String, Object> params);
}
