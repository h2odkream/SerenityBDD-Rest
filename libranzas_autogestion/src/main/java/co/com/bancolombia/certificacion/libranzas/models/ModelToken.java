package co.com.bancolombia.certificacion.libranzas.models;

public class ModelToken {

    private String strIdentiToken, strToken;

    public ModelToken(String strIdentiToken) {
        this.strIdentiToken = strIdentiToken;
    }

    public ModelToken(String strToken, String noSeUsa) {
        this.strToken = strToken;
    }

    public String getStrIdentiToken() {
        return strIdentiToken;
    }

    public String getStrToken() {
        return strToken;
    }


}
