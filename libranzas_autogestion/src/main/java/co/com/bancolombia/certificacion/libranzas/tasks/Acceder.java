package co.com.bancolombia.certificacion.libranzas.tasks;

import java.util.Set;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.SVPPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class Acceder implements Task {



	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(Esperar.segundos(10));
		BrowseTheWeb.as(actor).getDriver().switchTo().frame(SVPPage.FRAME_IFRM.resolveFor(actor));
		actor.attemptsTo(Click.on(SVPPage.BOTON_SOLICITALO_AQUI));

		Set<String> setVentanas = Serenity.getWebdriverManager().getCurrentDriver().getWindowHandles();
		setVentanas.remove(Serenity.getWebdriverManager().getCurrentDriver().getWindowHandle());
		Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(setVentanas.iterator().next());

		actor.attemptsTo(Esperar.segundos(30));
	}

	public static Acceder desdeElBanner() {
		return Tasks.instrumented(Acceder.class);
	}

}
