package br.com.sts.ddum.service.interfaces;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public interface IRepasse {

	public BigDecimal getValorRepasse();

}
