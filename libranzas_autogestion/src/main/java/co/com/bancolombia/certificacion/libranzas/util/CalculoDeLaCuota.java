package co.com.bancolombia.certificacion.libranzas.util;

public class CalculoDeLaCuota {
	private CalculoDeLaCuota() {
		throw new IllegalStateException("Utility class");
	}

	public static double cuotaUno(double monto, double tasaDeInteres, int plazo) {

		double parte1 = monto * (tasaDeInteres / 100);
		double parte2 = Math.pow((1 + (tasaDeInteres / 100)), plazo);
		double parte3 = Math.pow((1 + (tasaDeInteres / 100)), (plazo)) - 1;


		return ((parte1 * parte2) / (parte3));

	}

	public static double calculoCuotaSeguroDeVida(double monto, double factor) {
		return monto * factor;
	}

	public static int calculoCuotaFinal(double monto, double tasaDeInteres, int plazo, double factor) {
		double doublefeePlusSecureCost = cuotaUno(monto, tasaDeInteres, plazo)
				+ calculoCuotaSeguroDeVida(monto, factor);
		return (int) Math.round(doublefeePlusSecureCost);
	}


	//SEGURO DESEMPLEO

	public static double calculoFactorSeguroDesempleo(double monto) {
		return monto * 0.002808;
	}

	public static int calculoCuotaSeguroDesempleo(double cuotaActual, double monto) {

		double cuotaSeguroDesempleo = cuotaActual + (calculoFactorSeguroDesempleo(monto));
		return (int) Math.round(cuotaSeguroDesempleo);

	}

}
