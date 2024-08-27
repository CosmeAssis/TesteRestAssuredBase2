package org.example.clients;

import io.restassured.response.Response;
import org.example.api.ApiConfig;

import static io.restassured.RestAssured.given;

public class BuscarPetStatusClient {
    // Metodo para buscar Pet por Status (GET)
    public Response buscarPetStatus(String status) {
        return given()
                .spec(ApiConfig.getRequestPetStore())
                .accept("application/json")
                .when()
                .get("/pet/findByStatus?status=" + status);
    }
}
