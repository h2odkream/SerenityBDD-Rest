package co.com.bancolombia.certificacion.libranzas.exceptions;

public class NombreEmpresaNoCoincide extends AssertionError {
	private static final long serialVersionUID = 1L;
	
	public static final String NOMBRE_EMPRESA_DISTINTOS = "El nombre de la empresa traida del log XJMSC y del front no son iguales";

	public NombreEmpresaNoCoincide(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
