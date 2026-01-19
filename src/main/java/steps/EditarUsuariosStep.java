package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import logic.DeletarUsuariosLogic;
import logic.EditarUsuariosLogic;
import utils.AssertUtils;

public class EditarUsuariosStep {

    private static Response response;
    private static final String SRC_TEST_RESOURCE_SCHEMA_USER_DELETED = "schemas//editar-usuario-status-code-200.json";

    @Given("que realize requisição PUT editando usuário {string}")
    public void editarUsuario(String id) {
        response = EditarUsuariosLogic.editarUsuario(id);
    }

    @Given("que realize requisição PUT editando usuário inexistente")
    public void editarUsuarioInexistente() {
        response = EditarUsuariosLogic.editarUsuarioInexistente();
    }

    @Given("que realize requisição PUT editando usuário com usuário duplicado {string}")
    public void editarUsuarioEmailDuplicado(String id) {
        response = EditarUsuariosLogic.editarUsuarioEmailEmUso(id);
    }

    @Then("retorna status code {int} com {string}")
    public void retornaUsuarioCriado(int statusCode, String msg) {
        response = AssertUtils.assertSchemaValidation(statusCode, response, SRC_TEST_RESOURCE_SCHEMA_USER_DELETED);
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "message", msg);
    }

}
