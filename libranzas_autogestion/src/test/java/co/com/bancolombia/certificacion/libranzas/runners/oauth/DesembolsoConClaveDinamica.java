package co.com.bancolombia.certificacion.libranzas.runners.oauth;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src/test/resources/features/oauth/desembolso_con_clave_dinamica.feature",
		glue = "co.com.bancolombia.certificacion.libranzas.stepdefinitions",
		dryRun = false,
		snippets = SnippetType.CAMELCASE


)
public class DesembolsoConClaveDinamica {
	
}
