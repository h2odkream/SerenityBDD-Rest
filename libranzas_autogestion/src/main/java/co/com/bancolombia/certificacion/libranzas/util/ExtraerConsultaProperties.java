package co.com.bancolombia.certificacion.libranzas.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.util.Properties;

public class ExtraerConsultaProperties {

    private String strCNAME, strXCRL1, strXCRL2, strSCIFFSALDO, strCOMFFLGBVL, strLMBAL, strLMBALFechaPago, strXLOGSRV,
            strXJMSC, strBIZAGICreacionCaso, strBIZAGIDesembolso, strPREAPROBADOS, strPCCFFLGAEN, strNombreEmpresa, strTokenIdenti, strToken;

    private static final Logger LOGGER = LoggerFactory.getLogger(ExtraerConsultaProperties.class);

    public ExtraerConsultaProperties() {

        try {
            Properties prop = new Properties();
            prop.load(new FileReader("consultas.properties"));
            this.strCNAME = prop.getProperty("iseries.cname");
            this.strXCRL1 = prop.getProperty("iseries.xcrlInicio");
            this.strXCRL2 = prop.getProperty("iseries.xcrlFinal");
            this.strSCIFFSALDO = prop.getProperty("iseries.saldo");
            this.strCOMFFLGBVL = prop.getProperty("iseries.comfflgbvl");
            this.strLMBAL = prop.getProperty("iseries.lmbal");
            this.strXLOGSRV = prop.getProperty("iseries.xlogsrv");
            this.strXJMSC = prop.getProperty("iseries.xjmsc");
            this.strLMBALFechaPago = prop.getProperty("iseries.lmbalFechaPago");
            this.strPCCFFLGAEN = prop.getProperty("iseries.pccfflgaen");
            this.strBIZAGICreacionCaso = prop.getProperty("bizagi.creacionCaso");
            this.strBIZAGIDesembolso = prop.getProperty("bizagi.desembolso");
            this.strPREAPROBADOS = prop.getProperty("preaprobados.final");
            this.strNombreEmpresa = prop.getProperty("iseries.nombreEmpresa");
            this.strTokenIdenti = prop.getProperty("iseries.identiToken");
            this.strToken = prop.getProperty("iseries.token");
        } catch (Exception e) {

            LOGGER.info(e.getMessage());
        }
    }

    public String extraerConsultaCNAME(String cedula) {

        return String.format(strCNAME, "%" + cedula + "%");
    }

    public String extraerConsultaXCRL1(String llaveNombreCNAME) {
        return String.format(strXCRL1, llaveNombreCNAME);
    }

    public String extraerConsultaXCRL2(String llaveNombreCNAME) {
        return String.format(strXCRL2, llaveNombreCNAME);
    }

    public String extraerConsultaSCIFFSALDO(String numCuenta) {
        return String.format(strSCIFFSALDO, numCuenta);
    }

    public String extraerConsultaLMBAL(String numeroPrestamo) {
        return String.format(strLMBAL, numeroPrestamo);
    }

    public String extraerConsultaXLOGSRV(String cedula) {
        return String.format(strXLOGSRV, "%" + cedula + "%");
    }

    public String extraerConsultaXJMSC(String COMCodigoConvenio) {
        return String.format(strXJMSC, COMCodigoConvenio);
    }

    public String extraerConsultaLMBALFechaPago(String strLMBALDescripcionUsuario1) {
        return String.format(strLMBALFechaPago, strLMBALDescripcionUsuario1);
    }

    public String extraerConsultaPCCFFLGAEN(String cedula, String fecha) {
        return String.format(strPCCFFLGAEN, fecha, cedula);
    }

    public String extraerConsultaBizagiInicio(String cedula) {
        return String.format(strBIZAGICreacionCaso, cedula);
    }

    public String extraerConsultaBizagiDesembolso(String cedula) {
        return String.format(strBIZAGIDesembolso, cedula);
    }

    public String extraerConsultaPreaprobados(String cedula) {
        return String.format(strPREAPROBADOS, cedula);
    }

    public String extraerConsultaNombreEmpresa(String strCOMCodigoConvenio) {
        return String.format(strNombreEmpresa, strCOMCodigoConvenio);
    }

    public String extraerConsultaIdentificadorToken(String strFechaActual, String cedula) {
        return String.format(strTokenIdenti, strFechaActual, cedula);
    }

    public String extraerConsultaToken(String strFechaActual, String identiToken) {
        return String.format(strToken, strFechaActual, identiToken);
    }
}
