package Sanity_test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import groovy.lang.GroovyObject;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class api_cookunity_test {

    private static final String BASE_URL = "https://gorest.co.in/public/v1";
    private static final String AUTH_TOKEN = "55d6636b25b84832f383665a17f72117ee2b5e655a78ba968912c9a37d1c050f";

    @Test
    public void testGetActiveUser() {
        // Paso 1: Obtener lista de usuarios
        Response responseList = RestAssured
                .get(BASE_URL + "/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Encontrar primer usuario activo
        int userId = responseList.jsonPath()
                .getInt("data.find { it.status == 'active' }.id");

        // Paso 2: Obtener detalles del usuario activo
        Response responseUser = RestAssured
                .get(BASE_URL + "/users/" + userId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Paso 3: Assert
        String status = responseUser.jsonPath().getString("data.status");
        assertEquals(status, "active", "El estado del usuario debe ser active");
    }

    @Test
    public void testUpdateUserName() {
        // Paso 1: Obtener lista de usuarios
        Response responseList = RestAssured
                .get(BASE_URL + "/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        int userId = responseList.jsonPath().getInt("data[0].id");
        String newName = "UsuarioModificado";

        // Paso 2: Modificar nombre del usuario
        Response responseUpdate = RestAssured
                .given()
                .header("Authorization", "Bearer " + AUTH_TOKEN)
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"" + newName + "\", \"email\": \"jana.waters@hotmail.us\", \"status\": \"active\" }")
                .patch(BASE_URL + "/users/" + userId)
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Paso 3: Assert
        String updatedName = responseUpdate.jsonPath().getString("data.name");
        assertEquals(updatedName, newName, "El nombre debe ser modificado correctamente");
    }
}