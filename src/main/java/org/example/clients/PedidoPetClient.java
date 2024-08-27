package org.example.clients;


import io.restassured.response.Response;
import org.example.api.ApiConfig;
import org.example.models.PedidoPet;

import static io.restassured.RestAssured.given;

public class PedidoPetClient {

    // Método para criar um novo pedido (POST)
    public Response criarPedidoPet(PedidoPet pedidoPet) {
        return given()
                .spec(ApiConfig.getRequestPetStore())
                .body(pedidoPet)
                .when()
                .post("/store/order");
    }

}