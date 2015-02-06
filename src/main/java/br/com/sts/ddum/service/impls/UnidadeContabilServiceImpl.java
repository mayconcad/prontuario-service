package br.com.sts.ddum.service.impls;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.domain.entities.UnidadeContabil;
import br.com.sts.ddum.domain.repository.interfaces.UnidadeContabilRepository;
import br.com.sts.ddum.service.interfaces.UnidadeContabilService;

@Transactional
@Service("unidadeContabilService")
public class UnidadeContabilServiceImpl implements UnidadeContabilService {

	@Autowired
	private UnidadeContabilRepository unidadeContabilRepository;

	public UnidadeContabil salvar(UnidadeContabil entidade) {
		entidade.setAtivo(true);
		return unidadeContabilRepository.save(entidade);
	}

	public UnidadeContabil atualizar(UnidadeContabil entidade) {
		return unidadeContabilRepository.save(entidade);
	}

	@SuppressWarnings("unchecked")
	public List<UnidadeContabil> buscar(Map<String, Object> params) {
		if (params.containsKey("nome"))
			return unidadeContabilRepository.buscarPorNome(params.get("nome")
					.toString());
		else
			return Collections.EMPTY_LIST;
	}

	public void remover(UnidadeContabil entidade) {
		entidade.setAtivo(false);
		unidadeContabilRepository.save(entidade);
	}

	@Override
	public List<UnidadeContabil> autocompletar(String valor) {
		return unidadeContabilRepository.autocompletar(valor);
	}
}
