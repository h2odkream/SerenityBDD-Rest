package libranzasManual.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/reporte_base_de_datos_ibm.feature", 
				glue = "libranzasManual.stepdefinition", 
				snippets = SnippetType.CAMELCASE,
				tags = "@PasoFuncionalAdquiereloYaLibranza")

public class Reporte_base_de_datos_ibm 
{
	
}