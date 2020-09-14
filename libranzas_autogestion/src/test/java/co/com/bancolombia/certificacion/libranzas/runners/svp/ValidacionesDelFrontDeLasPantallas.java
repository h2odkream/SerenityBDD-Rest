package co.com.bancolombia.certificacion.libranzas.runners.svp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features="src/test/resources/features/SVP/validaciones_del_front_de_las_pantallas.feature",
		glue="com.bancolombia.certificacion.libranzas.stepdefinitions",
		dryRun=false,
		snippets=SnippetType.CAMELCASE)
public class ValidacionesDelFrontDeLasPantallas {

}
