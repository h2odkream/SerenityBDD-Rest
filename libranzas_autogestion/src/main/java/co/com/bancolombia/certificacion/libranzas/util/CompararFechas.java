package co.com.bancolombia.certificacion.libranzas.util;

import java.text.ParseException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.icu.text.SimpleDateFormat;

public class CompararFechas {

    private CompararFechas() {
        throw new IllegalStateException("Utility class");
    }


    public static String compararFechasConDate(String fechaBD, String fechaActual) {

        String resultado = "";
        try {
            SimpleDateFormat formateador = new SimpleDateFormat("yyyyMMdd");
            Date fechaDate1 = formateador.parse(fechaBD);
            Date fechaDate2 = formateador.parse(fechaActual);


            if (fechaDate2.before(fechaDate1)) {
                resultado = "menor";
            } else {
                resultado = "mayor o igual";
            }

        } catch (ParseException e) {
            e.getMessage();
        }
        return resultado;
    }

}
