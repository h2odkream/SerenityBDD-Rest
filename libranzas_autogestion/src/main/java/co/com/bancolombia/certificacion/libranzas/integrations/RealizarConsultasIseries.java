package co.com.bancolombia.certificacion.libranzas.integrations;

import co.com.bancolombia.certificacion.libranzas.models.*;
import co.com.bancolombia.certificacion.libranzas.util.ConexionIseries;
import co.com.bancolombia.certificacion.libranzas.util.ExtraerConsultaProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class RealizarConsultasIseries {

    private RealizarConsultasIseries() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(RealizarConsultasIseries.class.getName());
    static ExtraerConsultaProperties ep = new ExtraerConsultaProperties();

    private static ModelCname consultarCNAME(String cedula) {
        String strLLaveNombre = null, strNombreCorto = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaCNAME(cedula));

        try {
            while (ConexionIseries.getRSIseries().next()) {
                strLLaveNombre = ConexionIseries.getRSIseries().getString(1);
                strNombreCorto = ConexionIseries.getRSIseries().getString(2);
            }
        } catch (Exception e) {
            LOGGER.info("error mostrado en el cname: " + e);

        }

        return new ModelCname(strLLaveNombre, strNombreCorto);
    }

    public static ModelXcrl consultarXCRLInicio(String cedula) {
        String strXCRLLlaveNombreCNAME = null, strXCRLNumeroSecuencial = null, strXCRLTipoCupoCredito = null,
                strXCRLCodigoActividad = null, strXCRLMontoAprobado = null, strXCRLMontoRetirosHoy = null,
                strXCRLMontoTotalRetirosAntes = null, strXCRLFechaUltimoManteni = null,
                strXCRLDisponibleCupoCredAntes = null;

        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaXCRL1(consultarCNAME(cedula).getLlaveNombre()));


        try {
            while (ConexionIseries.getRSIseries().next()) {
                strXCRLLlaveNombreCNAME = ConexionIseries.getRSIseries().getString(1);
                strXCRLNumeroSecuencial = ConexionIseries.getRSIseries().getString(2);
                strXCRLTipoCupoCredito = ConexionIseries.getRSIseries().getString(3);
                strXCRLCodigoActividad = ConexionIseries.getRSIseries().getString(4);
                strXCRLMontoAprobado = ConexionIseries.getRSIseries().getString(5);
                strXCRLMontoRetirosHoy = ConexionIseries.getRSIseries().getString(6);
                strXCRLMontoTotalRetirosAntes = ConexionIseries.getRSIseries().getString(7);
                strXCRLFechaUltimoManteni = ConexionIseries.getRSIseries().getString(8);
                strXCRLDisponibleCupoCredAntes = ConexionIseries.getRSIseries().getString(9);
            }
        } catch (Exception e) {
            LOGGER.info("error mostrado en el xcrl inicio: " + e);

        }

        return new ModelXcrl(strXCRLLlaveNombreCNAME, strXCRLNumeroSecuencial, strXCRLTipoCupoCredito,
                strXCRLCodigoActividad, strXCRLMontoAprobado, strXCRLMontoRetirosHoy, strXCRLMontoTotalRetirosAntes,
                strXCRLFechaUltimoManteni, strXCRLDisponibleCupoCredAntes);

    }

    public static ModelXcrl consultaXCRLFinal(String cedula) {
        String strXCRLDisponibleCupoCredDespues = null, strXCRLMontoTotalRetirosDespues = null;

        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaXCRL2(consultarCNAME(cedula).getLlaveNombre()));

        try {
            while (ConexionIseries.getRSIseries().next()) {
                strXCRLDisponibleCupoCredDespues = ConexionIseries.getRSIseries().getString(1);
                strXCRLMontoTotalRetirosDespues = ConexionIseries.getRSIseries().getString(2);
            }

        } catch (SQLException e) {
            LOGGER.info(e.toString());
            LOGGER.info("error mostrado en el xcrl final: " + e.getMessage());
            Thread.currentThread();
            Thread.interrupted();
        }
        return new ModelXcrl(strXCRLDisponibleCupoCredDespues, strXCRLMontoTotalRetirosDespues);

    }

    public static ModelSciffsaldo consultaSaldoInicio(String numCuenta) {
        String strSCIFFSALDOSaldoAntes = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaSCIFFSALDO(numCuenta));
        try {
            while (ConexionIseries.getRSIseries().next()) {
                strSCIFFSALDOSaldoAntes = ConexionIseries.getRSIseries().getString(1);
            }
        } catch (SQLException e) {
            LOGGER.info("error en consultar saldo inicio: " + e);

        }
        return new ModelSciffsaldo(strSCIFFSALDOSaldoAntes, null);
    }

    public static ModelSciffsaldo consultaSaldoFinal(String numCuenta) {
        String strSCIFFSALDOSaldoDespues = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaSCIFFSALDO(numCuenta));
        try {
            while (ConexionIseries.getRSIseries().next()) {
                strSCIFFSALDOSaldoDespues = ConexionIseries.getRSIseries().getString(1);
            }
        } catch (SQLException e) {
            LOGGER.info("error consulta saldo final: " + e);

        }
        return new ModelSciffsaldo(strSCIFFSALDOSaldoDespues);
    }

    public static ModelPccfflgaen consultaClaveDinamica(String fecha, String cedula) {
        String strClaveDinamica, strClaveDinamicaFormateada = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaPCCFFLGAEN(cedula, fecha));
        try {

            while (ConexionIseries.getRSIseries().next()) {
                strClaveDinamica = ConexionIseries.getRSIseries().getString(1);
                strClaveDinamica.toString();

                if (strClaveDinamica.contains(".") || strClaveDinamica.contains(" ")) {
                    strClaveDinamicaFormateada = strClaveDinamica.replaceAll("\\.", "");

                } else {
                    strClaveDinamicaFormateada = strClaveDinamica.toString();
                }
                LOGGER.info("Clave din�mica:" + strClaveDinamica);
            }
        } catch (Exception e) {
            LOGGER.info("error consulta clave dinamica: " + e);
        }
        return new ModelPccfflgaen(strClaveDinamicaFormateada);
    }

    public static ModelLmbal consultaLMBALDespuesDelDesembolso(String numeroPrestamo) {
        String strLMBALOficinaOrigen = null, strLMBALNumeroDePrestamo = null, strLMBALTipoPlan = null,
                strLMBALCodigoDistDesembolso = null, strLMBALCodigoAnioBase = null, strLMBALCodigoFrecDePago = null,
                strLMBALEstadoDePrestamo = null, strLMBALPeriodoDelPlazo = null, strLMBALTasa = null,
                strLMBALTasaSeguroDeVida = null, strLMBALFechaDeNota = null, strLMBALFechaDeVencimiento = null,
                strLMBALCuentaAbonos = null, strLMBALPagoNormal = null, strLMBALMontoTotalContrato = null,
                strLMBALDescripcionUsuario1 = null, strLMBALNumSecLineaDeCre = null, strLMBALCodigoDelConvenio = null;

        String tasaLMBALConvertida = null, tasaSVLMBALConvertida = null, cuotaLMBALConvertida = null,
                montoLMBALConvertido = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaLMBAL(numeroPrestamo));
        try {
            while (ConexionIseries.getRSIseries().next()) {
                strLMBALOficinaOrigen = ConexionIseries.getRSIseries().getString(1);
                strLMBALNumeroDePrestamo = ConexionIseries.getRSIseries().getString(2);
                strLMBALTipoPlan = ConexionIseries.getRSIseries().getString(3);
                strLMBALCodigoDistDesembolso = ConexionIseries.getRSIseries().getString(4);
                strLMBALCodigoAnioBase = ConexionIseries.getRSIseries().getString(5);
                strLMBALCodigoFrecDePago = ConexionIseries.getRSIseries().getString(6);
                strLMBALEstadoDePrestamo = ConexionIseries.getRSIseries().getString(7);
                strLMBALPeriodoDelPlazo = ConexionIseries.getRSIseries().getString(8);

                strLMBALTasa = ConexionIseries.getRSIseries().getString(9);
                String tasaLMBALConvertida1 = strLMBALTasa.replaceAll("\\.", "");
                tasaLMBALConvertida = String
                        .valueOf(Integer.parseInt(tasaLMBALConvertida1.substring(0, (tasaLMBALConvertida1.length()))));

                strLMBALTasaSeguroDeVida = ConexionIseries.getRSIseries().getString(10);
                tasaSVLMBALConvertida = strLMBALTasaSeguroDeVida.replaceAll("\\.", "");

                strLMBALFechaDeNota = ConexionIseries.getRSIseries().getString(11);
                strLMBALFechaDeVencimiento = ConexionIseries.getRSIseries().getString(12);
                strLMBALCuentaAbonos = ConexionIseries.getRSIseries().getString(13);

                strLMBALPagoNormal = ConexionIseries.getRSIseries().getString(14);
                cuotaLMBALConvertida = strLMBALPagoNormal.replaceAll("\\.", "");

                strLMBALMontoTotalContrato = ConexionIseries.getRSIseries().getString(15);
                montoLMBALConvertido = strLMBALMontoTotalContrato.replaceAll("\\.", "");

                strLMBALDescripcionUsuario1 = ConexionIseries.getRSIseries().getString(16);
                strLMBALNumSecLineaDeCre = ConexionIseries.getRSIseries().getString(17);
                strLMBALCodigoDelConvenio = ConexionIseries.getRSIseries().getString(18);
            }

        } catch (Exception e) {

            LOGGER.info("error consulta lmbal despues: " + e);

        }
        return new ModelLmbal(strLMBALOficinaOrigen, strLMBALNumeroDePrestamo, strLMBALTipoPlan, strLMBALCodigoDistDesembolso,
                strLMBALCodigoAnioBase, strLMBALCodigoFrecDePago, strLMBALEstadoDePrestamo, strLMBALPeriodoDelPlazo,
                tasaLMBALConvertida, tasaSVLMBALConvertida, strLMBALFechaDeNota, strLMBALFechaDeVencimiento,
                strLMBALCuentaAbonos, cuotaLMBALConvertida, montoLMBALConvertido, strLMBALDescripcionUsuario1,
                strLMBALNumSecLineaDeCre, strLMBALCodigoDelConvenio);
    }

    public static ModelXlogsrv consultarXLOGSRVDespuesDelDesembolso(String cedula) {

        String strXLOGSRVTipoMensaje = null, strXLOGSRVCodigoDeRespuesta = null, strXLOGSRVDescripcionRespuesta = null,
                strXLOGSRVOficinaOrigen = null, strXLOGSRVPrestamo = null, strXLOGSRVPlan = null,
                strXLOGSRVNombreCorto = null, strXLOGSRVCodigoDesembolso = null, strXLOGSRVCodigoBaseAnual = null,
                strXLOGSRVCodigoFrecPago = null, strXLOGSRVEstadoPrestamo = null, strXLOGSRVPlazo = null,
                strXLOGSRVTasa = null, strXLOGSRVTasaSV = null, strXLOGSRVFechaApertura = null,
                strXLOGSRVFechaVencimiento = null, strXLOGSRVCuentaDesembolso = null, strXLOGSRVValorCuota = null,
                strXLOGSRVMontoTotalC = null, strXLOGSRVIdentDesembolso = null, strXLOGSRVIdCliente = null,
                strXLOGSRVMumRastro = null, strXLOGSRVIndicadorReverso = null, strXLOGSRVNumeroSecuencia = null,
                strXLOGSRVMensaje = null, strXLOGSRVConvenio = null;

        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaXLOGSRV(cedula));

        try {
            while (ConexionIseries.getRSIseries().next()) {

                strXLOGSRVTipoMensaje = ConexionIseries.getRSIseries().getString(1);
                strXLOGSRVCodigoDeRespuesta = ConexionIseries.getRSIseries().getString(2);
                strXLOGSRVDescripcionRespuesta = ConexionIseries.getRSIseries().getString(3);
                strXLOGSRVOficinaOrigen = ConexionIseries.getRSIseries().getString(4);
                strXLOGSRVPrestamo = ConexionIseries.getRSIseries().getString(5);
                strXLOGSRVPlan = ConexionIseries.getRSIseries().getString(6);
                strXLOGSRVNombreCorto = ConexionIseries.getRSIseries().getString(7);
                strXLOGSRVCodigoDesembolso = ConexionIseries.getRSIseries().getString(8);
                strXLOGSRVCodigoBaseAnual = ConexionIseries.getRSIseries().getString(9);
                strXLOGSRVCodigoFrecPago = ConexionIseries.getRSIseries().getString(10);
                strXLOGSRVEstadoPrestamo = ConexionIseries.getRSIseries().getString(11);
                strXLOGSRVPlazo = ConexionIseries.getRSIseries().getString(12);
                strXLOGSRVTasa = ConexionIseries.getRSIseries().getString(13);
                strXLOGSRVTasaSV = ConexionIseries.getRSIseries().getString(14);
                strXLOGSRVFechaApertura = ConexionIseries.getRSIseries().getString(15);
                strXLOGSRVFechaVencimiento = ConexionIseries.getRSIseries().getString(16);
                strXLOGSRVCuentaDesembolso = ConexionIseries.getRSIseries().getString(17);
                strXLOGSRVValorCuota = ConexionIseries.getRSIseries().getString(18);
                strXLOGSRVMontoTotalC = ConexionIseries.getRSIseries().getString(19);
                strXLOGSRVIdentDesembolso = ConexionIseries.getRSIseries().getString(20).trim();
                strXLOGSRVConvenio = ConexionIseries.getRSIseries().getString(21).trim();
                strXLOGSRVIdCliente = ConexionIseries.getRSIseries().getString(22).trim();
                strXLOGSRVMumRastro = ConexionIseries.getRSIseries().getString(23);
                strXLOGSRVIndicadorReverso = ConexionIseries.getRSIseries().getString(24);
                strXLOGSRVNumeroSecuencia = ConexionIseries.getRSIseries().getString(25);
                strXLOGSRVMensaje = ConexionIseries.getRSIseries().getString(26);
            }

        } catch (Exception e) {

            LOGGER.info("error consulta xlogsrv despues: " + e);

        }

        return new ModelXlogsrv(strXLOGSRVTipoMensaje, strXLOGSRVCodigoDeRespuesta, strXLOGSRVDescripcionRespuesta,
                strXLOGSRVOficinaOrigen, strXLOGSRVPrestamo, strXLOGSRVPlan, strXLOGSRVNombreCorto,
                strXLOGSRVCodigoDesembolso, strXLOGSRVCodigoBaseAnual, strXLOGSRVCodigoFrecPago,
                strXLOGSRVEstadoPrestamo, strXLOGSRVPlazo, strXLOGSRVTasa, strXLOGSRVTasaSV, strXLOGSRVFechaApertura,
                strXLOGSRVFechaVencimiento, strXLOGSRVCuentaDesembolso, strXLOGSRVValorCuota, strXLOGSRVMontoTotalC,
                strXLOGSRVIdentDesembolso, strXLOGSRVIdCliente, strXLOGSRVMumRastro, strXLOGSRVIndicadorReverso,
                strXLOGSRVNumeroSecuencia, strXLOGSRVMensaje, strXLOGSRVConvenio);
    }

    public static ModelLmbal consultarLMBALFechaDePago(String strLMBALDescripcionUsuario1) {
        String strLMBALFechaObligacion = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaLMBALFechaPago(strLMBALDescripcionUsuario1));
        try {
            while (ConexionIseries.getRSIseries().next()) {
                strLMBALFechaObligacion = ConexionIseries.getRSIseries().getString(1);
            }

        } catch (Exception e) {
            LOGGER.info("error lmbal fecha pago: " + e);

        }

        return new ModelLmbal(strLMBALFechaObligacion, null);
    }

    public static ModelXjmsc consultarXJMSCFechaDePago(String strCOMCodigoConvenio) {
        String strXJMSCFechaObligacion = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaXJMSC(strCOMCodigoConvenio));

        try {
            while (ConexionIseries.getRSIseries().next()) {
                strXJMSCFechaObligacion = ConexionIseries.getRSIseries().getString(1);

            }
        } catch (SQLException e) {
            LOGGER.info("error consulta xjmsc: " + e);

        }
        return new ModelXjmsc(strXJMSCFechaObligacion);
    }


    public static ModelNombreEmpresa consultarXJMSCNombreEmpresa(String strCOMCodigoConvenio) {
        String strXJMSCNombreEmpresa = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaNombreEmpresa(strCOMCodigoConvenio));

        try {
            while (ConexionIseries.getRSIseries().next()) {
                strXJMSCNombreEmpresa = ConexionIseries.getRSIseries().getString(1);

            }
        } catch (Exception e) {
            LOGGER.info("error consutla nombre empresa: " + e);

        }
        return new ModelNombreEmpresa(strXJMSCNombreEmpresa);
    }

    public static ModelToken extraerIdentificadorToken(String strFechaActual, String strCedula) {
        String strTokenIdenti = null;
        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaIdentificadorToken(strFechaActual, strCedula));
        try {
            while (ConexionIseries.getRSIseries().next()) {
                strTokenIdenti = ConexionIseries.getRSIseries().getString(1);
            }
        } catch (Exception e) {
            LOGGER.info("error identi token" + e.getMessage());
        }

        return new ModelToken(strTokenIdenti);
    }

    public static ModelToken extraerToken(String strFechaActual, String strCedula) {
        String strToken = null;

        ConexionIseries.conCredenciales();
        ConexionIseries.haceConsulta(ep.extraerConsultaToken(strFechaActual, extraerIdentificadorToken(strFechaActual, strCedula).getStrIdentiToken()));
        try {
            while (ConexionIseries.getRSIseries().next()) {
                strToken = ConexionIseries.getRSIseries().getString(1);

            }
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
        }

        return new ModelToken(strToken, null);
    }

}
