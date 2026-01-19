import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = {"steps"},
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                "html:target/cucumber-report.html",
                "json:target/cucumber-report.json"
        },
//        tags = "@ConsultarListaDeUsuários and @CadastrarUsuarios and @ConsultaUsuarioIndividual and @DeletarUsuarios and EditarUsuarios", UTILIZAR UMA DESSAS TAGS CASO QUEIRA EXECUTAR INDIVIDUALMENTE
        monochrome = true
)
public class RunnerTest {
}