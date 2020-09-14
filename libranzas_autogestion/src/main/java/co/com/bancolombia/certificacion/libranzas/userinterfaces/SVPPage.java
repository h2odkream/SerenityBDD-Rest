package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class SVPPage extends PageObject{

	public static final Target BOTON_SOLICITALO_AQUI = Target.the("Botón solicítalo aquí")
			.locatedBy("//*[@id='btnGoToPortal']");
	public static final Target TXT_VALOR_DEL_PREAPROBADO = Target.the("Valor del preaprobado en el banner")
			.locatedBy("//label[@id='msgProductSelected']");
	public static final Target FRAME_IFRM = Target.the("Frame").locatedBy("//iframe[@name='ifrm']");
	public static final Target BOTON_PRODUCTOS = Target.the("Botón Productos")
			.locatedBy("(//a[@class=\"item_firt_level_menu has-submenu\"])[1]");
	public static final Target BOTON_CONSULTAR_CREDITOS = Target.the("Botón Consultar créditos")
			.locatedBy("//a[@id=\"link_prod_ccr\"]");
	public static final Target MENSAJE_ERROR_AUTENTICACION = Target.the("error al equivocarse de credenciales")
			.locatedBy("//div[@id='summary']");
	public static final Target MENSAJE_CUENTA_BLOQUEADA_SVP = Target.the("error al tener la clave bloqueada")
			.locatedBy("//div[@class='mua-modal-body']//div[@id='summary']");
	public static final Target NUMERO_CREDITO = Target.the("número crédito")
			.locatedBy("//*[@id=\"CH_54966030078600\"]/td[4]/a");
	public static final Target LISTA_CREDITOS = Target.the("lista de creditos")
			.locatedBy("(//table[@id='gridProductID_credits']/tbody/tr/td/a");
	public static final Target NUMERO_PRESTAMO_SVP = Target.the("numero del prestamo")
			.locatedBy("//table[@id='gridProductID_credits']/descendant::a[contains(text(),'6004001144')]");
	public static final Target IMAGEN_CARGA_SVP = Target.the("imagen de carga")
			.locatedBy("//*[@id=\"loading-indicator-undefined\"]/div/img");

}
