package co.com.bancolombia.certificacion.libranzas.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class DashboardPage extends PageObject {

	public static final Target NOMBRE_CLIENTE_DASHBOARD = Target.the("Cliente del usuario en el dashboard")
			.locatedBy("//div[@class='col-xs-12 col-sm-6 mt10']/h1");
	public static final Target NUMERO_CASO = Target.the("Numero de caso")
			.locatedBy("//*[@class='text-xs ng-binding']");
	public static final Target FECHA_SOLICITUD = Target.the("Fecha de solicitud")
			.locatedBy("//*[@class='pull-right text-xs font-size18 xs16 xs-mt20 xs-pull-right ng-binding']");
	public static final Target SOLICITUD_REALIZADA = Target.the("Boton solicitud realizada")
			.locatedBy("//*[@class='linkStateProgress  pointer']");

}
