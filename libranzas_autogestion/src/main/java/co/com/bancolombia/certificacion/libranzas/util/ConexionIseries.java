package co.com.bancolombia.certificacion.libranzas.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.bancolombia.conexion.basedatos.ConnectionManager;

public class ConexionIseries {

    private static Connection conIseries = ConnectionManager.getIseriesConnection();
    private static PreparedStatement sen;
    private static ResultSet rsIseries;

    private ConexionIseries() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ConexionIseries.class);

    public static ConexionIseries conCredenciales() {
        return new ConexionIseries();
    }

    public static ResultSet haceConsulta(String strQuery) {
        try {
            LOGGER.info("query iseries: " + strQuery);
            sen = conIseries.prepareStatement(strQuery);
            rsIseries = sen.executeQuery();

            return rsIseries;

        } catch (Exception e) {
            LOGGER.info("Error" + e);
        }

        return null;
    }

    public static void muestraDatos() throws SQLException {
        while (rsIseries.next()) {
            LOGGER.info(rsIseries.getString(1));
        }
    }

    public static ResultSet getRSIseries() {
        return rsIseries;
    }

}
