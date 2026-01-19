package dto;

import io.restassured.response.Response;
import logic.CadastroUsuariosLogic;

public class CadastroUsuarioDTO {

    private String id;

    public CadastroUsuarioDTO() {
        Response response = CadastroUsuariosLogic.cadastroUsuario();
        this.id = response.jsonPath().getString("_id");
    }

    public String getId() {
        return id;
    }
}
