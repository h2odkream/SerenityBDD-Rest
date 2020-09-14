package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class AutenticacionOauthPage extends PageObject {


	public static final Target USUARIO_OAUTH = Target.the("Campo para ingresar la cedula del usuario")
			.locatedBy("//input[@placeholder='Ingresa tu usuario']");
	public static final Target CLAVE = Target.the("Campo para ingresar la clave del usuario")
			.locatedBy("//div[@aria-label='{0}'][1]");
	public static final Target CAMPO_CLAVE = Target.the("Campo de la clave")
			.locatedBy("//input[@class='input-input input-password']");
	public static final Target BOTON_CONTINUAR = Target.the("Boton continuar").locatedBy("//div[text()='Continuar']");
	public static final Target IMAGEN_ESPERA_OAUTH = Target.the("Imagen de espera despues de que se autentica")
			.locatedBy("/html/body/div[4]/div[2]/div/div/div/img");
	

	public static final Target MENSAJE_ERROR = Target.the("Mensaje error general")
			.locatedBy("");
	public static final Target CODIGO_ERROR= Target.the("Codigo error general")
			.locatedBy("");
	public static final Target BOTON_SALIR_SIN_CELULAR = Target.the("Codigo error, con correo y sin celular")
			.locatedBy("");

}