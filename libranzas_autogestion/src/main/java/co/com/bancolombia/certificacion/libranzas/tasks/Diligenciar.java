package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarInvisible;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarVisible;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.InformacionGeneralPage;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.OfertaPage;
import co.com.bancolombia.certificacion.libranzas.models.Credito;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Attribute;

public class Diligenciar implements Task {


	public static Credito credito;


	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(EmpezarExperiencia.deLibranza(), Esperar.segundos(10), EsperarURL.deLaPantalla("oferta"));
		boolean estadoCirculo = DocumentosPage.CIRCULO_ESPERA.resolveFor(actor).isPresent();

		if (estadoCirculo) {
			actor.attemptsTo(EsperarInvisible.elElemento(DocumentosPage.CIRCULO_ESPERA), Esperar.segundos(6),
					Enter.theValue("1000000").into(OfertaPage.MONTO_INGRESAR));

			int mesesPlazoModel = Integer.parseInt("84");
			String[] mesesPlazoVec = Attribute.of(OfertaPage.MESES).named("placeholder").viewedBy(actor).asString().split("m");
			int mesesPlazoFront = Integer.parseInt(mesesPlazoVec[0].trim());

			if (mesesPlazoModel != mesesPlazoFront) {
				do {
					actor.attemptsTo(Click.on(OfertaPage.BOTON_MENOS_MESES));
					mesesPlazoVec = Attribute.of(OfertaPage.MESES).named("placeholder").viewedBy(actor).asString().split("m");
					mesesPlazoFront = Integer.parseInt(mesesPlazoVec[0].trim());
				} while (mesesPlazoFront > mesesPlazoModel && mesesPlazoFront != mesesPlazoModel);
			}

			actor.attemptsTo(Esperar.segundos(20),Click.on(OfertaPage.MENSAJE_ABAJO_MESES), EsperarVisible.elElemento(OfertaPage.CUOTA_CARD), Esperar.segundos(10),
					Click.on(OfertaPage.BOTON_LOQUIERO));

			actor.attemptsTo(EsperarURL.deLaPantalla("confirmacion"), Esperar.segundos(20),
					Click.on(InformacionGeneralPage.FLECHA_PARA_DESPLEGAR_CUENTAS), Esperar.segundos(5),
					Click.on(InformacionGeneralPage.CUENTA_EN_LISTA.of("*******5017")), Click.on(InformacionGeneralPage.BOTON_CONTINUAR_CONFIRMACION));

		}

	}


	public static Diligenciar laOferta() {
		return Tasks.instrumented(Diligenciar.class);
	}
}




