package logic;

import dto.CadastroUsuarioDTO;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.FixtureUtils;
import utils.RandomUtils;
import utils.YamlUtils;

import java.util.Map;

public class DeletarUsuariosLogic {

    private static Response response;

    public static Response deletarUsuario() {
        CadastroUsuarioDTO usuarioDTO = new CadastroUsuarioDTO();
        response = RestAssured.given()
                .delete(YamlUtils.get("usuariosEndpoint.url") + "/" + usuarioDTO.getId())
                .then()
                .extract().response();
        return response;
    }

    public static Response deletarUsuarioInexistente(String id) {
        response = RestAssured.given()
                .delete(YamlUtils.get("usuariosEndpoint.url") + "/" + id)
                .then()
                .extract().response();
        return response;
    }
}
