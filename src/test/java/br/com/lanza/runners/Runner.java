package br.com.lanza.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/locadora_cucumber.feature", //caminho das feature
        glue = "br.com.lanza.steps", //caminho dos steps
        //tags = {}, //Executa só esse cenário
        plugin = "pretty",
        monochrome = true,
        snippets = SnippetType.CAMELCASE,
        dryRun = false,
        strict = false
        )
public class Runner {

}
