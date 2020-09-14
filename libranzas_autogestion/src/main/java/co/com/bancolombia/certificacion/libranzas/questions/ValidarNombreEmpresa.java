package co.com.bancolombia.certificacion.libranzas.questions;

import co.com.bancolombia.certificacion.libranzas.integrations.RealizarConsultasIseries;
import co.com.bancolombia.certificacion.libranzas.userinterfaces.FinalizacionPage;
import co.com.bancolombia.certificacion.libranzas.models.Credito;
import co.com.bancolombia.certificacion.libranzas.models.ModelNombreEmpresa;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ValidarNombreEmpresa implements Question<Boolean> {

	Credito credito;

	public ValidarNombreEmpresa(Credito credito) {

		this.credito = credito;
		
	}

	@Override
	public Boolean answeredBy(Actor actor) {

		ModelNombreEmpresa nombreEmpresa = RealizarConsultasIseries.consultarXJMSCNombreEmpresa(credito.getConvenio());
		String nombreEmpresaFront = Text.of(FinalizacionPage.NOMBRE_EMPREESA).viewedBy(actor).value();
		
		if (nombreEmpresa.getStrXJMSCNombreEmpresa().trim().equals(nombreEmpresaFront.trim())) {	
			return true;
		
		}
				
			return false;
				
				
	}
		 

	public static ValidarNombreEmpresa esteVisible(Credito credito) {
		return new ValidarNombreEmpresa(credito);
	}

}
