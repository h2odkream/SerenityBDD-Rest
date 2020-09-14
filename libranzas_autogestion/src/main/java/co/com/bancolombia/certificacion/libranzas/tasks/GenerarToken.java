package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarDisponibilidad;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class GenerarToken implements Task {

	private int intentos = 0;

	public GenerarToken(int intentos) {
		this.intentos = intentos;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		for (int i = 1; i < intentos; i++) {

			actor.attemptsTo(Esperar.segundos(5), EsperarDisponibilidad.delElemento(DocumentosPage.GENERAR_NUEVO_TOKEN),
					Click.on(DocumentosPage.GENERAR_NUEVO_TOKEN));

		}
	}

	public static GenerarToken variasVeces(int intentos) {
		return Tasks.instrumented(GenerarToken.class, intentos);
	}
}
