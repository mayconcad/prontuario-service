package br.com.sts.ddum.service.impls;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.domain.entities.Responsavel;
import br.com.sts.ddum.domain.repository.interfaces.ResponsavelRepository;
import br.com.sts.ddum.service.interfaces.ResponsavelService;

@Transactional
@Service("responsavelService")
public class ResponsavelServiceImpl implements ResponsavelService {

	@Autowired
	public ResponsavelRepository responsavelRepository;

	public Responsavel salvar(Responsavel entidade) {
		entidade.setAtivo(true);
		return responsavelRepository.save(entidade);
	}

	public Responsavel atualizar(Responsavel entidade) {
		return responsavelRepository.save(entidade);
	}

	public List<Responsavel> buscar(Map<String, Object> params) {
		return responsavelRepository.buscar(params);
	}

	public void remover(Responsavel entidade) {
		entidade.setAtivo(false);
		responsavelRepository.save(entidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Responsavel> autocompletar(String valor) {
		return responsavelRepository.autocompletar(valor);
	}

	public ResponsavelRepository getResponsavelRepository() {
		return responsavelRepository;
	}

	public void setResponsavelRepository(
			ResponsavelRepository responsavelRepository) {
		this.responsavelRepository = responsavelRepository;
	}
}
