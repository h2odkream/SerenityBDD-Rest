package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarDisponibilidad;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class EsperarExpiracion implements Task {



	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Esperar.segundos(60), EsperarDisponibilidad.delElemento(DocumentosPage.BOTON_SALIR_INACTIVIDAD),
				Click.on(DocumentosPage.BOTON_SALIR_INACTIVIDAD), EsperarDisponibilidad.delElemento(DocumentosPage.BOTON_FINALIZAR),
				Click.on(DocumentosPage.BOTON_FINALIZAR));

	}

	public static EsperarExpiracion token() {
		return Tasks.instrumented(EsperarExpiracion.class);
	}
}
