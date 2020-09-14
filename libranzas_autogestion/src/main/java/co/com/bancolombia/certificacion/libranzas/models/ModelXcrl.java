package co.com.bancolombia.certificacion.libranzas.models;

public class ModelXcrl {
    private String strXCRLLlaveNombreCNAME;
    private String strXCRLNumeroSecuencial;
    private String strXCRLTipoCupoCredito;
    private String strXCRLCodigoActividad;
    private String strXCRLMontoAprobado;
    private String strXCRLMontoRetirosHoy;
    private String strXCRLMontoTotalRetirosAntes;
    private String strXCRLFechaUltimoManteni;
    private String strXCRLDisponibleCupoCredAntes;

    private String strXCRLDisponibleCupoCredDespues;
    private String strXCRLMontoTotalRetirosDespues;

    public ModelXcrl(String strXCRLLlaveNombreCNAME, String strXCRLNumeroSecuencial, String strXCRLTipoCupoCredito,
                     String strXCRLCodigoActividad, String strXCRLMontoAprobado, String strXCRLMontoRetirosHoy,
                     String strXCRLMontoTotalRetirosAntes, String strXCRLFechaUltimoManteni,
                     String strXCRLDisponibleCupoCredAntes) {

        this.strXCRLLlaveNombreCNAME = strXCRLLlaveNombreCNAME;
        this.strXCRLNumeroSecuencial = strXCRLNumeroSecuencial;
        this.strXCRLTipoCupoCredito = strXCRLTipoCupoCredito;
        this.strXCRLCodigoActividad = strXCRLCodigoActividad;
        this.strXCRLMontoAprobado = strXCRLMontoAprobado;
        this.strXCRLMontoRetirosHoy = strXCRLMontoRetirosHoy;
        this.strXCRLMontoTotalRetirosAntes = strXCRLMontoTotalRetirosAntes;
        this.strXCRLFechaUltimoManteni = strXCRLFechaUltimoManteni;
        this.strXCRLDisponibleCupoCredAntes = strXCRLDisponibleCupoCredAntes;
    }

    public ModelXcrl(String strXCRLDisponibleCupoCredDespues, String strXCRLMontoTotalRetirosDespues) {
        this.strXCRLDisponibleCupoCredDespues = strXCRLDisponibleCupoCredDespues;
        this.strXCRLMontoTotalRetirosDespues = strXCRLMontoTotalRetirosDespues;
    }

    public String getStrXCRLLlaveNombreCNAME() {
        return strXCRLLlaveNombreCNAME;
    }

    public void setStrXCRLLlaveNombreCNAME(String strXCRLLlaveNombreCNAME) {
        this.strXCRLLlaveNombreCNAME = strXCRLLlaveNombreCNAME;
    }

    public String getStrXCRLNumeroSecuencial() {
        return strXCRLNumeroSecuencial;
    }

    public void setStrXCRLNumeroSecuencial(String strXCRLNumeroSecuencial) {
        this.strXCRLNumeroSecuencial = strXCRLNumeroSecuencial;
    }

    public String getStrXCRLTipoCupoCredito() {
        return strXCRLTipoCupoCredito;
    }

    public void setStrXCRLTipoCupoCredito(String strXCRLTipoCupoCredito) {
        this.strXCRLTipoCupoCredito = strXCRLTipoCupoCredito;
    }

    public String getStrXCRLCodigoActividad() {
        return strXCRLCodigoActividad;
    }

    public void setStrXCRLCodigoActividad(String strXCRLCodigoActividad) {
        this.strXCRLCodigoActividad = strXCRLCodigoActividad;
    }

    public String getStrXCRLMontoAprobado() {
        return strXCRLMontoAprobado;
    }

    public void setStrXCRLMontoAprobado(String strXCRLMontoAprobado) {
        this.strXCRLMontoAprobado = strXCRLMontoAprobado;
    }

    public String getStrXCRLMontoRetirosHoy() {
        return strXCRLMontoRetirosHoy;
    }

    public void setStrXCRLMontoRetirosHoy(String strXCRLMontoRetirosHoy) {
        this.strXCRLMontoRetirosHoy = strXCRLMontoRetirosHoy;
    }

    public String getStrXCRLMontoTotalRetirosAntes() {
        return strXCRLMontoTotalRetirosAntes;
    }

    public void setStrXCRLMontoTotalRetirosAntes(String strXCRLMontoTotalRetirosAntes) {
        this.strXCRLMontoTotalRetirosAntes = strXCRLMontoTotalRetirosAntes;
    }

    public String getStrXCRLFechaUltimoManteni() {
        return strXCRLFechaUltimoManteni;
    }

    public void setStrXCRLFechaUltimoManteni(String strXCRLFechaUltimoManteni) {
        this.strXCRLFechaUltimoManteni = strXCRLFechaUltimoManteni;
    }

    public String getStrXCRLDisponibleCupoCredAntes() {
        return strXCRLDisponibleCupoCredAntes;
    }

    public void setStrXCRLDisponibleCupoCredAntes(String strXCRLDisponibleCupoCredAntes) {
        this.strXCRLDisponibleCupoCredAntes = strXCRLDisponibleCupoCredAntes;
    }

    public String getStrXCRLDisponibleCupoCredDespues() {
        return strXCRLDisponibleCupoCredDespues;
    }

    public void setStrXCRLDisponibleCupoCredDespues(String strXCRLDisponibleCupoCredDespues) {
        this.strXCRLDisponibleCupoCredDespues = strXCRLDisponibleCupoCredDespues;
    }

    public String getStrXCRLMontoTotalRetirosDespues() {
        return strXCRLMontoTotalRetirosDespues;
    }

    public void setStrXCRLMontoTotalRetirosDespues(String strXCRLMontoTotalRetirosDespues) {
        this.strXCRLMontoTotalRetirosDespues = strXCRLMontoTotalRetirosDespues;
    }


}
