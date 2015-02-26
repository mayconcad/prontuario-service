package br.com.sts.ddum.service.interfaces;

import java.sql.Connection;

public interface ConnectionConfigService {

	public Connection obterConexaoBancoCGP();

	public Connection obterConexaoBancoFOLHA();

}
