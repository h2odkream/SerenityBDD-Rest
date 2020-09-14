package co.com.bancolombia.certificacion.libranzas.models;

public class ModelSciffsaldo {

    private String strSCIFFSALDOSaldoAntes;
    private String strSCIFFSALDOSaldoDespues;

    public ModelSciffsaldo(String strSCIFFSALDOSaldoAntes, String esteNoSeUsa) {

        this.strSCIFFSALDOSaldoAntes = strSCIFFSALDOSaldoAntes;
    }

    public ModelSciffsaldo(String strSCIFFSALDOSaldoDespues) {

        this.strSCIFFSALDOSaldoDespues = strSCIFFSALDOSaldoDespues;
    }

    public String getStrSCIFFSALDOSaldoAntes() {
        return strSCIFFSALDOSaldoAntes;
    }

    public void setStrSCIFFSALDOSaldoAntes(String strSCIFFSALDOSaldoAntes) {
        this.strSCIFFSALDOSaldoAntes = strSCIFFSALDOSaldoAntes;
    }

    public String getStrSCIFFSALDOSaldoDespues() {
        return strSCIFFSALDOSaldoDespues;
    }

    public void setStrSCIFFSALDOSaldoDespues(String strSCIFFSALDOSaldoDespues) {
        this.strSCIFFSALDOSaldoDespues = strSCIFFSALDOSaldoDespues;
    }


}
