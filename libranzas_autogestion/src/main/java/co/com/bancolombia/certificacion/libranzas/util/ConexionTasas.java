package co.com.bancolombia.certificacion.libranzas.util;

import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class ConexionTasas {

	public static Connection conTasas;

	private String user, password, nameHost;
	private static final Logger LOGGER = LoggerFactory.getLogger(ConexionTasas.class);

	public ConexionTasas() {
		try {

			Properties prop = new Properties();
			prop.load(new FileReader("bdconfig.properties"));
			this.user = prop.getProperty("tasas.user");
			this.password = prop.getProperty("tasas.password");
			this.nameHost = prop.getProperty("tasas.name_host");

			Class.forName(prop.getProperty("tasas.driver"));

			conTasas = DriverManager.getConnection(this.nameHost, this.user, this.password);
			LOGGER.info("Conexion exitosa a la base de datos Tasas");

		} catch (Exception e) {
			LOGGER.info("Error al conectar con tasas " + e);
		}

	}

	public static ConexionTasas conCredenciales() {
		return new ConexionTasas();

	}

	public ResultSet llamandoAlProcedimiento(String canal, String plan, String planTasaVariable, String segmento,
			String grupoRiesgo, int monto, int plazo) throws SQLException {
		CallableStatement stamento = conTasas.prepareCall("{call SCHADTAS.GET_CALCULATE_RATE(?,?,?,?,?,?,?,?,?,?)}");
		stamento.registerOutParameter(1, Types.VARCHAR);
		stamento.registerOutParameter(2, Types.VARCHAR);
		stamento.registerOutParameter(3, OracleTypes.CURSOR);
		stamento.setString(4, canal);
		stamento.setString(5, plan);
		stamento.setString(6, planTasaVariable);
		stamento.setString(7, segmento);
		stamento.setString(8, grupoRiesgo);
		stamento.setDouble(9, monto);
		stamento.setDouble(10, plazo);
		stamento.execute();
		return ((OracleCallableStatement) stamento).getCursor(3);
	}

}
