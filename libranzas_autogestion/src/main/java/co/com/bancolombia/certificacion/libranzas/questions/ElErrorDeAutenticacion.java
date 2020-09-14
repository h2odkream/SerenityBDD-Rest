package co.com.bancolombia.certificacion.libranzas.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class ElErrorDeAutenticacion implements Question<String> {
	

	private Target target;

	public ElErrorDeAutenticacion(Target target) {
		this.target = target;
	}

	@Override
	public String answeredBy(Actor actor) {

		return Text.of(target).viewedBy(actor).asString();
	}

	public static ElErrorDeAutenticacion dePantalla(Target error) {
		return new ElErrorDeAutenticacion(error);
	}
}
