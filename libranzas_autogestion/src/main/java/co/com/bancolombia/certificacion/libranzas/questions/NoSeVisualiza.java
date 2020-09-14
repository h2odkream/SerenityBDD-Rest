package co.com.bancolombia.certificacion.libranzas.questions;

import co.com.bancolombia.certificacion.libranzas.userinterfaces.SVPPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class NoSeVisualiza implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoSeVisualiza.class);

    @Override
    public Boolean answeredBy(Actor actor) {

        try {
            BrowseTheWeb.as(actor).getDriver().switchTo().frame(SVPPage.FRAME_IFRM.resolveFor(actor));

            return SVPPage.BOTON_SOLICITALO_AQUI.resolveFor(actor).waitUntilVisible().isVisible();

        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return false;
        }
    }

    public static NoSeVisualiza elBanner() {
        return new NoSeVisualiza();
    }

}
