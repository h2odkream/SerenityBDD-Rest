package co.com.bancolombia.certificacion.libranzas.models;

public class ModelCname {

    private String llaveNombre;
    private String nombreCorto;

    public ModelCname(String llaveNombre, String nombreCorto) {
        this.llaveNombre = llaveNombre;
        this.nombreCorto = nombreCorto;
    }

    public String getLlaveNombre() {
        return llaveNombre;
    }

    public void setLlaveNombre(String llaveNombre) {
        this.llaveNombre = llaveNombre;
    }

    public String getNombreCorto() {
        return nombreCorto;
    }

    public void setNombreCorto(String nombreCorto) {
        this.nombreCorto = nombreCorto;
    }


}
