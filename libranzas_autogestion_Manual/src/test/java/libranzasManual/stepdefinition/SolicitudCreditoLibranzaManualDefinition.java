package libranzasManual.stepdefinition;

import static libranzasManual.util.ManualTest.validate;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

public class SolicitudCreditoLibranzaManualDefinition {

	private Scenario scenario;

	@Before
	public void getScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("^(.*)$")
	public void pruebasLibranzas(String step) {
		validate(step, scenario.getName());
	}

}
