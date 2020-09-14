package co.com.bancolombia.certificacion.libranzas.exceptions;

public class ComparacionErrorXLOGSRVyLMBAL extends AssertionError {

	private static final long serialVersionUID = 9222346242468178727L;
	public static final String COMPARACION_XLOGSRV_LMBAL_INCORRECTA = "Hubo un error en la comparación de datos entre los archivos XLOGSRV y LMBAL";

	public ComparacionErrorXLOGSRVyLMBAL(String mensaje, Throwable error) {
		super(mensaje, error);
	}
}
