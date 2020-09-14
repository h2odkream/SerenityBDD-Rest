package co.com.bancolombia.certificacion.libranzas.exceptions;

public class TasasErroneas extends AssertionError {

	private static final long serialVersionUID = 3564363876172245353L;
	public static final String CALCULO_TASAS_INCORRECTA = "Hubo un error en el calculo de la cuota";

	public TasasErroneas(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
