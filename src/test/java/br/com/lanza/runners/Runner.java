package br.com.lanza.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/aprender_cucumber.feature",
        glue = "br.com.lanza.steps",
        plugin = "pretty",
        dryRun = false,
        strict = true,
        monochrome = true,
        snippets = SnippetType.CAMELCASE)
public class Runner {

}
