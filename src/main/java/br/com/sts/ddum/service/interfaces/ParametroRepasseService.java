package br.com.sts.ddum.service.interfaces;

import java.util.List;
import java.util.Map;

import br.com.sts.ddum.domain.entities.ParametroRepasse;

public interface ParametroRepasseService extends
		GenericService<ParametroRepasse> {

	public List<ParametroRepasse> autocompletar(Map<String, Object> params);

}
