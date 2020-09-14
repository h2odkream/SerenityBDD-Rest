package co.com.bancolombia.certificacion.libranzas.util;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConexionBizagi {


    private static Connection conBizagi;
    private static PreparedStatement sen;
    public static ResultSet rsBizagi;
    private String user;
    private String password;
    private String nameHost;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConexionBizagi.class);

    public ConexionBizagi() {
        try {

            Properties prop = new Properties();
            prop.load(new FileReader("bdconfig.properties"));
            this.user = prop.getProperty("bizagi.user");
            this.password = prop.getProperty("bizagi.password");
            this.nameHost = prop.getProperty("bizagi.name_host");
            prop.getProperty("bizagi.puerto");
            prop.getProperty("bizagi.sid");
            Class.forName(prop.getProperty("bizagi.driver"));

            conBizagi = DriverManager.getConnection(this.nameHost, this.user, this.password);
            LOGGER.info("Conexion exitosa a base de datos Bizagi");
        } catch (Exception e) {
            LOGGER.info("Error" + e);
        }

    }

    public static ConexionBizagi conCredenciales() {
        return new ConexionBizagi();
    }

    public static ResultSet haceConsulta(String strQuery) {
        try {

            sen = conBizagi.prepareStatement(strQuery);
            rsBizagi = sen.executeQuery();


            return rsBizagi;

        } catch (Exception e) {

            LOGGER.info(e.getMessage());
        }

        return null;
    }

    public static ResultSet getRSBizagi() {
        return rsBizagi;
    }

    public static void cerrarConexionBizagi() {
        try {
            conBizagi.close();
        } catch (Exception e) {
            LOGGER.info("error: " + e);
        }
    }

}
