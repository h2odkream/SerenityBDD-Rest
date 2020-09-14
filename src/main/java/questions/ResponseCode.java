package questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCode implements Question {

    public static Question<Integer> was(){
        return new ResponseCode();
    }

    @Override
    public Object answeredBy(Actor actor) {
         //si la peticion es un exito, debe responder 200 (en postman es e status ok)
        return SerenityRest.lastResponse().statusCode();
    }
}
