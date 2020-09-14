package co.com.bancolombia.certificacion.libranzas.exceptions;

public class ComparacionErrorCOMFFLGBVLyLMBAL extends AssertionError{
	
	private static final long serialVersionUID = 7201975529662756666L;
	public static final String ERROR_COMPARACION_LMBAL_COMFFLGBVL = "Error en la comparación de datos entre el archivo COMFFLGBVL y LMBAL";
	
	public ComparacionErrorCOMFFLGBVLyLMBAL(String mensaje, Throwable error) {
		super(mensaje,error);
	}

}
