package co.com.bancolombia.certificacion.libranzas.stepdefinitions;

import co.com.bancolombia.certificacion.libranzas.questions.AlFinalizarLaExperiencia;
import co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.models.Credito;
import co.com.bancolombia.certificacion.libranzas.tasks.Autenticarse;
import co.com.bancolombia.certificacion.libranzas.tasks.FirmarElectronicamenteConClaveDinamica;
import co.com.bancolombia.certificacion.libranzas.tasks.IniciarLaAplicacion;
import co.com.bancolombia.certificacion.libranzas.tasks.SolicitandoCreditoMonitoreo;
import cucumber.api.java.ast.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront.URL_ACTUAL_DIFERENTE;
import static co.com.bancolombia.certificacion.libranzas.util.Urls.URL_LIBRANZAS_OAUTH;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

public class MonitoreoStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver elNavegador;


    @Dado("^que el cliente (.*) esta en la pantalla de Bienvenida monitoreo$")
    public void queElClienteEstaEnLaPantallaDeBienvenidaMonitoreo(String usuario) throws Exception {
        theActorCalled(usuario).attemptsTo(IniciarLaAplicacion.con(elNavegador, URL_LIBRANZAS_OAUTH),
                Autenticarse.porOauthConElUsuario(usuario));
    }


    @Cuando("^solicita un credito con los datos monitoreo$")
    public void solicitaUnCreditoConLosDatosMonitoreo(List<Credito> credito) throws Exception {
        theActorInTheSpotlight().attemptsTo(SolicitandoCreditoMonitoreo.conLosDatos(credito.get(0)));

    }

    @Cuando("^firma electronicamente los documentos monitoreo$")
    public void firmaElectronicamenteLosDocumentosMonitoreo(String cedula)  {
        theActorInTheSpotlight().attemptsTo(FirmarElectronicamenteConClaveDinamica.elPagareYElSeguroDeVida(cedula));
    }


    @Entonces("^podra ver la pantalla de (.*) del credito desembolsado en su cuenta monitoreo$")
    public void podraVerLaPantallaDeConfirmacionDelCreditoDesembolsadoEnSuCuentaMonitoreo(String pagina) {
        theActorInTheSpotlight().attemptsTo(EsperarURL.deLaPantalla(pagina));
        theActorInTheSpotlight().should(GivenWhenThen.seeThat(AlFinalizarLaExperiencia.laURLQueMuestra(), containsString(pagina))
                .orComplainWith(ErroresFront.class, URL_ACTUAL_DIFERENTE));


    }


}
