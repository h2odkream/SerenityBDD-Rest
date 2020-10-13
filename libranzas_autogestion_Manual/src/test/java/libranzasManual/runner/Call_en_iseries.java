package libranzasManual.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/call_en_iseries.feature", 
				glue = "libranzasManual.stepdefinition", 
				snippets = SnippetType.CAMELCASE)
public class Call_en_iseries {}