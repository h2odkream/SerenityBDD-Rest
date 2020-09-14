package co.com.bancolombia.certificacion.libranzas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class AlFinalizarLaExperiencia implements Question<String> {

	@Override
	public String answeredBy(Actor actor) {
		return BrowseTheWeb.as(actor).getDriver().getCurrentUrl();
	}


	public static AlFinalizarLaExperiencia laURLQueMuestra() {
		return new AlFinalizarLaExperiencia();
	}
}
