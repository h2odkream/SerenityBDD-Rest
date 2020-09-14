package co.com.bancolombia.certificacion.libranzas.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class IngresarLa implements Task {

	private Target strClaveTarget, strCampoClave;

	private String strClave = "1234";

	public IngresarLa(Target strClaveTarget) {
		this.strClaveTarget = strClaveTarget;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		char[] numbers = strClave.toCharArray();

		String strPrimerDigito = String.valueOf(numbers[0]);
		String strSegundoDigito = String.valueOf(numbers[1]);
		String strTercerDigito = String.valueOf(numbers[2]);
		String strCuartoDigito = String.valueOf(numbers[3]);

		actor.attemptsTo(Click.on(strClaveTarget.of(strPrimerDigito)), Click.on(strCampoClave),
				Click.on(strClaveTarget.of(strSegundoDigito)), Click.on(strCampoClave), Click.on(strClaveTarget.of(strTercerDigito)),
				Click.on(strCampoClave), Click.on(strClaveTarget.of(strCuartoDigito)));
	}

	public static IngresarLa clave(Target strClave) {
		return Tasks.instrumented(IngresarLa.class, strClave);
	}

	public IngresarLa enEl(Target strCampoClave) {
		this.strCampoClave = strCampoClave;
		return this;
	}
}