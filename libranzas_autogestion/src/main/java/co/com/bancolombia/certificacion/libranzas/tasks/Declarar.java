package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Declarar implements Task {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Declarar.class);

	@Override
	public <T extends Actor> void performAs(T actor) {

		LOGGER.info(
				"================================================PANTALLA DOCUMENTOS=========================================");
		actor.attemptsTo(EsperarURL.deLaPantalla("documentos"), Esperar.segundos(8), Click.on(DocumentosPage.CHECK_ACEPTAR_CONDICIONES));

	}

	public static Declarar queAceptaCondicionesPagare() {
		return Tasks.instrumented(Declarar.class);
	}

}
