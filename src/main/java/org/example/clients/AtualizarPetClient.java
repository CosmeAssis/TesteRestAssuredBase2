package org.example.clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.api.ApiConfig;

public class AtualizarPetClient {
    // Metodo para atualizar Pet (PUT)
    public Response atualizarPet(long id, String name, String photoUrls, String status) {

        // Montar o corpo da requisição
        String requestAtualizarPet = "{\n" +
                "  \"id\": " + id + ",\n" +
                "  \"category\": {\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"string\"\n" +
                "  },\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"photoUrls\": [\n" +
                "    \"" + photoUrls + "\"\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"id\": 0,\n" +
                "      \"name\": \"string\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"status\": \"" + status + "\"\n" +
                "}";

        // Realizar a requisição POST
        return  RestAssured
                .given()
                .spec(ApiConfig.getRequestPetStore())
                .accept("application/json")
                .contentType("application/json")
                .body(requestAtualizarPet)
                .when()
                .post("/pet");
    }
}
