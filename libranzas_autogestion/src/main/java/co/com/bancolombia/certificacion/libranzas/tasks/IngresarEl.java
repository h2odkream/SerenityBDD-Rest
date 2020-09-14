package co.com.bancolombia.certificacion.libranzas.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.targets.Target;

public class IngresarEl implements Task {

    private String strUsuario;
    private Target strCampoUsuario;

    public IngresarEl(String strUsuario, Target strCampoUsuario) {
        this.strUsuario = strUsuario;
        this.strCampoUsuario = strCampoUsuario;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(strUsuario).into(strCampoUsuario));

    }

    public static IngresarEl nombreDeUsuario(String strUsuario, Target strCampoUsuario) {
        return Tasks.instrumented(IngresarEl.class, strUsuario, strCampoUsuario);
    }
}
