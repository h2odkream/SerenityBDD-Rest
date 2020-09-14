package co.com.bancolombia.certificacion.libranzas.stepdefinitions;

import co.com.bancolombia.certificacion.libranzas.exceptions.ElSaldoNoTieneDiferencia;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.models.Credito;
import co.com.bancolombia.certificacion.libranzas.questions.ValidarLosSaldos;
import co.com.bancolombia.certificacion.libranzas.tasks.FirmarElectronicamenteConClaveDinamica;
import co.com.bancolombia.certificacion.libranzas.tasks.SolicitarUnCredito;

import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static co.com.bancolombia.certificacion.libranzas.exceptions.ElSaldoNoTieneDiferencia.SALDO_NO_MODIFICADO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class SolicitarCreditoLibranzaGeneralStepDefinitions {

    @Cuando("^empieza la solicitud de un credito de libranza con los datos$")
    public void solicitaUnCreditoDeLibranzaConLosDatos(List<Credito> credito) {

        theActorInTheSpotlight().attemptsTo(SolicitarUnCredito.conLosDatosDel(credito.get(0)));

    }

    @Cuando("^firma electronicamente los documentos con la OTP y cedula '(.*)'$")
    public void firmaElectronicamenteLosDocumentosConLaOTPYCedula(String cedula) {
        theActorInTheSpotlight().attemptsTo(FirmarElectronicamenteConClaveDinamica.elPagareYElSeguroDeVida(cedula));
    }

    @Entonces("^podra ver la pantalla de confirmacion del credito desembolsado en su cuenta$")
    public void podraVerLaPantallaDeConfirmacionDelCreditoDesembolsadoEnSuCuenta(List<Credito> credito) {
        theActorInTheSpotlight().attemptsTo(
                EsperarURL.deLaPantalla("finalizacion"));

        theActorInTheSpotlight().should(
                seeThat(ValidarLosSaldos.despuesDelDesembolso(credito.get(0)), equalTo(true))
                        .orComplainWith(ElSaldoNoTieneDiferencia.class, SALDO_NO_MODIFICADO));


    }




}
