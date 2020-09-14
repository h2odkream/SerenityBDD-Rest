package libranzasManual.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/reporte_base_de_datos_ibm_validacion_tal.feature", 
				glue = "libranzasManual.stepdefinition", 
				snippets = SnippetType.CAMELCASE)
public class Reporte_base_de_datos_ibm_validacion_tal {}