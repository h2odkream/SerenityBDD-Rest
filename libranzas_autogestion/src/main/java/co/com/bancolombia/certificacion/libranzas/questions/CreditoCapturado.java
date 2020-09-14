package co.com.bancolombia.certificacion.libranzas.questions;

import co.com.bancolombia.certificacion.libranzas.userinterfaces.SVPPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class CreditoCapturado  implements Question<String>{
	
	@Override
	public String answeredBy(Actor actor) {

		return Text.of(SVPPage.NUMERO_PRESTAMO_SVP).viewedBy(actor).value();

	}

	public static CreditoCapturado enLaSVP() {
		return new CreditoCapturado();
	}


}
