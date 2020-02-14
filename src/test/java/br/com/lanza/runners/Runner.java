package br.com.lanza.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/aprender_cucumber.feature", //caminho das feature
        glue = "br.com.lanza.steps", //caminho dos steps
        //tags = "test", //Executa só esse cenário
        plugin = "pretty",
        dryRun = false,
        strict = true,
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class Runner {

}
