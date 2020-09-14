package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class FinalizacionPage extends PageObject {

	public static final Target BOTON_SALIR = Target.the("Boton donde cierra la experiencia luego del desembolso")
			.locatedBy("//div[@class='next-action text-center']/button");
	public static final Target LINK_DESCARGA_DOCUMENTOS = Target.the("link donde se descarga los documentos")
			.locatedBy("//ul[@class='ng-tns-c20-3']//a[@class='ng-tns-c20-3']");
	public static final Target NOMBRE_EMPREESA = Target.the("campo nombre de la empresa")
			.locatedBy("//strong[@class='nombre-empresa']");
	public static final Target NUMERO_CUENTA = Target.the("numero de la cuenta")
			.locatedBy("//h2[@class='ng-tns-c21-3']/span[@class='ng-tns-c21-3']");

}
