package co.com.bancolombia.certificacion.libranzas.models;

public class ModelPreaprobados {

    private String strPREAPCedula, strPREAPEstado, strPREAPCanal;

    public ModelPreaprobados(String strPREAPCedula, String strPREAPEstado, String strPREAPCanal) {

        this.strPREAPCedula = strPREAPCedula;
        this.strPREAPEstado = strPREAPEstado;
        this.strPREAPCanal = strPREAPCanal;
    }

    public String getStrPREAPCedula() {
        return strPREAPCedula;
    }

    public String getStrPREAPEstado() {
        return strPREAPEstado;
    }

    public String getStrPREAPCanal() {
        return strPREAPCanal;
    }


}
