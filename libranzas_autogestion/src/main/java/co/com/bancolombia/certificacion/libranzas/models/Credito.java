package co.com.bancolombia.certificacion.libranzas.models;

public class Credito {
    private String monto;
    private String plazo;
    private String cuenta;
    private String riesgo;
    private String segmento;
    private String cedula;
    private String convenio;
    private String cta;
    private String tipoDesembolso;

    public Credito(String monto, String plazo, String cuenta, String riesgo, String segmento, String cedula,
                   String cta, String tipoDesembolso) {
        this.monto = monto;
        this.plazo = plazo;
        this.cuenta = cuenta;
        this.riesgo = riesgo;
        this.segmento = segmento;
        this.cedula = cedula;
        this.cta = cta;
        this.tipoDesembolso = tipoDesembolso;
    }

    public String getCta() {
        return cta;
    }

    public String getConvenio() {
        return convenio;
    }

    public String getTipoDesembolso() {
        return tipoDesembolso;
    }

    public String getGrupoDeRiesgo() {
        return riesgo;
    }

    public String getSegmentoDeTasas() {
        return segmento;
    }

    public String getCedula() {
        return cedula;
    }

    public String getMonto() {
        return monto;
    }

    public String getPlazo() {
        return plazo;
    }

    public String getCuenta() {
        return cuenta;
    }


}
