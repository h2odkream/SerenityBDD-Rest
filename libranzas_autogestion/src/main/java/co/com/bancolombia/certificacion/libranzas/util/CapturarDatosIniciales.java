package co.com.bancolombia.certificacion.libranzas.util;

import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasIseries;
import co.com.bancolombia.certificacion.libranzas.models.ModelSciffsaldo;
import co.com.bancolombia.certificacion.libranzas.models.ModelXcrl;

public class CapturarDatosIniciales {

    private CapturarDatosIniciales() {
    }

    public static ModelXcrl capturarLimitesInicial(String cedula) {

        return RealizarConsultasIseries.consultarXCRLInicio(cedula);
    }

    public static ModelSciffsaldo capturarSaldoInicial(String numeroCuenta) {

        return RealizarConsultasIseries.consultaSaldoInicio(numeroCuenta);
    }

}
