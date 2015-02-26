package br.com.sts.ddum.service.impls;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.annotation.PreDestroy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sts.ddum.service.interfaces.ConnectionConfigService;

@Transactional
@Service(value = "connectionConfigService")
public class ConnectionConfigServiceImpl implements ConnectionConfigService {

	protected static final Log log = LogFactory
			.getLog(ConnectionConfigServiceImpl.class);
	protected static final String POSTGRESQL_DRIVER = "org.postgresql.Driver";
	protected static final String URL_BANCO_CGP = "jdbc:postgresql://192.10.0.10:5432/CGPPHB15";
	// "jdbc:postgresql://67.23.240.183:5433/CGPPHB15"
	// protected static final String URL_BANCO_CGP =
	// "jdbc:postgresql://localhost:5432/CGPPHB15";
	protected static final String SENHA_POSTGRES = "postgres";
	protected static final String USUARIO_POSTGRES = "postgres";

	protected static final String FIREBIRD_DRIVER = "org.firebirdsql.jdbc.FBDriver";
	protected static final String URL_BANCO_FOLHA = String
			.format("jdbc:firebirdsql:192.10.0.10/3050:%shome%sfirebird%sefetivos%sgcs.fdb",
					// .format("jdbc:firebirdsql:192.168.1.2/3050:%shome%sfirebird%sgcs-efetivos-phb.fdb",
					File.separator, File.separator, File.separator,
					File.separator);
	protected static final String SENHA_FIREBIRD = "masterkey";
	protected static final String USUARIO_FIREBIRD = "SYSDBA";

	private Connection connectionCGP;

	private Connection connectionFOLHA;

	@Override
	public Connection obterConexaoBancoCGP() {

		try {
			if (getConnectionCGP() == null || getConnectionCGP().isClosed()) {
				Class.forName(POSTGRESQL_DRIVER);
				setConnectionCGP(DriverManager.getConnection(URL_BANCO_CGP,
						USUARIO_POSTGRES, SENHA_POSTGRES));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Erro durante a conexão com Banco de Dados "
					+ e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error("Erro durante a conexão com Banco de Dados "
					+ e.getMessage());
		}
		return getConnectionCGP();
	}

	@Override
	public Connection obterConexaoBancoFOLHA() {

		try {
			if (getConnectionFOLHA() == null || getConnectionFOLHA().isClosed()) {
				Class.forName(FIREBIRD_DRIVER);
				setConnectionFOLHA(DriverManager.getConnection(URL_BANCO_FOLHA,
						USUARIO_FIREBIRD, SENHA_FIREBIRD));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error("Erro durante a conexão com Banco de Dados "
					+ e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			log.error("Erro durante a conexão com Banco de Dados "
					+ e.getMessage());
		}
		return getConnectionFOLHA();
	}

	@PreDestroy
	public void encerrarTransacoes() {
		try {
			if (getConnectionCGP() != null && !getConnectionCGP().isClosed()) {
				getConnectionCGP().close();
				setConnectionCGP(null);
			}
			if (getConnectionFOLHA() != null
					&& !getConnectionFOLHA().isClosed()) {
				getConnectionFOLHA().close();
				setConnectionFOLHA(null);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnectionCGP() {
		return connectionCGP;
	}

	public void setConnectionCGP(Connection connectionCGP) {
		this.connectionCGP = connectionCGP;
	}

	public Connection getConnectionFOLHA() {
		return connectionFOLHA;
	}

	public void setConnectionFOLHA(Connection connectionFOLHA) {
		this.connectionFOLHA = connectionFOLHA;
	}
}
