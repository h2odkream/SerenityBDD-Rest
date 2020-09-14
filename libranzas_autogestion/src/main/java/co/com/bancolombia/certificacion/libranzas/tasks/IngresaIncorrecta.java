package co.com.bancolombia.certificacion.libranzas.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class IngresaIncorrecta  implements Task{
	
	private Target strClave, strCampoClave;

	public IngresaIncorrecta(Target strClave) {
		this.strClave = strClave;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Click.on(strClave.of("4")),
						 Click.on(strCampoClave),
						 Click.on(strClave.of("2")),
						 Click.on(strCampoClave),
						 Click.on(strClave.of("7")),
						 Click.on(strCampoClave),
						 Click.on(strClave.of("4")));
	}

	public static IngresaIncorrecta clave(Target strClave) {
		return Tasks.instrumented(IngresaIncorrecta.class, strClave);
	}

	public IngresaIncorrecta enEl(Target strCampoClave) {
		this.strCampoClave = strCampoClave;
		return this;
	}

}
