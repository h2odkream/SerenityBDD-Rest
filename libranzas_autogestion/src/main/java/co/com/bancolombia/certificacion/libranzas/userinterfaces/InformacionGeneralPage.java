package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class InformacionGeneralPage extends PageObject {

	public static final Target FLECHA_PARA_DESPLEGAR_CUENTAS = Target
			.the("simbolo para desplegar las cuentas del usuario")
			.locatedBy("(//div[@class='account']//mat-form-field/div/div/div)[1]/mat-select");
	public static final Target CUENTA_EN_LISTA = Target.the("cuenta en lista ")
			.locatedBy("//mat-option/span[contains(text(), '{0}')]");
	public static final Target BOTON_CONTINUAR_CONFIRMACION = Target
			.the("boton para continuar a la pantalla de documentos")
			.locatedBy("//div[@class='next-action text-center btn-two']/button[2]");
	public static final Target BOTON_ATRAS_CONFIRMACION = Target.the("boton para devolverse a la pantalla de oferta")
			.locatedBy("//div[@class='next-action text-center btn-two']/button[1]");

}
