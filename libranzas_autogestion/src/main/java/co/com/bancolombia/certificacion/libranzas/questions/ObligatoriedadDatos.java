package co.com.bancolombia.certificacion.libranzas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ObligatoriedadDatos implements Question<Boolean> {

    private Target nombre, idCliente, correo;

    public ObligatoriedadDatos(Target nombre, Target idCliente, Target correo) {

        this.nombre = nombre;
        this.idCliente = idCliente;
        this.correo = correo;

    }

    @Override
    public Boolean answeredBy(Actor arg0) {
        String strCadenaEsperada = "Campo requerido";

        if ((Text.of(nombre).viewedBy(arg0).value().contains(strCadenaEsperada))
                && ((Text.of(idCliente).viewedBy(arg0).value().contains(strCadenaEsperada))
                && ((Text.of(correo)).viewedBy(arg0).value().contains(strCadenaEsperada)))) {

            return true;

        } else {

            return false;

        }


    }

    public static ObligatoriedadDatos contingencia(Target nombre, Target idCliente, Target correo) {
        return new ObligatoriedadDatos(nombre, idCliente, correo);
    }

}

