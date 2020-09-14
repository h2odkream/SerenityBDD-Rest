package co.com.bancolombia.certificacion.libranzas.exceptions;

public class CuotaErronea extends AssertionError {

	private static final long serialVersionUID = 4728734952891227736L;
	public static final String ERROR_CUOTA = "La cuota es esta diferente del front-calculo";

	public CuotaErronea(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
