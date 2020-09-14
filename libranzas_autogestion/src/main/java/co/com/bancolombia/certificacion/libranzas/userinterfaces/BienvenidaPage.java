package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class BienvenidaPage extends PageObject {

	public static final Target EMPIEZA = Target.the("Boton empieza de la imagen de credito de libranza.")
			.locatedBy("//*[contains(text(), 'Empieza')]");

	public static final Target SALIR = Target.the("Boton salir").locatedBy(
			"//header/div[@class='row flex-nowrap justify-content-between align-items-center']/div[@class='col-4 d-flex justify-content-end align-items-center']/a");
	public static final Target MENSAJE_TRANSICION = Target.the("Mensaje del gif")
			.locatedBy("/html/body/modal-container/div/div/div/div/app-barra-progreso/div/p");
}