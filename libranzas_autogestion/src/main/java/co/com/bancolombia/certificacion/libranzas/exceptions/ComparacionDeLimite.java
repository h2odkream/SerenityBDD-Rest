package co.com.bancolombia.certificacion.libranzas.exceptions;

public class ComparacionDeLimite extends AssertionError {

	private static final long serialVersionUID = -9162354531847094326L;
	public static final String COMPARACION_DE_LIMITE_ANTES_DESPUES_INCORRECTA = "Algo en la comparación del saldo antes y despues del desembolsó falló";

	public ComparacionDeLimite(String mensaje, Throwable causa) {
		super(mensaje, causa);
	}

}
