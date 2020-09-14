package co.com.bancolombia.certificacion.libranzas.exceptions;

public class Mensaje extends AssertionError {

	private static final long serialVersionUID = 8482098822576015648L;

	public Mensaje(String message, Throwable cause) {
		super(message, cause);
	}

	public static Mensaje noEncontrado(String message, Throwable cause) {
		return new Mensaje(message, cause);
	}

}