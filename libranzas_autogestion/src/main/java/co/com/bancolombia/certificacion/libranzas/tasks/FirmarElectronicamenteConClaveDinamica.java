package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasIseries;
import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarDisponibilidad;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarInvisible;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.models.ModelPccfflgaen;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.bancolombia.certificacion.libranzas.util.CapturarFecha.FECHA_ACTUAL_SISTEMA;

public class FirmarElectronicamenteConClaveDinamica implements Task {

	private String cedula;

	public FirmarElectronicamenteConClaveDinamica(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		if (DocumentosPage.CIRCULO_ESPERA.resolveFor(actor).isCurrentlyVisible()) {
			EsperarInvisible.elElemento(DocumentosPage.CIRCULO_ESPERA);
		}
		actor.attemptsTo(EsperarURL.deLaPantalla("documentos"));

		actor.attemptsTo(Esperar.segundos(80), EsperarDisponibilidad.delElemento(DocumentosPage.CHECK_ACEPTAR_CONDICIONES),
				Click.on(DocumentosPage.CHECK_ACEPTAR_CONDICIONES), EsperarInvisible.elElemento(DocumentosPage.CIRCULO_ESPERA), Esperar.segundos(13));

		ModelPccfflgaen modelClaveDinamica = RealizarConsultasIseries.consultaClaveDinamica(FECHA_ACTUAL_SISTEMA,
				cedula);

		actor.attemptsTo(Esperar.segundos(10),
				Enter.theValue(modelClaveDinamica.getClaveDinamica()).into(DocumentosPage.CAMPO_CLAVE_DINAMICA), Esperar.segundos(3),
				Click.on(DocumentosPage.BOTON_FINALIZAR), EsperarInvisible.elElemento(DocumentosPage.CIRCULO_ESPERA));


	}

	public static FirmarElectronicamenteConClaveDinamica elPagareYElSeguroDeVida(String cedula) {
		return Tasks.instrumented(FirmarElectronicamenteConClaveDinamica.class, cedula);
	}

}
