package co.com.bancolombia.certificacion.libranzas.exceptions;

public class DatosInicialesDelLimite extends AssertionError {

	private static final long serialVersionUID = 4672837566913122119L;
	public static final String CODIGO_ACTIVIDAD_O_TIPO_CUPO_CREDITO_DIFERENTE = "El código de actividad es distinto a 1 o el Tipo del cupo crédito es diferente a OPE";

	public DatosInicialesDelLimite(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
