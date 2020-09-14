package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class CerrarError implements Task {
	
	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Click.on(DocumentosPage.BOTON_SALIR_GENERAL));

	}

	public static CerrarError popup() {
		return Tasks.instrumented(CerrarError.class);
	}

}
