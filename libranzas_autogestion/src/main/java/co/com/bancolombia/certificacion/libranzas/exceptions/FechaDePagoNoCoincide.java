package co.com.bancolombia.certificacion.libranzas.exceptions;

public class FechaDePagoNoCoincide extends AssertionError {
	private static final long serialVersionUID = -514174415244712557L;
	public static final String FECHA_PAGO_DISTINTAS = "Las fechas de pago traidas del log XJMSC y LMBAL no son iguales";

	public FechaDePagoNoCoincide(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
