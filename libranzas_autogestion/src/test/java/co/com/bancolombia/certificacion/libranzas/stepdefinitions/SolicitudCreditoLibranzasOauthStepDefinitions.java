package co.com.bancolombia.certificacion.libranzas.stepdefinitions;

import co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront;
import co.com.bancolombia.certificacion.libranzas.questions.ElErrorDeAutenticacion;
import co.com.bancolombia.certificacion.libranzas.tasks.Autenticarse;
import co.com.bancolombia.certificacion.libranzas.tasks.AutenticarseIncorrectamente;
import co.com.bancolombia.certificacion.libranzas.tasks.IniciarLaAplicacion;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront.ERROR_AUTENTICACION_USUARIO_BLOQUEADO;
import static co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront.ERROR_AUTENTICACION_USUARIO_CLAVE_INCORRECTA;
import static co.com.bancolombia.certificacion.libranzas.userinterfaces.ErroresOauthPage.ERROR_AUTENTICACION;
import static co.com.bancolombia.certificacion.libranzas.util.Urls.URL_LIBRANZAS_OAUTH;
import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.containsString;

public class SolicitudCreditoLibranzasOauthStepDefinitions {
    @Managed(driver = "chrome")
    private WebDriver elNavegador;

    @Before
    public void before() {
        setTheStage(new OnlineCast());
        elNavegador.manage().timeouts().implicitlyWait(50, SECONDS);
    }

    @Dado("^que el cliente ingresa por oauth con el usuario '(.*)'$")
    public void elClienteIngresaPorOauthConElUsuario(String usuario) {
        theActorCalled(usuario).attemptsTo(IniciarLaAplicacion.con(elNavegador, URL_LIBRANZAS_OAUTH),
                Autenticarse.porOauthConElUsuario(usuario));
    }

    @Dado("^el cliente se autentica por Oauth con  el usuario '(.*)' que tiene credenciales incorrectas$")
    public void elClienteSeAutenticaPorOauthConElUsuarioPLIBRANZAQueTieneCredencialesIncorrectas(String usuario) {
        theActorCalled(usuario).attemptsTo(IniciarLaAplicacion.con(elNavegador, URL_LIBRANZAS_OAUTH),
                AutenticarseIncorrectamente.porOauthConElUsuario(usuario));
    }

    @Entonces("^Aparece en autenticacion el error '(.*)'$")
    public void apareceEnAutenticacionElErrorUsuarioYOClave(String errorAutenticacion) {
        theActorInTheSpotlight().should(
                seeThat(ElErrorDeAutenticacion.dePantalla(ERROR_AUTENTICACION), containsString(errorAutenticacion))
                        .orComplainWith(ErroresFront.class, ERROR_AUTENTICACION_USUARIO_CLAVE_INCORRECTA));
    }

    @Entonces("^Aparece el error '(.*)'$")
    public void apareceElErrorTuClaveSeEncuentraBloqueada(String errorAutenticacion) {
        theActorInTheSpotlight().should(
                seeThat(ElErrorDeAutenticacion.dePantalla(ERROR_AUTENTICACION), containsString(errorAutenticacion))
                        .orComplainWith(ErroresFront.class, ERROR_AUTENTICACION_USUARIO_BLOQUEADO));
    }

}
