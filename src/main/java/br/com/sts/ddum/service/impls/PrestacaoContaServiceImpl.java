package br.com.sts.ddum.service.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.domain.entities.PrestacaoConta;
import br.com.sts.ddum.domain.repository.interfaces.PrestacaoContaRepository;
import br.com.sts.ddum.service.interfaces.PrestacaoContaService;

@Transactional
@Service("prestacaoContaService")
public class PrestacaoContaServiceImpl implements PrestacaoContaService {

	@Inject
	private PrestacaoContaRepository prestacaoContaRepository;

	public PrestacaoConta salvar(PrestacaoConta entidade) {
		entidade.setAtivo(true);
		return prestacaoContaRepository.save(entidade);
	}

	public PrestacaoConta atualizar(PrestacaoConta entidade) {
		return prestacaoContaRepository.save(entidade);
	}

	public List<PrestacaoConta> buscar(Map<String, Object> params) {

		return prestacaoContaRepository.buscar(params);
	}

	public void remover(PrestacaoConta entidade) {
		entidade.setAtivo(false);
		prestacaoContaRepository.save(entidade);
	}

	@Override
	public List<PrestacaoConta> autocompletar(String valor) {
		return prestacaoContaRepository.autocompletar(valor);
	}

	@Override
	public List<PrestacaoConta> autocompletar(Map<String, Object> params) {
		return prestacaoContaRepository.autocompletar(params);
	}

}
