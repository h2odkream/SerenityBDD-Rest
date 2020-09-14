package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class EncuestaPage extends PageObject {

	public static final Target ESTRELLAS = Target.the("Boton para elegir estrella")
			.locatedBy("//div[@class='calification-star']/div/rating/span[@aria-valuemax='5']");
	public static final Target OPCIONES = Target.the("Opciones para elegir que fue lo que mas te gusta")
			.locatedBy("/html/body/modal-container/div/div/div[2]/div/div[2]/div[2]/div/div/button[2]");
	public static final Target COMENTARIO = Target.the("Area de texto para dejar comentarios")
			.locatedBy("//div[@class='form-group ']/textarea");
	public static final Target BOTON_ENVIAR = Target.the("Boton para enviar la encuesta")
			.locatedBy("//div[@class='modal-footer ']/button");
	public static final Target BOTON_CERRAR = Target.the("Boton cerrar la encuesta")
			.locatedBy("//div[@class='next-action ']/button");
}
