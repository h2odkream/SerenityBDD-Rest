package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.EsperarDisponibilidad;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarInvisible;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarToken implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		if (DocumentosPage.CIRCULO_ESPERA.resolveFor(actor).isVisible()) {

			actor.attemptsTo(EsperarInvisible.elElemento(DocumentosPage.CIRCULO_ESPERA),
					Enter.theValue("234567").into(DocumentosPage.INGRESAR_CLAVE_DINAMICA));
		} else {

			actor.attemptsTo(Enter.theValue("234567").into(DocumentosPage.INGRESAR_CLAVE_DINAMICA));

		}

		actor.attemptsTo(EsperarDisponibilidad.delElemento(DocumentosPage.BOTON_FINALIZAR), Click.on(DocumentosPage.BOTON_FINALIZAR));

	}

	public static IngresarToken incorrecto() {
		return Tasks.instrumented(IngresarToken.class);
	}
}
