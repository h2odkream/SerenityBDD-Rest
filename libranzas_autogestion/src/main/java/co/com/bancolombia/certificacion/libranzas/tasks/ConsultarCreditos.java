package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.SVPPage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class ConsultarCreditos implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Esperar.segundos(30000));
		BrowseTheWeb.as(actor).getDriver().switchTo().frame(SVPPage.FRAME_IFRM.resolveFor(actor));

		actor.attemptsTo(Click.on(SVPPage.BOTON_PRODUCTOS), Click.on(SVPPage.BOTON_CONSULTAR_CREDITOS));
	}

	public static ConsultarCreditos enLaSVP() {
		return Tasks.instrumented(ConsultarCreditos.class);
	}

}
