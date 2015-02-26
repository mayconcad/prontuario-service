package br.com.sts.ddum.service.interfaces;

import java.util.List;
import java.util.Map;

import br.com.sts.ddum.domain.entities.PrestacaoConta;

public interface PrestacaoContaService extends GenericService<PrestacaoConta> {

	public List<PrestacaoConta> autocompletar(Map<String, Object> params);

}
