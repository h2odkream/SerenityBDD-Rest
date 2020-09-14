package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class ErroresOauthPage extends PageObject{

	public static final Target ERROR_LARGO = Target.the("Error del front")
			.locatedBy("// div[@class='modal-content']/div[2]/p[2]");
	public static final Target ERROR_ANCHO = Target.the("Error del front")
			.locatedBy("// div[@class='row-table mt10 width-xs-320 width-xxs pad-xs-20']/div/p");
	public static final Target ERROR_DEFAULT1 = Target.the("Error Default1")
			.locatedBy("//*[contains(text(),'DEFAULT')]");
	public static final Target SALIR_ERROR_DEFAULT1 = Target.the("Error Default")
			.locatedBy("//*[contains(text(),'DEFAULT')]");
	public static final Target ERROR_AUTENTICACION = Target
			.the("Error que sucede cuando el usuario o la clave es incorrecta")
			.locatedBy("//div[@class='input-error-alert']");
	public static final Target ERROR_MONTO = Target
			.the("Error que aparece cuando el monto es menor o mayor al permitido")
			.locatedBy("//*[@id='errorMessage']");
	public static final Target TEXTO_INDISPONIBILIDAD = Target.the("Texto de la ventana de indisponibilidad")
			.locatedBy("//*[@class='mt100 sm-mt26']");

}
