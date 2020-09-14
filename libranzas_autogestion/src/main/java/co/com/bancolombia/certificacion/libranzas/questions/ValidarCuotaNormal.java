package co.com.bancolombia.certificacion.libranzas.questions;

import static co.com.bancolombia.certificacion.libranzas.questions.ValidarTasasNormal.tasaMesVencidaBDTasasAntesDe;
import static co.com.bancolombia.certificacion.libranzas.util.FactorSeguroDeVida.gestionarFactorSeguroDeVida;
import static co.com.bancolombia.certificacion.libranzas.util.CalculoDeLaCuota.calculoCuotaFinal;

import java.text.NumberFormat;
import java.util.Locale;

import co.com.bancolombia.certificacion.libranzas.userinterfaces.OfertaPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarCuotaNormal implements Question<Boolean> {

	private int plazo;
	private String monto;

	public ValidarCuotaNormal(int plazo, String monto) {
		this.plazo = plazo;
		this.monto = monto;
	}

	@Override
	public Boolean answeredBy(Actor actor) {

		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
		String cuotaCompletaFront = Text.of(OfertaPage.CUOTA_CARD).viewedBy(actor).value();
		String[] cuotaSinSignoPesosVec = cuotaCompletaFront.split("\\$");
		String[] cuotaSinComaVec = cuotaSinSignoPesosVec[1].split("\\,");
		String cuotaNumeros1 = cuotaSinComaVec[0].trim();
		String cuotaNumeros2 = cuotaSinComaVec[1].trim();
		String cuotaCompletaNumeros = cuotaNumeros1 + cuotaNumeros2;

		double cuotaCompletaDouble = Double.parseDouble(cuotaCompletaNumeros.trim());
		double montoParaCalculo = Double.parseDouble(monto);

		int montoParaSeguroDeVida = Integer.parseInt(monto);

		int cuotaConCalculo = calculoCuotaFinal(montoParaCalculo, tasaMesVencidaBDTasasAntesDe, plazo,
				gestionarFactorSeguroDeVida(montoParaSeguroDeVida));


		if (nf.format(cuotaCompletaDouble).equals(nf.format(cuotaConCalculo))
				|| nf.format(cuotaCompletaDouble).equals(nf.format(cuotaConCalculo + 1))) {
			return true;
		}

		return false;
	}

	public static ValidarCuotaNormal delCalculoYElFront(int plazo, String monto) {
		return new ValidarCuotaNormal(plazo, monto);
	}

}
