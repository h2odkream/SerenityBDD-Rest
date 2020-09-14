package co.com.bancolombia.certificacion.libranzas.questions;


import co.com.bancolombia.certificacion.libranzas.userinterfaces.FinalizacionPage;
import co.com.bancolombia.certificacion.libranzas.models.Credito;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarNumeroCuenta implements Question<Boolean> {

    Credito credito;

    public ValidarNumeroCuenta(Credito credito) {

        this.credito = credito;

    }


    @Override
    public Boolean answeredBy(Actor actor) {
        String cuentaNumeroFront = Text.of(FinalizacionPage.NUMERO_CUENTA).viewedBy(actor).value();
        String[] cuentaSinTexto = cuentaNumeroFront.split("\\.");
        String cuentaNumero = cuentaSinTexto[1];

        Boolean comparacionCuenta = cuentaNumero.trim().equals(credito.getCuenta().trim());

        if (comparacionCuenta) {return true;}

        return false;
    }


    public static ValidarNumeroCuenta esteVisible(Credito credito) {
        return new ValidarNumeroCuenta(credito);
    }
}
