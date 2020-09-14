package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.exceptions.CuotaErronea;
import co.com.bancolombia.certificacion.libranzas.exceptions.TasasErroneas;
import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarDisponibilidad;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarVisible;
import co.com.bancolombia.certificacion.libranzas.models.Credito;
import co.com.bancolombia.certificacion.libranzas.models.ModelSciffsaldo;
import co.com.bancolombia.certificacion.libranzas.models.ModelXcrl;
import co.com.bancolombia.certificacion.libranzas.questions.ValidarCuotaNormal;
import co.com.bancolombia.certificacion.libranzas.questions.ValidarTasasNormal;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.InformacionGeneralPage;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.OfertaPage;
import co.com.bancolombia.certificacion.libranzas.questions.ValidarCuotaSeguroDesempleo;
import co.com.bancolombia.certificacion.libranzas.questions.ValidarTasasSeguroDesempleo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.Attribute;

import static co.com.bancolombia.certificacion.libranzas.util.CapturarDatosIniciales.capturarLimitesInicial;
import static co.com.bancolombia.certificacion.libranzas.util.CapturarDatosIniciales.capturarSaldoInicial;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class SolicitarUnCredito implements Task {

    private Credito credito;

    public static ModelXcrl xcr1;
    public static ModelSciffsaldo sciff;

    public SolicitarUnCredito(Credito credito) {
        this.credito = credito;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        int mesesPlazoModel = Integer.parseInt(credito.getPlazo());
        int montoParaTasas = Integer.parseInt(credito.getMonto());
        actor.attemptsTo(EmpezarExperiencia.deLibranza(), EsperarURL.deLaPantalla("oferta"));

       
        actor.attemptsTo(Esperar.segundos(80),
                EsperarDisponibilidad.delElemento(OfertaPage.MONTO_INGRESAR),
                Enter.theValue(credito.getMonto()).into(OfertaPage.MONTO_INGRESAR),
                EsperarDisponibilidad.delElemento(OfertaPage.MENSAJE_ABAJO_MESES),
                Click.on(OfertaPage.MENSAJE_ABAJO_MESES),
                EsperarVisible.elElemento(OfertaPage.CUOTA_CARD), Esperar.segundos(10));


        String[] mesesPlazoVec = Attribute.of(OfertaPage.MESES).named("placeholder").viewedBy(actor).asString().split("m");
        int mesesPlazoFront = Integer.parseInt(mesesPlazoVec[0].trim());

        if (mesesPlazoModel != mesesPlazoFront) {
            do {
                actor.attemptsTo(Scroll.to(OfertaPage.PROGRESO_CREDITO), Esperar.segundos(10), EsperarDisponibilidad.delElemento(OfertaPage.BOTON_MENOS_MESES), Click.on(OfertaPage.BOTON_MENOS_MESES), Esperar.segundos(10));
                mesesPlazoVec = Attribute.of(OfertaPage.MESES).named("placeholder").viewedBy(actor).asString().split("m");
                mesesPlazoFront = Integer.parseInt(mesesPlazoVec[0].trim());
            } while (mesesPlazoFront > mesesPlazoModel && mesesPlazoFront != mesesPlazoModel);
        }


        if (!credito.getTipoDesembolso().equals("seguroDesempleo")) {


            actor.should(GivenWhenThen.seeThat(ValidarTasasNormal.conElCanal("BIZ").elPlanTasaFija("NULL").laTasaVariable("D82")
                    .elSegmento(credito.getSegmentoDeTasas()).elGrupoRiesgo(credito.getGrupoDeRiesgo())
                    .elMonto(montoParaTasas).elPlazo(mesesPlazoModel), equalTo(true))
                    .orComplainWith(TasasErroneas.class, TasasErroneas.CALCULO_TASAS_INCORRECTA));


            actor.should(GivenWhenThen.seeThat(ValidarCuotaNormal.delCalculoYElFront(mesesPlazoModel, credito.getMonto()), equalTo(true))
                    .orComplainWith(CuotaErronea.class, CuotaErronea.ERROR_CUOTA));

            actor.attemptsTo(Esperar.segundos(10), Click.on(OfertaPage.BOTON_LOQUIERO));


        } else {

            actor.should(seeThat(ValidarTasasSeguroDesempleo.conElCanal("BIZ").elPlanTasaFija("NULL").laTasaVariable("D34")
                    .elSegmento(credito.getSegmentoDeTasas()).elGrupoRiesgo(credito.getGrupoDeRiesgo())
                    .elMonto(montoParaTasas).elPlazo(mesesPlazoModel), equalTo(true))
                    .orComplainWith(TasasErroneas.class, TasasErroneas.CALCULO_TASAS_INCORRECTA));


            actor.should(seeThat(ValidarCuotaSeguroDesempleo.conElCalculoYElFront(mesesPlazoModel, credito.getMonto()), equalTo(true))
                    .orComplainWith(CuotaErronea.class, CuotaErronea.ERROR_CUOTA));

            actor.attemptsTo(Esperar.segundos(10), Click.on(OfertaPage.BOTON_LOQUIERO_SD));


        }


        actor.attemptsTo(EsperarURL.deLaPantalla("confirmacion"), Esperar.segundos(20),
                Click.on(InformacionGeneralPage.FLECHA_PARA_DESPLEGAR_CUENTAS), Esperar.segundos(5),
                Click.on(InformacionGeneralPage.CUENTA_EN_LISTA.of(credito.getCuenta())), Click.on(InformacionGeneralPage.BOTON_CONTINUAR_CONFIRMACION));


        xcr1 = capturarLimitesInicial(credito.getCedula());


        sciff = capturarSaldoInicial(credito.getCta());



    }


  //  }

    public static SolicitarUnCredito conLosDatosDel(Credito credito) {
        return Tasks.instrumented(SolicitarUnCredito.class, credito);
    }
}
