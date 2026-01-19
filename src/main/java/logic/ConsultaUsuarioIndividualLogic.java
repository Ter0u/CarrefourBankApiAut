package logic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.YamlUtils;

import java.util.HashMap;

public class ConsultaUsuarioIndividualLogic {

    private static Response response;

    public static Response consultaUsuarioIndividual(String id){
        response = RestAssured.given()
                .get(YamlUtils.get("usuariosEndpoint.url") + "/" + id)
                .then()
                .extract().response();
        return response;
    }

}
