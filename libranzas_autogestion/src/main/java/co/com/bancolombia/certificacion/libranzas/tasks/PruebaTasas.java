package co.com.bancolombia.certificacion.libranzas.tasks;

import co.com.bancolombia.certificacion.libranzas.models.TasasLibranzas;
import co.com.bancolombia.certificacion.libranzas.util.CalculoDeLaCuota;
import co.com.bancolombia.certificacion.libranzas.util.ConexionTasas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.sql.SQLException;

public class PruebaTasas implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {


        try {

            TasasLibranzas.consultar(ConexionTasas.conCredenciales().llamandoAlProcedimiento("BIZ", "NULL",
                    "D34", "S2", "G5", 1000000, 96), 96, 1000000);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static PruebaTasas jeje(){
        return Tasks.instrumented(PruebaTasas.class);
    }
}
