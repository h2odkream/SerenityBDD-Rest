package libranzasManual.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/documentos_despues_del_desembolso.feature", 
				glue = "libranzasManual.stepdefinition", 
				snippets = SnippetType.CAMELCASE)
public class Documentos_despues_del_desembolso {}