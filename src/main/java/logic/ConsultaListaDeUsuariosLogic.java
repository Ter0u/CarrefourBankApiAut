package logic;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.YamlUtils;

public class ConsultaListaDeUsuariosLogic {

    private static Response response;

    public static Response consultaListaDeUsuarios(){
        response = RestAssured.given()
                .log().all()
                .get(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response consultaListaDeUsuariosPorID(String id){
        response = RestAssured.given()
                .queryParam("_id", id)
                .get(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response consultaListaDeUsuariosPorNome(String nome){
        response = RestAssured.given()
                .queryParam("nome", nome)
                .get(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response consultaListaDeUsuariosPorEmail(String email){
        response = RestAssured.given()
                .queryParam("email", email)
                .get(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response consultaListaDeUsuariosPorPassword(String password){
        response = RestAssured.given()
                .queryParam("password", password)
                .get(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

    public static Response consultaListaDeUsuariosPorAdministrador(String administrador){
        response = RestAssured.given()
                .queryParam("administrador", administrador)
                .get(YamlUtils.get("usuariosEndpoint.url"))
                .then()
                .extract().response();
        return response;
    }

}
