package br.com.sts.ddum.service.impls;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.model.entities.ParametroRepasse;
import br.com.sts.ddum.model.repository.interfaces.ParametroRepasseRepository;
import br.com.sts.ddum.service.interfaces.ParametroRepasseService;

@Transactional
@Service("parametroRepasseService")
public class ParametroRepasseServiceImpl implements ParametroRepasseService {

	@Inject
	private ParametroRepasseRepository parametroRepasseRepository;

	public ParametroRepasse salvar(ParametroRepasse entidade) {
		entidade.setAtivo(true);
		return parametroRepasseRepository.save(entidade);
	}

	public ParametroRepasse atualizar(ParametroRepasse entidade) {
		return parametroRepasseRepository.save(entidade);
	}

	public List<ParametroRepasse> buscar(Map<String, Object> params) {

		return parametroRepasseRepository.buscar(params);
	}

	public void remover(ParametroRepasse entidade) {
		entidade.setAtivo(false);
		parametroRepasseRepository.save(entidade);
	}

	@Override
	public List<ParametroRepasse> autocompletar(String valor) {
		return parametroRepasseRepository.autocompletar(valor);
	}

	@Override
	public List<ParametroRepasse> autocompletar(Map<String, Object> params) {
		return parametroRepasseRepository.autocompletar(params);
	}

}
