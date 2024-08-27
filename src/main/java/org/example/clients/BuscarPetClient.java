package org.example.clients;

import io.restassured.response.Response;
import org.example.api.ApiConfig;

import static io.restassured.RestAssured.given;

public class BuscarPetClient {

    // Metodo para buscar Pet (GET)
    public Response buscarPet(long petId) {
        return given()
                .spec(ApiConfig.getRequestPetStore())
                .when()
                .get("/pet/" + petId);
    }
}
