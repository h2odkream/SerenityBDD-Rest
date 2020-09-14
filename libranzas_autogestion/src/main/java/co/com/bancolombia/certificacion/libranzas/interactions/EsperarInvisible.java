package co.com.bancolombia.certificacion.libranzas.interactions;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;

import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class EsperarInvisible implements Interaction {

	private Target elemento;

	public EsperarInvisible(Target elemento) {
		this.elemento = elemento;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), 400);
		wait.until(invisibilityOf(elemento.resolveFor(actor)));
	

	}

	public static EsperarInvisible elElemento(Target elemento) {
		return new EsperarInvisible(elemento);
	}

}
