package co.com.bancolombia.certificacion.libranzas.questions;


import co.com.bancolombia.certificacion.libranzas.models.TasasLibranzas;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.OfertaPage;
import co.com.bancolombia.certificacion.libranzas.util.ConexionTasas;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class ValidarTasasSeguroDesempleo implements Question<Boolean> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ValidarTasasSeguroDesempleo.class);

    private String canal, plan, planTasaVariable, segmento, grupoRiesgo;
    private int monto, plazo;

    public static double tasaMesVencidaBDTasasAntesDe;

    private double tasaNominalAnualMV;
    private double puntosDTF;


    public ValidarTasasSeguroDesempleo(String canal) {
        this.canal = canal;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        try {

            LOGGER.info("============================PUNTOS DTF========================");
            String strPuntosDtfFront = Text.of(OfertaPage.PUNTOS_DTF_SD).viewedBy(actor).value();
            String[] strPuntosDTF1 = strPuntosDtfFront.split("\\+");
            String[] strPuntosDTF2 = strPuntosDTF1[1].split("p");
            String strPuntosDTF = strPuntosDTF2[0];
            puntosDTF = Double.parseDouble(strPuntosDTF.trim());
            LOGGER.info("PUNTOS DTF: " + puntosDTF);
            LOGGER.info("=============================================================================");


            LOGGER.info("============================TASA NOMINAL MES VENCIDA ========================");
            String strTasaNominalMesVencidaCompleta = Text.of(OfertaPage.TASA_MV_SD).viewedBy(actor).value();
            String[] tasaNominalMV2 = strTasaNominalMesVencidaCompleta.split("\\%");
            String strTasaNominalMVNumero = tasaNominalMV2[0].trim();
            tasaNominalAnualMV = Double.parseDouble(strTasaNominalMVNumero);
            LOGGER.info("TASA NOMINAL MES VENCIDA N: " + tasaNominalAnualMV);
            LOGGER.info("=============================================================================");


            TasasLibranzas.consultar(ConexionTasas.conCredenciales().llamandoAlProcedimiento(canal, plan,
                    planTasaVariable, segmento, grupoRiesgo, monto, plazo), plazo, monto);

            LOGGER.info("DTF: " + TasasLibranzas.getTasaDTF());
            LOGGER.info("PUNTOS: " + TasasLibranzas.getPuntosTa());
            LOGGER.info(" TASA MORA: " + TasasLibranzas.getTasaMora());
            LOGGER.info(" TASA EFECTIVA ANUAL: " + TasasLibranzas.getTasaEfectivaAnual());
            LOGGER.info(" TASA MES VENCIDA: " + TasasLibranzas.getTasaMesVencida());

            tasaMesVencidaBDTasasAntesDe = TasasLibranzas.getTasaMesVencida();


            String puntosDosDigitos = String.format("%.2f", TasasLibranzas.getPuntosTa());
            String puntosDosDigitosSinComa = puntosDosDigitos.replaceAll("\\,", "\\.").trim();
            Double puntosNumeros = Double.parseDouble(puntosDosDigitosSinComa);

            int comparacionPuntosTasaVariable = Double.compare(puntosDTF, puntosNumeros);
            int comparacionTasaMesVencida = Double.compare(tasaNominalAnualMV, TasasLibranzas.getTasaMesVencida());


            if (comparacionPuntosTasaVariable == 0 || comparacionPuntosTasaVariable == 1 && comparacionTasaMesVencida == 0) {
                return true;
            }

        } catch (SQLException e) {
            LOGGER.info(e.getMessage());

        }

        return false;
    }

    public static ValidarTasasSeguroDesempleo conElCanal(String canal) {
        return new ValidarTasasSeguroDesempleo(canal);
    }

    public ValidarTasasSeguroDesempleo elPlanTasaFija(String plan) {
        this.plan = plan;
        return this;
    }

    public ValidarTasasSeguroDesempleo laTasaVariable(String planTasaVariable) {
        this.planTasaVariable = planTasaVariable;
        return this;
    }

    public ValidarTasasSeguroDesempleo elSegmento(String segmento) {
        this.segmento = segmento;
        return this;
    }

    public ValidarTasasSeguroDesempleo elGrupoRiesgo(String grupoRiesgo) {
        this.grupoRiesgo = grupoRiesgo;
        return this;
    }

    public ValidarTasasSeguroDesempleo elMonto(int monto) {
        this.monto = monto;
        return this;
    }

    public ValidarTasasSeguroDesempleo elPlazo(int plazo) {
        this.plazo = plazo;
        return this;
    }

}
