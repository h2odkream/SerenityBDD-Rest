package co.com.bancolombia.certificacion.libranzas.exceptions;

public class DatosIncorrectosBDPreaprobados extends AssertionError {

	private static final long serialVersionUID = 7636708118096992752L;
	public static final String CANAL_O_ESTADO_INCORRECTO = "El canal es diferente a Digital y/o el estado es diferente de V";

	public DatosIncorrectosBDPreaprobados(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
