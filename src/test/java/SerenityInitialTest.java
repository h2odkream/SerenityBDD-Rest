import model.users.Datum;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.GetUsersQuestion;
import questions.ResponseCode;
import tasks.GetUsers;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SerenityRunner.class)
public class SerenityInitialTest {

    private static final String restApiUrl = "http://localhost:5000/api";

    @Test
    public void getUsers(){
        //Creamos el actor que tendra la habilidad de poder comunicarse a traves de la api en la url
        Actor Karen = Actor.named("Karen the trainer")
                .whoCan(CallAnApi.at(restApiUrl));

        //Karen hace la peticion
        Karen.attemptsTo(
            GetUsers.fromPage(1) //deme los usuarios de la pagina 1
        );

        /*si la peticion es un exito, debe responder 200 (en postman es status ok)
        assertThat(SerenityRest.lastResponse().statusCode()).isEqualTo(200);
        0
       assertThat(ResponseCode.was()).isEqualTo(200);
       Valida que el codigo sea 200
       */
        Karen.should(
                seeThat("El codigo de respuesta", ResponseCode.was(), equalTo(200))
        );

        /*Va acceder a todas sus propiedades, sobre el question que nos retorna la data,
         hace un filtro haciendo el stream de java donde el id=1
         o
         Devuelve un null
         */
        Datum user =new GetUsersQuestion().answeredBy(Karen)
                .getData().stream().filter(x -> x.getId()==1).findFirst().orElse(null);

        /*Usando una expresion lambda convertimos en question
        Si el usuario es null
         */
        Karen.should(
                seeThat("Usuario no es nulo", act -> user, notNullValue())
        );

        /*Si el usuario no es null y el  id==1
            valida si ese es el email
            Podemos hacer varias validaciones
         */
        Karen.should(
                seeThat("El email del usuario", act -> user.getEmail(), equalTo("george.bluth@reqres.in")),
                //seeThat("El email del usuario", act -> user.getFirstName(), equalTo("George")),
                seeThat("El avatar del usuario", act -> user.getAvatar(), equalTo("https://s3.amazonaws.com/uifaces/faces/twitter/calebogden/128.jpg"))
                //seeThat("El primer apellido del usuario", act -> user.getLastName(), equalTo("Bluth"))
        );
    }

}
