package logic;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.json.Json;
import utils.FixtureUtils;
import utils.RandomUtils;
import utils.YamlUtils;

public class CadastroUsuariosLogic {

    private static Response response;
    private static final String SRC_TEST_RESOURCE_FIX_USER = "fixtures//cadastroUsuario.json";
    private static final String SRC_TEST_RESOURCE_FIX_USER_INVALID_EMAIL = "fixtures//cadastroUsuarioInvalidoEmail.json";
    private static final String SRC_TEST_RESOURCE_FIX_USER_WITHOUT_NAME = "fixtures//cadastroUsuarioSemNome.json";
    private static final String SRC_TEST_RESOURCE_FIX_USER_WITHOUT_EMAIL = "fixtures//cadastroUsuarioSemEmail.json";
    private static final String SRC_TEST_RESOURCE_FIX_USER_WITHOUT_PASSWORD = "fixtures//cadastroUsuarioSemPassword.json";
    private static final String SRC_TEST_RESOURCE_FIX_USER_WITHOUT_ADMINISTRADOR = "fixtures//cadastroUsuarioSemAdministrador.json";

    public static Response cadastroUsuario() {
        Map<String, Object> newUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER);
        newUser.put("email", RandomUtils.randomEmail());
        response = RestAssured.given()
                .contentType("application/json")
                .body(newUser)
                .post(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response cadastroUsuarioEmailEmUso() {
        Map<String, Object> newUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER);
        response = RestAssured.given()
                .contentType("application/json")
                .body(newUser)
                .post(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response cadastroUsuarioEmailInvalido() {
        Map<String, Object> newUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER_INVALID_EMAIL);
        response = RestAssured.given()
                .contentType("application/json")
                .body(newUser)
                .post(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response cadastroUsuarioSemNome() {
        Map<String, Object> newUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER_WITHOUT_NAME);
        response = RestAssured.given()
                .contentType("application/json")
                .body(newUser)
                .post(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response cadastroUsuarioSemEmail() {
        Map<String, Object> newUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER_WITHOUT_EMAIL);
        response = RestAssured.given()
                .contentType("application/json")
                .body(newUser)
                .post(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response cadastroUsuarioSemPassword() {
        Map<String, Object> newUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER_WITHOUT_PASSWORD);
        response = RestAssured.given()
                .contentType("application/json")
                .body(newUser)
                .post(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response cadastroUsuarioSemAdministrador() {
        Map<String, Object> newUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER_WITHOUT_ADMINISTRADOR);
        response = RestAssured.given()
                .contentType("application/json")
                .body(newUser)
                .post(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }
}
