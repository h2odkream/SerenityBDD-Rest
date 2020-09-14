package co.com.bancolombia.certificacion.libranzas.exceptions;

public class ErroresValidacionCorreo extends AssertionError {

	private static final long serialVersionUID = 7636708118096992752L;
	public static final String NO_APARECE_LINK_DE_DESCARGA = "No se visualiza el link para descargar el documento en la pantalla de finalización";
	public static final String APARECE_CORREO_ENMASCARADO = "aparece correo enmascarado cuando este cliente no tiene";
	public static final String NO_APARECE_NUMERO="no aparece numero de telefono";

	public ErroresValidacionCorreo(String mensaje, Throwable error) {
		super(mensaje, error);
	}

}
