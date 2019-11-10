import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class SerenityInitialTest {

    private static final String restApiUrl = "http://localhost:5000/api";

    @Test
    public void getUsers(){
        //Creamos el actor que tendra la habilidad de poder comunicarse a traves de la api on la url
        Actor Karen = Actor.named("Karen the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        Karen.attemptsTo(
            GetUsers.fromPage(2) //deme los usuarios de la panina 2
        );

        //si la peticion es un exito, debe responder 200 (en postman es e status ok)
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
    }

}
