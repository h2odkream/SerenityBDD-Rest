package co.com.bancolombia.certificacion.libranzas.stepdefinitions;

import co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront;
import co.com.bancolombia.certificacion.libranzas.questions.ElErrorDeAutenticacion;
import co.com.bancolombia.certificacion.libranzas.tasks.*;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;

import static co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront.CODIGO_TOKEN_INCORRECTO;
import static co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront.ERROR_TOKEN_INCORRECTO;
import static co.com.bancolombia.certificacion.libranzas.userinterfaces.AutenticacionOauthPage.CODIGO_ERROR;
import static co.com.bancolombia.certificacion.libranzas.userinterfaces.AutenticacionOauthPage.MENSAJE_ERROR;
import static co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage.CODIGO_ERROR_TOKEN;
import static co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage.MENSAJE_ERROR_TOKEN;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class SolicitudCreditoLibranzaSinClaveDinamicaStepDefinitions {


	@Entonces("^en la pantalla de autenticacion se visualiza una alerta con el mensaje '(.*)' y el codigo de error '(.*)'$")
	public void enLaPantallaDeAutenticacionSeVisualizaUnaAlertaConElMensajeYElCodigoDeError(String mensaje,
																							String codigoError) {
		theActorInTheSpotlight().should(seeThat(ElErrorDeAutenticacion.dePantalla(MENSAJE_ERROR), equalTo(mensaje)),
				seeThat(ElErrorDeAutenticacion.dePantalla(CODIGO_ERROR), equalTo(codigoError)));
		theActorInTheSpotlight().attemptsTo(CerrarError.popup());
	}

	@Cuando("^genera el token (.*) veces en la pantalla de documentos$")
	public void generaElTokenIntentosEnPantallaDocumentos(int intentos) {
		theActorInTheSpotlight().attemptsTo(Diligenciar.laOferta(), Declarar.queAceptaCondicionesPagare(), GenerarToken.variasVeces(intentos));
	}

	@Entonces("^se visualiza una alerta con el mensaje '(.*)' y el codigo de error '(.*)'$")
	public void seVisualizaUnaAlertaConElMensajeYElCodigoDeError(String mensaje, String codigoError) {
		theActorInTheSpotlight().should(
				seeThat(ElErrorDeAutenticacion.dePantalla(MENSAJE_ERROR_TOKEN), containsString(mensaje))
						.orComplainWith(ErroresFront.class, ERROR_TOKEN_INCORRECTO),
				seeThat(ElErrorDeAutenticacion.dePantalla(CODIGO_ERROR_TOKEN), containsString(codigoError))
						.orComplainWith(ErroresFront.class, CODIGO_TOKEN_INCORRECTO));

	}

	@Cuando("^ingresa el token expirado de la cedula '(.*)'$")
	public void ingresaElTokenExpirado(String cedula) {
		theActorInTheSpotlight().attemptsTo(FirmarElectronicamenteConToken.elPagareYElSeguroDeVida(cedula), EsperarExpiracion.token());
	}

	@Cuando("^ingresa el token con intentos fallidos$")
	public void ingresaElTokenConIntentosFallidos() {
		theActorInTheSpotlight().attemptsTo(IngresarElToken.incorrecto());
	}

	@Cuando("^ingresa el token incorrecto$")
	public void ingresaElTokenIncorrecto() {
		theActorInTheSpotlight().attemptsTo(IngresarToken.incorrecto());
	}

	@Cuando("^firma los documentos con el token y cedula '(.*)'$")
	public void firmaLosDocumentosConElToken(String cedula) {
		theActorInTheSpotlight().attemptsTo(FirmarElectronicamenteConToken.elPagareYElSeguroDeVida(cedula));
	}

	@Cuando("^esta en la pantalla de documentos$")
	public void estaEnLaPantallaDeDocumentos() {
		theActorInTheSpotlight().attemptsTo(Diligenciar.laOferta(), Declarar.queAceptaCondicionesPagare());
	}
}
