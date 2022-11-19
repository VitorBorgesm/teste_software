import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = "pretty",
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = true
		/**
		 * quando o dryrun é true roda tudo mas quando é falso passa pelos testes da Junit
		 * @author vitor
		 *
		 *
		 */
		)
public class Runner {

}
