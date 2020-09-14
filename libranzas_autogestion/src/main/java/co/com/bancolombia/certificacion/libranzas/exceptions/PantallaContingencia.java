package co.com.bancolombia.certificacion.libranzas.exceptions;

public class PantallaContingencia extends AssertionError {

	private static final long serialVersionUID = 3515589466927619013L;
	public static final String CONTINGENCIA_CLAVE_DINAMICA_DIFERENTE = "La contingencia de clave dinámmica esta diferente a parámetro 'B'";

	public PantallaContingencia(String mensaje, Throwable error) {
		super(mensaje, error);
	}

}
