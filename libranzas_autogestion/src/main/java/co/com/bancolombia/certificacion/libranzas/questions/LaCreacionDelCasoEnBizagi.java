package co.com.bancolombia.certificacion.libranzas.questions;

import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasBizagi;
import co.com.bancolombia.certificacion.libranzas.models.ModelBizagi;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LaCreacionDelCasoEnBizagi implements Question<Boolean> {

	private String cedula;

	public LaCreacionDelCasoEnBizagi(String cedula) {
		this.cedula = cedula;
	}

	@Override
	public Boolean answeredBy(Actor actor) {
		ModelBizagi mb = RealizarConsultasBizagi.consultarNumeroCasoInicio(cedula);
		String casoBizagi = mb.getStrNumeroCasoBizagi();

		if (!casoBizagi.equals(null)) {
			return true;
		}
		return false;
	}

	public static LaCreacionDelCasoEnBizagi alInciarLaExperiencia(String cedula) {
		return new LaCreacionDelCasoEnBizagi(cedula);
	}

}
