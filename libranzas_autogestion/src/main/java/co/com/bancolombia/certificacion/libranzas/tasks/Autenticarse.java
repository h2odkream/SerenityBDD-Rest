package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.userinterfaces.AutenticacionOauthPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Autenticarse implements Task {

	private String usuario;

	public Autenticarse(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(IngresarEl.nombreDeUsuario(usuario, AutenticacionOauthPage.USUARIO_OAUTH), Click.on(AutenticacionOauthPage.BOTON_CONTINUAR),
				IngresarLa.clave(AutenticacionOauthPage.CLAVE).enEl(AutenticacionOauthPage.CAMPO_CLAVE), Click.on(AutenticacionOauthPage.BOTON_CONTINUAR));
	}

	public static Autenticarse porOauthConElUsuario(String usuario) {
		return Tasks.instrumented(Autenticarse.class, usuario);
	}

}
