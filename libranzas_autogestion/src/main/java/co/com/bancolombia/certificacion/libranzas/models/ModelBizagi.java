package co.com.bancolombia.certificacion.libranzas.models;

public class ModelBizagi {

    // bizagi inicial
    private String strNumeroCasoBizagi;
    // bizagi desembolso
    private String strBizagiMonto, strBizagiPLazo, strBizagiTasa, strBizagiTasaSeguroVida, strBizagiNumeroCuentaDSB,
            strBizagiOficinaOrigen, strBizagiNumeroPrestamo, strBizagiIndicadorReverso;

    public ModelBizagi(String strNumeroCasoBizagi, String esteNoSeUsa) {
        this.strNumeroCasoBizagi = strNumeroCasoBizagi;
    }

    public ModelBizagi(String strBizagiMonto, String strBizagiPLazo, String strBizagiTasa,
                       String strBizagiTasaSeguroVida, String strBizagiNumeroCuentaDSB, String strBizagiOficinaOrigen,
                       String strBizagiNumeroPrestamo, String strBizagiIndicadorReverso) {

        this.strBizagiMonto = strBizagiMonto;
        this.strBizagiPLazo = strBizagiPLazo;
        this.strBizagiTasa = strBizagiTasa;
        this.strBizagiTasaSeguroVida = strBizagiTasaSeguroVida;
        this.strBizagiNumeroCuentaDSB = strBizagiNumeroCuentaDSB;
        this.strBizagiOficinaOrigen = strBizagiOficinaOrigen;
        this.strBizagiNumeroPrestamo = strBizagiNumeroPrestamo;
        this.strBizagiIndicadorReverso = strBizagiIndicadorReverso;
    }

    public String getStrNumeroCasoBizagi() {
        return strNumeroCasoBizagi;
    }

    public void setStrNumeroCasoBizagi(String strNumeroCasoBizagi) {
        this.strNumeroCasoBizagi = strNumeroCasoBizagi;
    }

    public String getStrBizagiMonto() {
        return strBizagiMonto;
    }

    public void setStrBizagiMonto(String strBizagiMonto) {
        this.strBizagiMonto = strBizagiMonto;
    }

    public String getStrBizagiPLazo() {
        return strBizagiPLazo;
    }

    public void setStrBizagiPLazo(String strBizagiPLazo) {
        this.strBizagiPLazo = strBizagiPLazo;
    }

    public String getStrBizagiTasa() {
        return strBizagiTasa;
    }

    public void setStrBizagiTasa(String strBizagiTasa) {
        this.strBizagiTasa = strBizagiTasa;
    }

    public String getStrBizagiTasaSeguroVida() {
        return strBizagiTasaSeguroVida;
    }

    public void setStrBizagiTasaSeguroVida(String strBizagiTasaSeguroVida) {
        this.strBizagiTasaSeguroVida = strBizagiTasaSeguroVida;
    }

    public String getStrBizagiNumeroCuentaDSB() {
        return strBizagiNumeroCuentaDSB;
    }

    public void setStrBizagiNumeroCuentaDSB(String strBizagiNumeroCuentaDSB) {
        this.strBizagiNumeroCuentaDSB = strBizagiNumeroCuentaDSB;
    }

    public String getStrBizagiOficinaOrigen() {
        return strBizagiOficinaOrigen;
    }

    public void setStrBizagiOficinaOrigen(String strBizagiOficinaOrigen) {
        this.strBizagiOficinaOrigen = strBizagiOficinaOrigen;
    }

    public String getStrBizagiNumeroPrestamo() {
        return strBizagiNumeroPrestamo;
    }

    public void setStrBizagiNumeroPrestamo(String strBizagiNumeroPrestamo) {
        this.strBizagiNumeroPrestamo = strBizagiNumeroPrestamo;
    }

    public String getStrBizagiIndicadorReverso() {
        return strBizagiIndicadorReverso;
    }

    public void setStrBizagiIndicadorReverso(String strBizagiIndicadorReverso) {
        this.strBizagiIndicadorReverso = strBizagiIndicadorReverso;
    }


}
