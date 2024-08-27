package tests;

import io.restassured.response.Response;
import org.example.clients.AtualizarPetClient;
import org.junit.Assert;
import org.junit.Test;

public class AtualizarPetTests {

    @Test
    public void testAtualizarPet() {
        // Instancia o cliente que vai fazer a requisição
        AtualizarPetClient atualizarPetClient = new AtualizarPetClient();

        // Definir os parâmetros do request
        long id = 2;
        String name = "Cachorro";
        String photoUrls = "https://cachorro.png";
        String status = "available";

        // Chamar o método atualizarPet com os parâmetros
        Response response = atualizarPetClient.atualizarPet(id, name, photoUrls, status);

        // Validar o código de status da resposta
        Assert.assertEquals(response.getStatusCode(), 200);

        // Validar os valores da resposta
        Assert.assertEquals(response.jsonPath().getLong("id"), id);
        Assert.assertEquals(response.jsonPath().getString("name"), name);
        Assert.assertEquals(response.jsonPath().getString("photoUrls[0]"), photoUrls);
        Assert.assertEquals(response.jsonPath().getString("status"), status);

        // Obtém o código de status da resposta
        int statusCode = response.getStatusCode();
        // Obtém o corpo da resposta em formato String
        String responseBody = response.getBody().asString();

        // Exibe o código de status e o corpo da resposta no console
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);


    }
}
