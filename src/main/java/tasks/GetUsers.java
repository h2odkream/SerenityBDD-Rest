package tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsers implements Task {

    public final int page;

    public GetUsers(int page){
        this.page = page;
    }

    public static Performable fromPage(int page){
        return instrumented(GetUsers.class, page);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                /*recibe la pagina en la que se va hacer la peticion (la recibe en numero)
                 *Al request se le está agregando un tipo de contenido, una cabecera
                 */
                Get.resource("/users?page=" + page)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON)
                                .header("header1", "value1"))

        );
    }
}
