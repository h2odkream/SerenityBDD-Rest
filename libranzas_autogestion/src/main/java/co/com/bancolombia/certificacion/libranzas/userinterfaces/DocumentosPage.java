package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DocumentosPage extends PageObject {

	public static final Target TITULO_DE_DOCUMENTOS = Target.the("TÍtulo pantalla de documentos")
			.locatedBy("//*[@id=\"titleDocs\"]");

	public static final Target CHECK_PAGARE = Target.the("Check que confirma que ya se ha leido el pagare")
			.locatedBy("//*[@id='acept2']");
	public static final Target SI_ACEPTO_SEGURO = Target.the("Check que afirma aceptar el seguro de vida deudores")
			.locatedBy("//span[contains(text(),'Sí acepto')]");
	// *[@id=\"step1\"]/label[1]/span
	public static final Target NO_ACEPTO_SEGURO = Target
			.the("Check que indica que no acepta el seguro de vida deudores")
			.locatedBy("//*[@id=\"step1\"]/label[2]/span");
	public static final Target BOTON_SI_DEL_POPUP_NO_ACEPTO = Target
			.the("Boton Si del PopUp, para continuar con la solicitud y aceptar el seguro de vida Deudores")
			.locatedBy("/html/body/modal-container/div/div/div/div[3]/button[2]");
	public static final Target BOTON_NO_DEL_POPUP_NO_ACEPTO = Target
			.the("Boton No del PopUp, para no continuar con la solicitud y no aceptar el seguro de vida Deudores")
			.locatedBy("/html/body/modal-container/div/div/div/div[3]/button[1]");
	public static final Target EQUIS_POPUP_NO_ACEPTO = Target.the("Equis que permite seguir con la experiencia")
			.locatedBy("//button[@class='close']/span");
	public static final Target INGRESAR_CLAVE_DINAMICA = Target.the("Input para ingresar la clave dinamica")
			.locatedBy("//*[@id=\"inputOtp\"]");
	public static final Target GENERAR_NUEVA_CLAVE_DINAMICA = Target.the("Boton para generar una nueva clave dinamica")
			.locatedBy("//a[@id='newOtp']");
	public static final Target GENERAR_NUEVO_TOKEN = Target.the("Boton para generar un nuevo token")
			.locatedBy("//a[@id='newOtp']");
	public static final Target MENSAJE_ERROR_TOKEN = Target.the("Mensaje error general token")
			.locatedBy("/html/body/modal-container/div/div/div[2]/p[1]");
	public static final Target CODIGO_ERROR_TOKEN = Target.the("Codigo error general token")
			.locatedBy("//modal-container[@class='modal fade in']//p[2]");
	public static final Target BOTON_SALIR_GENERAL = Target.the("Boton salir error 6 generaciones de token")
			.locatedBy("//button[contains(text(), 'Salir')]");
	public static final Target BOTON_CANCELAR = Target.the("Boton cancelar el proceso del credito")
			.locatedBy("//button[contains(text(), 'Cancelar')]");

	public static final Target BOTON_SALIR_INACTIVIDAD = Target.the("Boton Salir del mensaje 5 minutos de inactividad")
			.locatedBy("//button[contains(text(), 'Salir')]");
	public static final Target CIRCULO_ESPERA = Target.the("Simbolo de espera").locatedBy("//div[@class='container progress-form']/div[@class='progress-line']");
	public static final Target CORREO_ENMASCARADO = Target.the("Correo enmascarado")
			.locatedBy("//div[@class='col-md-12']/p");
	public static final Target ERROR_CLAVE_DINAMICA = Target.the("Error de la clave dinamica")
			.locatedBy("//div[@class='modal-body']//p[text()='Clave Dinamica incorrecta.']");
	public static final Target CERRAR_ERROR_CLAVE_DINAMICA = Target.the("Modal")
			.locatedBy("//div[@class='modal-content']/div[@class='modal-footer']/button");
	public static final Target CODIGO_ERROR_CLAVE_DINAMICA = Target.the("Error")
			.locatedBy("//div[@class='modal-content']/div[@class='modal-body']/p[2]");
	public static final Target MENSAJE_SOFTOKEN = Target.the("Mensaje de softoken")
			.locatedBy("//div[@class='col-md-10 ng-tns-c9-0 ng-star-inserted']/p");

	public static final Target TEXTO_CODIGO_DOCUMENTOS = Target
			.the("apartado donde se le indica que se firmará con código").locatedBy("(//div[@class='col-sm-10'])[1]/p");

	/*
	 * BIG BANG
	 */

	public static final Target VER_PAGARE = Target.the("link para ver los documentos")
			.locatedBy("//div[@class='documents']/div[@class='col-md-12']/a");

	public static final Target CHECK_ACEPTAR_CONDICIONES = Target
			.the("check para confirmar que se acepta las condiciones").locatedBy(
					"//mat-checkbox/label/div[@class='mat-checkbox-inner-container mat-checkbox-inner-container-no-side-margin']");

	public static final Target CAMPO_CLAVE_DINAMICA = Target.the("campo donde se introduce la clave dinamica")
			.locatedBy(
					"//div[@class='mat-form-field-infix']/input");

	public static final Target BOTON_FINALIZAR = Target.the("Boton finalizar el proceso del credito")
			.locatedBy("//button[contains(text(), 'Finalizar')]");

}
