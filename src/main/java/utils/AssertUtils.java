package utils;

import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.InputStream;

public class AssertUtils {

    public static Response assertSchemaValidation(int expectedStatusCode, Response response, String schemaFileName) {

        if (response.getStatusCode() != expectedStatusCode) {
            throw new AssertionError("Status code esperado: " + expectedStatusCode +
                    ", mas recebeu: " + response.getStatusCode());
        }
        InputStream schemaStream = AssertUtils.class
                .getClassLoader()
                .getResourceAsStream(schemaFileName);

        try {
            response.then().assertThat().body(matchesJsonSchema(schemaStream));
        } catch (AssertionError e) {
            throw new AssertionError("Schema validation falhou!\n" + e.getMessage());
        }
        return response;
    }

    public static Response assertStatusCodeAndBody(int statusCode, Response response, String jsonPath, String expectedValue) {
        response.then()
                .statusCode(statusCode)
                .body(jsonPath, equalTo(expectedValue));
        return response;
    }

    public static Response assertHasNoItem(int statusCode,Response response, String jsonPath, String notExpectedValue) {
        response.then()
                .statusCode(statusCode)
                .body(jsonPath, not(hasItem(notExpectedValue)));
        return response;
    }
}
