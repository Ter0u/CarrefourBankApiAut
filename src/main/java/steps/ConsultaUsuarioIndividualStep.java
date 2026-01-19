package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import logic.ConsultaUsuarioIndividualLogic;
import utils.AssertUtils;

public class ConsultaUsuarioIndividualStep {

    private static Response response;
    private static final String SRC_TEST_RESOURCE_SCHEMA_USER_ID = "schemas//consulta-usuario-status-code-200.json";
    private static final String SRC_TEST_RESOURCE_SCHEMA_USER_ID_ERROR = "schemas//consulta-usuario-status-code-400.json";

    @Given("que realize requisição GET de usuário com id {string}")
    public void consultoUsuarioIndividual(String id) {
        response = ConsultaUsuarioIndividualLogic.consultaUsuarioIndividual(id);
    }

    @Then("retorna status code {int} com usuário válido")
    public void retornaUsuarioDoID(int statusCode) {
        response = AssertUtils.assertSchemaValidation(statusCode, response, SRC_TEST_RESOURCE_SCHEMA_USER_ID);
    }

    @Then("retorna status code {int} com erro de {string}")
    public void retornaErroDeUsuarioID(int statusCode, String erro) {
        response = AssertUtils.assertSchemaValidation(statusCode, response, SRC_TEST_RESOURCE_SCHEMA_USER_ID_ERROR);
        response = AssertUtils.assertStatusCodeAndBody(statusCode, response, "message", erro);
    }
}
