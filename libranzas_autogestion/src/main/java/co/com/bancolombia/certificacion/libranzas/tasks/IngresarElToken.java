package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.EsperarDisponibilidad;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarElToken implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < 3; i++) {
            actor.attemptsTo(Enter.theValue("234567").into(DocumentosPage.INGRESAR_CLAVE_DINAMICA));
            try {

                if (i < 2) {

                    actor.attemptsTo(EsperarDisponibilidad.delElemento(DocumentosPage.BOTON_FINALIZAR),
                            Click.on(DocumentosPage.BOTON_FINALIZAR),
                            EsperarDisponibilidad.delElemento(DocumentosPage.BOTON_SALIR_INACTIVIDAD),
                            Click.on(DocumentosPage.BOTON_SALIR_INACTIVIDAD));

                }
            } catch (Exception e) {
                e.getMessage();
            }
        }

    }

    public static IngresarElToken incorrecto() {
        return Tasks.instrumented(IngresarElToken.class);
    }

}
