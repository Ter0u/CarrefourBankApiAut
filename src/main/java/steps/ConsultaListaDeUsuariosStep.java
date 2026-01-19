package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import logic.ConsultaListaDeUsuariosLogic;
import utils.AssertUtils;

public class ConsultaListaDeUsuariosStep {

    private static Response response;
    private static final String SRC_TEST_RESOURCE_SCHEMA_USERS = "schemas//consulta-lista-usuarios-status-code-200.json";

    @Given("que realize requisição GET para o endpoint de lista de usuários")
    public void consultoListaDeUsuarios() {
        response = ConsultaListaDeUsuariosLogic.consultaListaDeUsuarios();
    }

    @Given("que realize requisição GET para o endpoint de lista de usuários filtrando por id {string}")
    public void consultoListaDeUsuariosPorID(String id) {
        response = ConsultaListaDeUsuariosLogic.consultaListaDeUsuariosPorID(id);
    }

    @Given("que realize requisição GET para o endpoint de lista de usuários filtrando por nome {string}")
    public void consultoListaDeUsuariosPorNome(String nome) {
        response = ConsultaListaDeUsuariosLogic.consultaListaDeUsuariosPorNome(nome);
    }

    @Given("que realize requisição GET para o endpoint de lista de usuários filtrando por email {string}")
    public void consultoListaDeUsuariosPorEmail(String email) {
        response = ConsultaListaDeUsuariosLogic.consultaListaDeUsuariosPorEmail(email);
    }

    @Given("que realize requisição GET para o endpoint de lista de usuários filtrando por password {string}")
    public void consultoListaDeUsuariosPorPassword(String password) {
        response = ConsultaListaDeUsuariosLogic.consultaListaDeUsuariosPorPassword(password);
    }

    @Given("que realize requisição GET para o endpoint de lista de usuários filtrando por administrador {string}")
    public void consultoListaDeUsuariosPorAdministrador(String administrador) {
        response = ConsultaListaDeUsuariosLogic.consultaListaDeUsuariosPorAdministrador(administrador);
    }

    @Then("retorna status code {int} com uma lista de usuários")
    public void retornaListaDeUsuarios(int statusCode) {
       response = AssertUtils.assertSchemaValidation(statusCode, response, SRC_TEST_RESOURCE_SCHEMA_USERS);
    }

    @Then("retorna status code {int} com um usuário de ID {string}")
    public void retornaListaDeUsuarioPorID(int statusCode, String id) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "usuarios[0]._id", id);
    }

    @Then("retorna status code {int} com um usuário de nome {string}")
    public void retornaListaDeUsuarioPorNome(int statusCode, String nome) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "usuarios[0].nome", nome);
    }

    @Then("retorna status code {int} com um usuário de email {string}")
    public void retornaListaDeUsuarioPorEmail(int statusCode, String email) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "usuarios[0].email", email);
    }

    @Then("retorna status code {int} com um usuário de password {string}")
    public void retornaListaDeUsuarioPorPassword(int statusCode, String email) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "usuarios[0].password", email);
    }

    @Then("retorna status code {int} com um usuário de administrador {string}")
    public void retornaListaDeUsuarioPorAdministrador(int statusCode, String administrador) {
        response = AssertUtils.assertHasNoItem(statusCode, response, "usuarios.administrador", administrador);
    }
}
