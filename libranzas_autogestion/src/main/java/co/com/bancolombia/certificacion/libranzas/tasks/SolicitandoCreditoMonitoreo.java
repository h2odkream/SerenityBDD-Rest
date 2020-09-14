package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarInvisible;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.models.Credito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Attribute;

import static co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage.CIRCULO_ESPERA;
import static co.com.bancolombia.certificacion.libranzas.userinterfaces.InformacionGeneralPage.*;
import static co.com.bancolombia.certificacion.libranzas.userinterfaces.OfertaPage.*;

public class SolicitandoCreditoMonitoreo implements Task {
    private Credito credito;

    public SolicitandoCreditoMonitoreo(Credito credito) {
        this.credito = credito;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(EmpezarExperiencia.deLibranza(), Esperar.segundos(10), EsperarURL.deLaPantalla("oferta"));
        boolean estadoCirculo = CIRCULO_ESPERA.resolveFor(actor).isPresent();

        if (estadoCirculo) {
            actor.attemptsTo(EsperarInvisible.elElemento(CIRCULO_ESPERA), Esperar.segundos(6),
                    Enter.theValue(credito.getMonto()).into(MONTO_INGRESAR));

            int mesesPlazoModel = Integer.parseInt(credito.getPlazo());
            String[] mesesPlazoVec = Attribute.of(MESES).named("placeholder").viewedBy(actor).asString().split("m");
            int mesesPlazoFront = Integer.parseInt(mesesPlazoVec[0].trim());

            if (mesesPlazoModel != mesesPlazoFront) {
                do {
                    actor.attemptsTo(Click.on(BOTON_MENOS_MESES));
                    mesesPlazoVec = Attribute.of(MESES).named("placeholder").viewedBy(actor).asString().split("m");
                    mesesPlazoFront = Integer.parseInt(mesesPlazoVec[0].trim());
                } while (mesesPlazoFront > mesesPlazoModel && mesesPlazoFront != mesesPlazoModel);
            }


            actor.attemptsTo(EsperarURL.deLaPantalla("confirmacion"), Esperar.segundos(20),
                    Click.on(FLECHA_PARA_DESPLEGAR_CUENTAS), Esperar.segundos(5),
                    Click.on(CUENTA_EN_LISTA.of(credito.getCuenta())), Click.on(BOTON_CONTINUAR_CONFIRMACION));

        }


    }

    public static SolicitandoCreditoMonitoreo conLosDatos(Credito credito) {
        return Tasks.instrumented(SolicitandoCreditoMonitoreo.class, credito);
    }

}
