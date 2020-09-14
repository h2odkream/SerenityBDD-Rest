package co.com.bancolombia.certificacion.libranzas.questions;

import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasIseries;
import co.com.bancolombia.certificacion.libranzas.models.Credito;
import co.com.bancolombia.certificacion.libranzas.models.ModelSciffsaldo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancolombia.certificacion.libranzas.tasks.SolicitarUnCredito.sciff;

public class ValidarLosSaldos implements Question<Boolean> {

	private Credito credito;

	public ValidarLosSaldos(Credito credito) {
		this.credito = credito;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		ModelSciffsaldo sciff2 = RealizarConsultasIseries.consultaSaldoFinal(credito.getCta());

		if (!sciff.getStrSCIFFSALDOSaldoAntes().equals(sciff2.getStrSCIFFSALDOSaldoDespues())) {
			return true;
		}

		return false;
	}

	public static ValidarLosSaldos despuesDelDesembolso(Credito credito) {
		return new ValidarLosSaldos(credito);
	}
}
