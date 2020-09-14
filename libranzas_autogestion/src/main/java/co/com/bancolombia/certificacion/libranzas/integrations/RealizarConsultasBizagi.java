package co.com.bancolombia.certificacion.libranzas.integrations;

import static co.com.bancolombia.certificacion.libranzas.util.ConexionBizagi.cerrarConexionBizagi;
import static co.com.bancolombia.certificacion.libranzas.util.ConexionBizagi.rsBizagi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.bancolombia.certificacion.libranzas.models.ModelBizagi;
import co.com.bancolombia.certificacion.libranzas.util.ConexionBizagi;
import co.com.bancolombia.certificacion.libranzas.util.ExtraerConsultaProperties;

public class RealizarConsultasBizagi {
    private RealizarConsultasBizagi() {

    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RealizarConsultasBizagi.class.getName());
    static ExtraerConsultaProperties ep = new ExtraerConsultaProperties();

    public static ModelBizagi consultarNumeroCasoInicio(String cedula) {
        ExtraerConsultaProperties epi = new ExtraerConsultaProperties();
        String strBIZAGICaso = null;
        String strQueryBizagi = epi.extraerConsultaBizagiInicio(cedula);
        ConexionBizagi.conCredenciales();
        ConexionBizagi.haceConsulta(strQueryBizagi);
        try {
            while (ConexionBizagi.getRSBizagi().next()) {
                strBIZAGICaso = ConexionBizagi.getRSBizagi().getString(1);

            }
        } catch (Exception e) {
            LOGGER.info(e.toString());
            Thread.currentThread();
            Thread.interrupted();
        }

        cerrarConexionBizagi();

        return new ModelBizagi(strBIZAGICaso, null);
    }

    public static ModelBizagi consultarBIZAGIDespuesDelDesembolso(String cedula) {
        String strBizagiMonto = null, strBizagiPlazo = null, strBizagiTasa = null, strBizagiTasaSeguroVida = null,
                strBizagiNumeroCuentaDSB = null, strBizagiOficinaOrigen = null, strBizagiNumeroPrestamo = null,
                strBizagiIndicadorReverso = null;
        ConexionBizagi.conCredenciales();
        ConexionBizagi.haceConsulta(ep.extraerConsultaBizagiDesembolso(cedula));

        try {
            while (ConexionBizagi.getRSBizagi().next()) {
                strBizagiMonto = rsBizagi.getString(3);
                strBizagiPlazo = rsBizagi.getString(4);
                strBizagiTasa = rsBizagi.getString(5);
                strBizagiTasaSeguroVida = rsBizagi.getString(6);
                strBizagiNumeroCuentaDSB = rsBizagi.getString(7);
                strBizagiOficinaOrigen = rsBizagi.getString(8);
                strBizagiNumeroPrestamo = rsBizagi.getString(9);
                strBizagiIndicadorReverso = rsBizagi.getString(14);
            }
        } catch (Exception e) {
            LOGGER.info(e.toString());
            Thread.currentThread();
            Thread.interrupted();
        }

        cerrarConexionBizagi();
        return new ModelBizagi(strBizagiMonto, strBizagiPlazo, strBizagiTasa, strBizagiTasaSeguroVida,
                strBizagiNumeroCuentaDSB, strBizagiOficinaOrigen, strBizagiNumeroPrestamo, strBizagiIndicadorReverso);
    }

}
