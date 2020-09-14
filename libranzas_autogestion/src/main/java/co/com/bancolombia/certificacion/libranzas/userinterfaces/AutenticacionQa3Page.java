package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AutenticacionQa3Page extends PageObject{


	public static final Target CAMPO_CLAVE = Target.the("Campo de la clave").locatedBy("//*[@id=\"password\"]");
	public static final Target TXT_USUARIO = Target.the("Campo de texto para ingresar el usuario")
			.locatedBy("//*[@id=\"username\"]");
	public static final Target BOTON_CONTINUAR = Target.the("Boton continuar").locatedBy("//*[@id=\"btnGo\"]");
	public static final Target CLAVE = Target.the("Clave").locatedBy("//div[text()=\"{0}\"]");
	public static final Target BOTON_INGRESAR = Target.the("Boton ingresar").locatedBy("//*[@id=\"btnGo\"]");

}
