package co.com.bancolombia.certificacion.libranzas.interactions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;

public class EsperarDisponibilidad implements Interaction {

	private Target elemento;

	public EsperarDisponibilidad(Target elemento) {
		this.elemento = elemento;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), 300);
		wait.until(ExpectedConditions.elementToBeClickable(elemento.resolveFor(actor)));

	}

	public static EsperarDisponibilidad delElemento(Target elemento) {
		return new EsperarDisponibilidad(elemento);
	}

}
