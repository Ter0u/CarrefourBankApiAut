package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import logic.CadastroUsuariosLogic;
import logic.DeletarUsuariosLogic;
import utils.AssertUtils;

public class DeletarUsuariosStep {

    private static Response response;
    private static final String SRC_TEST_RESOURCE_SCHEMA_USER_DELETED = "schemas//deletar-usuario-status-code-200.json";

    @Given("que realize requisição DELETE removendo usuário")
    public void deletarUsuarioCadastrado() {
        response = DeletarUsuariosLogic.deletarUsuario();
    }

    @Given("que realize requisição DELETE usuario inexistente {string}")
    public void deletarUsuarioInexistente(String id) {
        response = DeletarUsuariosLogic.deletarUsuarioInexistente(id);
    }

    @Then("retorna status code {int} com mensagem {string}")
    public void retornaUsuarioCriado(int statusCode, String msg) {
        response = AssertUtils.assertSchemaValidation(statusCode, response, SRC_TEST_RESOURCE_SCHEMA_USER_DELETED);
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "message", msg);
    }

}
