package co.com.bancolombia.certificacion.libranzas.exceptions;

public class ErroresFront extends AssertionError {

	private static final long serialVersionUID = 6353397137778284385L;
	public static final String ERROR_AUTENTICACION_USUARIO_CLAVE_INCORRECTA = "Hubo un error diferente en este punto de autenticación";
	public static final String ERROR_AUTENTICACION_USUARIO_BLOQUEADO = "Hubo un error diferente en este punto de autenticación";
	public static final String ERROR_BANNER = "Hubo un error con la comprobación del banner";
	public static final String ERROR_CONVENIO_NO_EXISTE = "Error diferente al que debe presentar por tener un convenio que no existe en iSeries";
	public static final String ERROR_CONVENIO_NO_ES_LIBRANZA = "Error diferente al que debe presentar por tener un convenio que no es de libranza.";
	public static final String VALIDACION_CONVENIO_LIBRANZA = "El convenio no es de libranza.";
	public static final String VALIDACION_CODIGO_TRANSACCION_STIFFLGDEP = "Los codigos de transacción son distintos";
	public static final String VALIDACION_CODIGO_TRANSACCION_STIFFLGVP1 = "Los codigos de transacción son distintos";
	public static final String VALIDACION_CODIGO_TRANSACCION_STIFFLGSBC = "Los codigos de transacción son distintos";
	public static final String DIAS_NOVEDAD = "Hubo un error en la validación de la fecha de novedad OTP";
	public static final String ERROR_DIAS_NOVEDAD_FRONT = "Aparece un error diferente del que debería por tener la fecha de novedad OTP menor a 5 días";
	public static final String URL_ACTUAL_DIFERENTE = "La URL actual es diferente a la que debería";
	public static final String ERROR_CLAVE_DINAMICA_INCORRECTA = "El error de clave dinámica incorrecta es diferente a la esperada.";
	public static final String ERROR_CLAVE_DINAMICA_INCORRECTA_ULTIMO_INTENTO = "El error de clave dinámica incorrecta es diferente a la esperada, en el ultimo intento.";
	public static final String ERROR_CLAVE_DINAMICA_BLOQUEADA = "El error de clave dinámica bloqueada es diferente a la esperada.";
	public static final String ERROR_PREAPROBADO_VENCIDO = "El error que se muestra es diferente al esperado por tener el preaprobado vencido";
	public static final String RESPUESTA_PRECALCULADO_INCORRECTA = "La respuesta de la base de datos de precalculado es diferente a las esperadas";
	public static final String MENSAJE_PANTALLA_TRANSICION_DISTINTO = "El mensaje que aparece en la pantalla de transición es diferente al esperado.";
	public static final String MENSAJE_DE_SOFTOKEN = "El mensaje de softoken es diferente al esperado.";
	public static final String CASO_BIZAGI_DASHBOARD = "El caso de bizagi que aparece el dashboard es incorrecto.";
	public static final String NOMBRE_CLIENTE_DASHBOARD = "El nombre del cliente del dashboard no coinciden.";
	public static final String ERROR_TOKEN_INCORRECTO = "El error de token incorrecta es diferente a la esperada.";
	public static final String CODIGO_TOKEN_INCORRECTO = "El error de token incorrecta es diferente a la esperada, en el ultimo intento.";
	public static final String ERROR_PRESTAMO_EN_SVP = "el número de prestamo es diferente al esperado";
	public static final String TEXTO_PANTALLA_DOCUMENTOS_DIFERENTE_CODIGO = "EL texto de la pantalla de documentos donde indica que se firmara con codigo es diferente";
	public static final String NO_APARECE_LINK_DESCARGA_DOCUMENTOS = "No aparece el link para descargar los documentos.";
	public static final String NUMERO_CUENTA_NO_COINCIDEN = "el numero de cuenta desde feature con front no coinciden.";

	public ErroresFront(String mensaje, Throwable error) {
		super(mensaje, error);
	}

}
