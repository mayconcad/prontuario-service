package br.com.sts.ddum.service.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.model.entities.Repasse;
import br.com.sts.ddum.model.entities.UnidadeContabil;
import br.com.sts.ddum.model.repository.interfaces.RepasseRepository;
import br.com.sts.ddum.service.interfaces.RepasseService;

@Transactional
@Service("repasseService")
public class RepasseServiceImpl implements RepasseService {

	@Inject
	private RepasseRepository repasseRepository;

	public Repasse salvar(Repasse entidade) {
		entidade.setAtivo(true);
		return repasseRepository.save(entidade);
	}

	public Repasse atualizar(Repasse entidade) {
		return repasseRepository.save(entidade);
	}

	public List<Repasse> buscar(Map<String, Object> params) {

		return repasseRepository.buscar(params);
	}

	public void remover(Repasse entidade) {
		entidade.setAtivo(false);
		repasseRepository.save(entidade);
	}

	@Override
	public List<Repasse> autocompletar(String valor) {
		return repasseRepository.autocompletar(valor);
	}

	@Override
	public List<Repasse> autocompletar(Map<String, Object> params) {
		return repasseRepository.autocompletar(params);
	}

	@Override
	public long getProximoNumeroEmpenho(UnidadeContabil unidade) {
		return repasseRepository.obterProximoNumeroEmpenho(unidade);
	}
}
