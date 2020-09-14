package co.com.bancolombia.certificacion.libranzas.exceptions;

public class ValidacionesDelDesembolso extends AssertionError {

	private static final long serialVersionUID = 2399841767748813484L;
	public static final String VALIDACIONES_DEL_DESEMBOLSO_DIFERENTES = "Los datos entre las comparaciones con las bases de datos oracle y iseries no están iguales.";

	public ValidacionesDelDesembolso(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
