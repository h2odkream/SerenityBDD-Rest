package co.com.bancolombia.certificacion.libranzas.questions;

import co.com.bancolombia.certificacion.libranzas.userinterfaces.OfertaPage;
import co.com.bancolombia.certificacion.libranzas.util.CalculoDeLaCuota;
import co.com.bancolombia.certificacion.libranzas.util.FactorSeguroDeVida;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import java.text.NumberFormat;
import java.util.Locale;

public class ValidarCuotaSeguroDesempleo implements Question<Boolean> {
    private int plazo;
    private String monto;

    public ValidarCuotaSeguroDesempleo(int plazo, String monto) {
        this.plazo = plazo;
        this.monto = monto;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
        String cuotaCompletaFront = Text.of(OfertaPage.CUOTA_CARD_SD).viewedBy(actor).value();
        String[] cuotaSinSignoPesosVec = cuotaCompletaFront.split("\\$");
        String[] cuotaSinComaVec = cuotaSinSignoPesosVec[1].split("\\,");
        String cuotaNumeros1 = cuotaSinComaVec[0].trim();
        String cuotaNumeros2 = cuotaSinComaVec[1].trim();
        String cuotaCompletaNumeros = cuotaNumeros1 + cuotaNumeros2;

        double cuotaCompletaDouble = Double.parseDouble(cuotaCompletaNumeros.trim());
        double montoParaCalculo = Double.parseDouble(monto);

        int montoParaSeguroDeVida = Integer.parseInt(monto);

        int cuotaConCalculo = CalculoDeLaCuota.calculoCuotaFinal(montoParaCalculo, ValidarTasasSeguroDesempleo.tasaMesVencidaBDTasasAntesDe, plazo,
                FactorSeguroDeVida.gestionarFactorSeguroDeVida(montoParaSeguroDeVida));

        int cuotaSeguroDesempleo = CalculoDeLaCuota.calculoCuotaSeguroDesempleo(cuotaConCalculo, montoParaCalculo);


        if (nf.format(cuotaCompletaDouble).equals(nf.format(cuotaSeguroDesempleo))
                || nf.format(cuotaCompletaDouble).equals(nf.format(cuotaSeguroDesempleo + 1))) {
            return true;
        }

        return false;
    }

    public static ValidarCuotaSeguroDesempleo conElCalculoYElFront(int plazo, String monto) {
        return new ValidarCuotaSeguroDesempleo(plazo, monto);
    }
}
