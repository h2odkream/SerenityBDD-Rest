package libranzasManual.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/prueba_contable.feature", 
				glue = "libranzasManual.stepdefinition", 
				snippets = SnippetType.CAMELCASE)
public class Prueba_contable {}