import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.ResponseCode;
import tasks.GetUsers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

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

        /*si la peticion es un exito, debe responder 200 (en postman es e status ok)
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        0
       assertThat(ResponseCode.was()).isEqualTo(200);
       */
        Karen.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo(200))
        );
    }

}
