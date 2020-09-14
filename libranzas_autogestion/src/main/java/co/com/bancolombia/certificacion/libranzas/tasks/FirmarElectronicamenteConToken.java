package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasIseries;
import co.com.bancolombia.certificacion.libranzas.interactions.Esperar;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarDisponibilidad;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarInvisible;
import co.com.bancolombia.certificacion.libranzas.interactions.EsperarURL;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.DocumentosPage;
import co.com.bancolombia.certificacion.libranzas.models.ModelToken;
import co.com.bancolombia.certificacion.libranzas.util.CapturarFecha;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirmarElectronicamenteConToken implements Task {

    private static final Logger LOGGER = LoggerFactory.getLogger(FirmarElectronicamenteConToken.class);

    private String cedula;


    public FirmarElectronicamenteConToken(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(EsperarURL.deLaPantalla("documentos"));

        Boolean espera = DocumentosPage.CIRCULO_ESPERA.resolveFor(actor).isCurrentlyVisible();

        if (espera) {
            actor.attemptsTo(EsperarInvisible.elElemento(DocumentosPage.CIRCULO_ESPERA));
        }
        actor.attemptsTo(Esperar.segundos(10), EsperarDisponibilidad.delElemento(DocumentosPage.CHECK_ACEPTAR_CONDICIONES),
                Click.on(DocumentosPage.CHECK_ACEPTAR_CONDICIONES), EsperarInvisible.elElemento(DocumentosPage.CIRCULO_ESPERA), Esperar.segundos(13));

        ModelToken mt = RealizarConsultasIseries.extraerToken(CapturarFecha.FECHA_ACTUAL_SISTEMA, cedula);

        actor.attemptsTo(Enter.theValue(mt.getStrToken()).into(DocumentosPage.INGRESAR_CLAVE_DINAMICA),
                Click.on(DocumentosPage.BOTON_FINALIZAR));


    }

    public static FirmarElectronicamenteConToken elPagareYElSeguroDeVida(String cedula) {
        return Tasks.instrumented(FirmarElectronicamenteConToken.class, cedula);
    }

}
