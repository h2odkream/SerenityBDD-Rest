package co.com.bancolombia.certificacion.libranzas.stepdefinitions;

import co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront;
import co.com.bancolombia.certificacion.libranzas.questions.NoSeVisualiza;
import co.com.bancolombia.certificacion.libranzas.tasks.Acceder;
import co.com.bancolombia.certificacion.libranzas.tasks.AutenticarseEn;
import co.com.bancolombia.certificacion.libranzas.tasks.IniciarLaAplicacion;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static co.com.bancolombia.certificacion.libranzas.exceptions.ErroresFront.ERROR_BANNER;
import static co.com.bancolombia.certificacion.libranzas.util.Urls.URL_LIBRANZAS_QA_EMMA;
import static java.util.concurrent.TimeUnit.SECONDS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.is;

public class SolicitarCreditoLibranzasSVPStepDefinitions {

    @Managed(driver = "chrome")
    private WebDriver elNavegador;

    @Before
    public void before() {
        setTheStage(new OnlineCast());

        elNavegador.manage().timeouts().implicitlyWait(50, SECONDS);
    }


    @Dado("^El cliente ingresa por la Sucursal Virtual Personas con el usuario '(.*)'$")
    public void elClienteIngresaPorLaSucursalVirtualPersonas(String usuario) {
        theActorCalled("Cliente").wasAbleTo(IniciarLaAplicacion.con(elNavegador, URL_LIBRANZAS_QA_EMMA),
                AutenticarseEn.qaConElUsuario(usuario), Acceder.desdeElBanner());
    }


    @Entonces("^podra ver el banner$")
    public void podraVerElBanner() {
        theActorInTheSpotlight()
                .should(seeThat(NoSeVisualiza.elBanner(), is(true)).orComplainWith(ErroresFront.class, ERROR_BANNER));
    }
}
