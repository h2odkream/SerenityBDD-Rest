package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.userinterfaces.AutenticacionQa3Page;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class AutenticarseEn implements Task {

	private String usuario;

	public AutenticarseEn(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(IngresarEl.nombreDeUsuario(usuario, AutenticacionQa3Page.TXT_USUARIO), Click.on(AutenticacionQa3Page.BOTON_CONTINUAR),
				IngresarLa.clave(AutenticacionQa3Page.CLAVE).enEl(AutenticacionQa3Page.CAMPO_CLAVE), Click.on(AutenticacionQa3Page.BOTON_INGRESAR));

	}

	public static AutenticarseEn qaConElUsuario(String usuario) {
		return Tasks.instrumented(AutenticarseEn.class, usuario);
	}

}
