package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class OfertaPage extends PageObject {

	public static final Target PROGRESO_CREDITO=Target.the("barra de progreso").locatedBy("//div[@class='container progress-form']");

	// TARGET'S MONTO
	public static final Target MONTO_INGRESAR = Target.the("campo donde se escribe el monto deseado")
			.locatedBy("//input[@name='montoOfertaInt']");
	public static final Target BOTON_MENOS_MONTO = Target.the("boton con el simbolo menos para el monto")
			.locatedBy("(//em[@class='fal fa-minus'])[1]");
	public static final Target BOTON_MAS_MONTO = Target.the("Botón con el simbolo mas para el monto")
			.locatedBy("(//em[@class='fal fa-plus inactive'])[1]");
	public static final Target MENSAJE_ABAJO_MONTO = Target
			.the("mensaje donde advierte cuanto es el monto minimo y máximo").locatedBy("(//small)[1]");

	// TARGET'S MESES
	public static final Target MESES = Target.the("donde esta los meses disponibles para pagar")
			.locatedBy("//input[@name='arrayPlazos']");
	public static final Target BOTON_MENOS_MESES = Target.the("boton con el simbolo menos para los meses de plazo")
			.locatedBy("(//em[@class='fal fa-minus'])[2]");
	public static final Target BOTON_MAS_MESES = Target.the("Botón con el simbolo mas para los meses de plazo")
			.locatedBy("(//em[@class='fal fa-plus inactive'])[2]");
	public static final Target MENSAJE_ABAJO_MESES = Target
			.the("mensaje donde advierte cuanto es el plazo minimo y máximo")
			.locatedBy("(//small)[2]");

	//CARDS NUEVAS

	//CARD SEGURO DE VIDA

	public static final Target CUOTA_CARD = Target.the("cuota del credito con seguro de vida")
			.locatedBy("(//div[@class='custom-padding']/h4)[1]");
	public static final Target TASA_MV = Target.the("tasa mes vencida en la card")
			.locatedBy("(//div[@class='custom-margin mb-3']/h2)[1]");

	public static final Target PUNTOS_DTF = Target.the("puntos dtf")
			.locatedBy("(//div[@class='custom-margin mb-3']/h6)[1]");

	public static final Target SEGURO_VIDA = Target.the("seguro de vida")
			.locatedBy("(//div[@class='custom-margin mb-3']/h2)[2]");

	public static final Target BOTON_LOQUIERO = Target.the("botón para elegir la card y continuar la experiencia.")
			.locatedBy("(//div[@class='custom-padding']/button[@class='btn btn-primary btn-white col-sm-12'])[1]");




	//CARD SEGURO DESEMPLEO
	public static final Target CUOTA_CARD_SD = Target.the("cuota del credito con seguro de vida")
			.locatedBy("(//div[@class='custom-padding']/h4)[2]");
	public static final Target TASA_MV_SD = Target.the("tasa mes vencida en la card")
			.locatedBy("(//div[@class='custom-margin mb-3']/h2)[3]");

	public static final Target PUNTOS_DTF_SD = Target.the("puntos dtf")
			.locatedBy("(//div[@class='custom-margin mb-3']/h6)[2]");

	public static final Target SEGURO_VIDA_SD = Target.the("seguro de vida")
			.locatedBy("(//div[@class='custom-margin mb-3']/h2)[4]");

	public static final Target SEGURO_DESEMPLEO=Target.the("valor de seguro de desempleo")
			.locatedBy("(//div[@class='custom-margin mb-3']/h2)[5]");

	public static final Target BOTON_LOQUIERO_SD = Target.the("botón para elegir la card y continuar la experiencia.")
			.locatedBy("(//div[@class='custom-padding']/button[@class='btn btn-primary btn-white col-sm-12'])[2]");


}
