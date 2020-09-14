package co.com.bancolombia.certificacion.libranzas.runners.oauth;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/oauth/ingresos_de_la_tal.feature",
        glue="com.bancolombia.certificacion.libranzas.stepdefinitions",
        dryRun=false,
        snippets= SnippetType.CAMELCASE,
        tags="@MaximoNumeroDeGeneracionDelToken")

public class IngresosDeLaTal {
}
