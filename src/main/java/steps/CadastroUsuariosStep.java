package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import logic.CadastroUsuariosLogic;
import utils.AssertUtils;

import java.io.IOException;

public class CadastroUsuariosStep {

    private static Response response;
    private static final String SRC_TEST_RESOURCE_SCHEMA_USER_REGISTER = "schemas//cadastro-usuario-status-code-201.json";
    private static final String SRC_TEST_RESOURCE_SCHEMA_ERROR_USER_REGISTER = "schemas//cadastro-usuario-status-code-400.json";


    @Given("que realize requisição POST criando novo usuário")
    public void cadastroUsuarioSucesso() {
        response = CadastroUsuariosLogic.cadastroUsuario();
    }

    @Given("que realize requisição POST criando usuário com email em uso")
    public void cadastroUsuarioComEmailEmUso() {
        response = CadastroUsuariosLogic.cadastroUsuarioEmailEmUso();
    }

    @Given("que realize requisição POST criando usuário com email inválido")
    public void cadastroUsuarioComEmailInvalido() {
        response = CadastroUsuariosLogic.cadastroUsuarioEmailInvalido();
    }

    @Given("que realize requisição POST criando usuário sem nome")
    public void cadastroUsuarioSemNome() {
        response = CadastroUsuariosLogic.cadastroUsuarioSemNome();
    }

    @Given("que realize requisição POST criando usuário sem email")
    public void cadastroUsuarioSemEmail() {
        response = CadastroUsuariosLogic.cadastroUsuarioSemEmail();
    }

    @Given("que realize requisição POST criando usuário sem password")
    public void cadastroUsuarioSemPassword() {
        response = CadastroUsuariosLogic.cadastroUsuarioSemPassword();
    }

    @Given("que realize requisição POST criando usuário sem administrador")
    public void cadastroUsuarioSemAdministrador() {
        response = CadastroUsuariosLogic.cadastroUsuarioSemAdministrador();
    }

    @Then("retorna status code {int} com usuário criado com sucesso")
    public void retornaUsuarioCriado(int statusCode) {
        response = AssertUtils.assertSchemaValidation(statusCode, response, SRC_TEST_RESOURCE_SCHEMA_USER_REGISTER);
    }

    @Then("retorna status code {int} com erro {string}")
    public void retornaErro(int statusCode, String erro) {
        response = AssertUtils.assertSchemaValidation(statusCode, response, SRC_TEST_RESOURCE_SCHEMA_ERROR_USER_REGISTER);
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "message", erro);
    }

    @Then("retorna status code {int} com erro de email {string}")
    public void retornaErroEmail(int statusCode, String erro) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "email", erro);
    }

    @Then("retorna status code {int} com erro de nome {string}")
    public void retornaErroNome(int statusCode, String erro) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "nome", erro);
    }

    @Then("retorna status code {int} com erro de password {string}")
    public void retornaErroPassword(int statusCode, String erro) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "password", erro);
    }

    @Then("retorna status code {int} com erro de administrador {string}")
    public void retornaErroAdministrador(int statusCode, String erro) {
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "administrador", erro);
    }
}
