package br.com.sts.ddum.service.interfaces;

import java.util.List;
import java.util.Map;

import br.com.sts.ddum.model.entities.Repasse;
import br.com.sts.ddum.model.entities.UnidadeContabil;

public interface RepasseService extends GenericService<Repasse> {

	public List<Repasse> autocompletar(Map<String, Object> params);

	public long getProximoNumeroEmpenho(UnidadeContabil unidade);

}
