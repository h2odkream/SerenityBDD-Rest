package co.com.bancolombia.certificacion.libranzas.interactions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class EsperarURL implements Interaction {

	private String elemento;

	public EsperarURL(String elemento) {
		this.elemento = elemento;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		WebDriverWait wait = new WebDriverWait(BrowseTheWeb.as(actor).getDriver(), 300);

		wait.until(ExpectedConditions.urlContains(elemento));

	}

	public static EsperarURL deLaPantalla(String url) {
		return new EsperarURL(url);
	}
}
