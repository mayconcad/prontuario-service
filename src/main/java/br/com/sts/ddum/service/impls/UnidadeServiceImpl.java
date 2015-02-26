package br.com.sts.ddum.service.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.model.entities.Unidade;
import br.com.sts.ddum.model.repository.interfaces.UnidadeRepository;
import br.com.sts.ddum.service.interfaces.UnidadeService;

@Transactional
@Service("unidadeService")
public class UnidadeServiceImpl implements UnidadeService {

	@Inject
	private UnidadeRepository unidadeRepository;

	public Unidade salvar(Unidade entidade) {
		entidade.setAtivo(true);
		return unidadeRepository.save(entidade);
	}

	public Unidade atualizar(Unidade entidade) {
		return unidadeRepository.save(entidade);
	}

	public List<Unidade> buscar(Map<String, Object> params) {
		return unidadeRepository.buscar(params);
	}

	public void remover(Unidade entidade) {
		entidade.setAtivo(false);
		unidadeRepository.save(entidade);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Unidade> autocompletar(String valor) {
		return unidadeRepository.autocompletar(valor);
	}
}
