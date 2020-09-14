package co.com.bancolombia.certificacion.libranzas.exceptions;

public class ElSaldoNoTieneDiferencia extends AssertionError{
	
	private static final long serialVersionUID = -3103879629629039506L;
	public static final String SALDO_NO_MODIFICADO = "El saldo no se modificó correctamente";
	
	public ElSaldoNoTieneDiferencia (String mensaje, Throwable error) {
		super(mensaje, error);
	}

}
