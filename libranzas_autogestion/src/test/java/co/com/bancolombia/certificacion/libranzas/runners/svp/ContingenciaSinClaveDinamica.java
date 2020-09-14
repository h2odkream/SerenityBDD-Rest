package co.com.bancolombia.certificacion.libranzas.runners.svp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features/SVP/contingencia_sin_clave_dinamica.feature",
		glue="com.bancolombia.certificacion.libranzas.stepdefinitions",
		dryRun=true,
		snippets=SnippetType.CAMELCASE
		,tags="@UsuarioClaveDinamicaEntraALaExperienciaSinCD"
		
		)
public class ContingenciaSinClaveDinamica {

}
