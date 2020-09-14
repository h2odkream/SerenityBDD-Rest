package co.com.bancolombia.certificacion.libranzas.questions;

import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultaPreaprobados;
import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasBizagi;
import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasIseries;
import co.com.bancolombia.certificacion.libranzas.models.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LasValidacionesDelDesembolso implements Question<Boolean> {

    private Credito credito;

    public LasValidacionesDelDesembolso(Credito credito) {
        this.credito = credito;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        String strIndicadorReversoCorrecto = "N";

        ModelBizagi mb = RealizarConsultasBizagi.consultarBIZAGIDespuesDelDesembolso(credito.getCedula());


        ModelXlogsrv mx = RealizarConsultasIseries.consultarXLOGSRVDespuesDelDesembolso(credito.getCedula());

        ModelPreaprobados mp = RealizarConsultaPreaprobados
                .consultaPreaprobadoDespuesDelDesembolso(credito.getCedula());

        ModelLmbal ml = RealizarConsultasIseries.consultaLMBALDespuesDelDesembolso(mx.getStrXLOGSRVPrestamo());
        ModelLmbal ml2 = RealizarConsultasIseries.consultarLMBALFechaDePago(ml.getStrLMBALDescripcionUsuario1());

        ModelXjmsc mxj = RealizarConsultasIseries.consultarXJMSCFechaDePago(credito.getConvenio());

        String strXLOGSRVPlazoConvertido = String
                .valueOf(Integer.parseInt(mx.getStrXLOGSRVPlazo().substring(0, (mx.getStrXLOGSRVPlazo().length()))));

        String cuotaXLOG = String.valueOf(
                Integer.parseInt(mx.getStrXLOGSRVValorCuota().substring(0, (mx.getStrXLOGSRVValorCuota().length()))));

        String montoTotalXLOG = String.valueOf(
                Integer.parseInt(mx.getStrXLOGSRVMontoTotalC().substring(0, (mx.getStrXLOGSRVMontoTotalC().length()))));

        String xLOGNumeroSecuencia = String.valueOf(Integer.parseInt(
                mx.getStrXLOGSRVNumeroSecuencia().substring(0, (mx.getStrXLOGSRVNumeroSecuencia().length()))));



        if (mp.getStrPREAPEstado().trim().equals("V") && mp.getStrPREAPCanal().trim().equals("Digital")
                && ml2.getStrLMBALFechaObligacion().trim().equals(mxj.getStrXJMSCFechaObligacion().trim())) {
            if (mx.getStrXLOGSRVPlan().trim().equals(ml.getStrLMBALTipoPlan().trim())
                    && mx.getStrXLOGSRVCodigoDesembolso().trim().equals(ml.getStrLMBALCodigoDistDesembolso().trim())
                    && mx.getStrXLOGSRVCodigoBaseAnual().trim().equals(ml.getStrLMBALCodigoAnioBase().trim())
                    && mx.getStrXLOGSRVCodigoFrecPago().trim().equals(ml.getStrLMBALCodigoFrecDePago().trim())
                    && mx.getStrXLOGSRVEstadoPrestamo().trim().equals(ml.getStrLMBALEstadoDePrestamo().trim())
                    && strXLOGSRVPlazoConvertido.trim().equals(ml.getStrLMBALPeriodoDelPlazo().trim())
                    && mx.getStrXLOGSRVTasaSV().trim().equals(ml.getStrLMBALTasaSeguroDeVida().trim())
                        && mx.getStrXLOGSRVFechaApertura().trim().equals(ml.getStrLMBALFechaDeNota().trim())
                        && mx.getStrXLOGSRVFechaVencimiento().trim().equals(ml.getStrLMBALFechaDeVencimiento().trim())
                        && mx.getStrXLOGSRVCuentaDesembolso().trim().equals(ml.getStrLMBALCuentaAbonos().trim())
                        && cuotaXLOG.trim().equals(ml.getStrLMBALPagoNormal().trim())
                        && montoTotalXLOG.trim().equals(ml.getStrLMBALMontoTotalContrato().trim())
                        && xLOGNumeroSecuencia.trim().equals(ml.getStrLMBALNumSecLineaDeCre().trim())
                        && mx.getStrXLOGSRVConvenio().trim().equals(ml.getStrLMBALCodigoDelConvenio())) {
                    return true;
                }
            

        }
        return false;

    }

    public static LasValidacionesDelDesembolso estanCorrectas(Credito credito) {
        return new LasValidacionesDelDesembolso(credito);
    }

}
