package br.com.sts.ddum.service.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class ConnectionConfig {

	protected static final Log log = LogFactory.getLog(ConnectionConfig.class);

	// extends DriverManagerDataSource {
	// public ConnectionConfig(String driver, String url, String user,
	// String password) {
	//
	// setDriverClassName(driver);
	// setUrl(url);
	// setPassword(password);
	// setUrl(user);
	//
	// }

	public static Connection obterConexaoBanco(String driver, String url,
			String usuario, String senha) {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, usuario, senha);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Erro durante a conexão com Banco de Dados "
					+ e.getMessage());
		}
		return con;
	}

}
