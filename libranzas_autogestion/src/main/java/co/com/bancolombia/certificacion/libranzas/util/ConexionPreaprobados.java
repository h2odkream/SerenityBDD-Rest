package co.com.bancolombia.certificacion.libranzas.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConexionPreaprobados {

	private static Connection conPreaprobados;
	private static PreparedStatement sen;
	public static ResultSet rsPreaprobados;
	private String user;
	private String password;
	private String nameHost;

	private static final Logger LOGGER = LoggerFactory.getLogger(ConexionPreaprobados.class);

	public ConexionPreaprobados() {
		try {

			Properties prop = new Properties();
			prop.load(new FileReader("bdconfig.properties"));
			this.user = prop.getProperty("preaprobados.user");
			this.password = prop.getProperty("preaprobados.password");
			this.nameHost = prop.getProperty("preaprobados.name_host");

			Class.forName(prop.getProperty("preaprobados.driver"));

			conPreaprobados = DriverManager.getConnection(this.nameHost, this.user, this.password);
			LOGGER.info("Conexion exitosa a base de datos preaprobados");

		} catch (Exception e) {
			LOGGER.info("Error al conectar con preaprobados " + e);
		}

	}

	public static ConexionPreaprobados conCredenciales() {
		return new ConexionPreaprobados();
	}

	public static ResultSet haceConsulta(String strQuery) {

		try {
			LOGGER.info(" ");
			LOGGER.info(strQuery);
			sen = conPreaprobados.prepareStatement(strQuery);
			rsPreaprobados = sen.executeQuery();

			return rsPreaprobados;

		} catch (Exception e) {
			LOGGER.info("Error al conectar con preaprobados " + e);
		}

		return null;
	}

	public static void cerrarConexionPreaprobados() {
		try {
			conPreaprobados.close();
		} catch (Exception e) {
			LOGGER.info("error: " + e);
		}
	}

}
