package logic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.FixtureUtils;
import utils.RandomUtils;
import utils.YamlUtils;
import java.util.Map;
import java.util.UUID;


public class EditarUsuariosLogic {

    private static Response response;

    private static final String SRC_TEST_RESOURCE_FIX_USER = "fixtures//cadastroUsuario.json";

    public static Response editarUsuario(String id) {
        Map<String, Object> editUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER);
        editUser.put("email", RandomUtils.randomEmail());
        editUser.put("nome", RandomUtils.randomNome());
        response = RestAssured.given()
                .contentType("application/json")
                .body(editUser)
                .put(YamlUtils.get("usuariosEndpoint.url") + "/" + id)
                .then()
                .extract().response();
        return response;
    }

    public static Response editarUsuarioInexistente() {
        Map<String, Object> editUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER);
        String id = UUID.randomUUID().toString();
        editUser.put("email", RandomUtils.randomEmail());
        response = RestAssured.given()
                .contentType("application/json")
                .body(editUser)
                .put(YamlUtils.get("usuariosEndpoint.url") + "/" + id)
                .then()
                .extract().response();
        return response;
    }

    public static Response editarUsuarioEmailEmUso(String id) {
        Map<String, Object> editUser =   FixtureUtils.loadAsMap(SRC_TEST_RESOURCE_FIX_USER);
        response = RestAssured.given()
                .contentType("application/json")
                .body(editUser)
                .put(YamlUtils.get("usuariosEndpoint.url") + "/" + id)
                .then()
                .extract().response();
        return response;
    }
}
