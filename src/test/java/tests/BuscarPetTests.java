package tests;

import io.restassured.response.Response;
import org.example.clients.BuscarPetClient;
import org.example.clients.BuscarPetStatusClient;
import org.example.models.BuscarPet;
import org.example.models.BuscarPetStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuscarPetTests {

    @Test
    public void testBuscarPetInexistente() {
        // Instancia o cliente que vai fazer a requisição
        BuscarPetClient buscarPetClient = new BuscarPetClient();

        Response response = buscarPetClient.buscarPet(109);

        // Obtém o código de status da resposta
        int statusCode = response.getStatusCode();
        // Obtém o corpo da resposta em formato String
        String responseBody = response.getBody().asString();

        // Exibe o código de status e o corpo da resposta no console
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Valida que a resposta tem o código de status 404
        assertEquals(404, statusCode);

        // Converte a resposta da API para um objeto PedidoPet
        BuscarPet responseBuscarPetInexistente = response.as(BuscarPet.class);

        // Valida que os Dados na resposta sao o esperado conforme o Swagger
        assertEquals("1", responseBuscarPetInexistente.getCode());
        assertEquals("error", responseBuscarPetInexistente.getType());
        assertEquals("Pet not found", responseBuscarPetInexistente.getMessage());
    }

    @Test
    public void testBuscarPetStatus() {
        // Instancia o cliente que vai fazer a requisição
        BuscarPetStatusClient buscarPetStatusClient = new BuscarPetStatusClient();

        Response response = buscarPetStatusClient.buscarPetStatus("pending");

        // Obtém o código de status da resposta
        int statusCode = response.getStatusCode();
        // Obtém o corpo da resposta em formato String
        String responseBody = response.getBody().asString();

        // Exibe o código de status e o corpo da resposta no console
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Valida que a resposta tem o código de status 200
        assertEquals(200, statusCode);

    }
}
