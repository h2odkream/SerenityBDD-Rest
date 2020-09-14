package co.com.bancolombia.certificacion.libranzas.integrations;

import co.com.bancolombia.certificacion.libranzas.models.ModelPreaprobados;
import co.com.bancolombia.certificacion.libranzas.util.ConexionPreaprobados;
import co.com.bancolombia.certificacion.libranzas.util.ExtraerConsultaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static co.com.bancolombia.certificacion.libranzas.util.ConexionPreaprobados.cerrarConexionPreaprobados;
import static co.com.bancolombia.certificacion.libranzas.util.ConexionPreaprobados.rsPreaprobados;

public class RealizarConsultaPreaprobados {

    private RealizarConsultaPreaprobados() {

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RealizarConsultaPreaprobados.class.getName());
    static ExtraerConsultaProperties ep = new ExtraerConsultaProperties();

    public static ModelPreaprobados consultaPreaprobadoDespuesDelDesembolso(String cedula) {
        String strPREAPCedula = null, strPREAPEstado = null, strPREAPCanal = null;
        ConexionPreaprobados.conCredenciales();
        ConexionPreaprobados.haceConsulta(ep.extraerConsultaPreaprobados(cedula));
        try {

            while (rsPreaprobados.next()) {
                strPREAPCedula = rsPreaprobados.getString(1);
                strPREAPEstado = rsPreaprobados.getString(2);
                strPREAPCanal = rsPreaprobados.getString(3);
            }

        } catch (Exception e) {
            LOGGER.info(e.toString());

        }
        cerrarConexionPreaprobados();
        return new ModelPreaprobados(strPREAPCedula, strPREAPEstado, strPREAPCanal);
    }
}
