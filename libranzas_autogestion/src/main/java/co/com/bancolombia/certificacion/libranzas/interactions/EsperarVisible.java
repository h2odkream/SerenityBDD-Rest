package co.com.bancolombia.certificacion.libranzas.interactions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class EsperarVisible implements Interaction {

	private Target elemento;

	public EsperarVisible(Target elemento) {
		this.elemento = elemento;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), 300);
		wait.until(ExpectedConditions.visibilityOf(elemento.resolveFor(actor)));

	}

	public static EsperarVisible elElemento(Target elemento) {
		return new EsperarVisible(elemento);
	}

}
