package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.BienvenidaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class EmpezarExperiencia implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(EsperarURL.deLaPantalla("libranza"), Esperar.segundos(10),
                Scroll.to(BienvenidaPage.EMPIEZA), Click.on(BienvenidaPage.EMPIEZA));

    }

    public static EmpezarExperiencia deLibranza() {
        return Tasks.instrumented(EmpezarExperiencia.class);
    }

}
