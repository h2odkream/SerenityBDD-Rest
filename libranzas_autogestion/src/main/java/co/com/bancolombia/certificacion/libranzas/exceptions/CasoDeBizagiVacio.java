package co.com.bancolombia.certificacion.libranzas.exceptions;

public class CasoDeBizagiVacio extends AssertionError {

	private static final long serialVersionUID = 4627521611646031489L;
	public static final String CASO_BIZAGI_VACIO = "El caso de bizagi esta vacío";

	public CasoDeBizagiVacio(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
