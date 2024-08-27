package tests;

import io.restassured.response.Response;
import org.example.clients.PedidoPetClient;
import org.example.models.PedidoPet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CriarPedidoPetTests {

    @Test
    public void testCriarPedidoNovoPet() {
        // Instancia o cliente que vai fazer a requisição
        PedidoPetClient pedidoPetClient = new PedidoPetClient();

        // Cria uma nova instância de PedidoPet com os dados do pedido
        PedidoPet pedidoPet = new PedidoPet();
        pedidoPet.setId(1);
        pedidoPet.setPetId(12345);
        pedidoPet.setQuantity(2);
        pedidoPet.setShipDate("2024-08-26T15:30:00.000Z");
        pedidoPet.setStatus("placed");
        pedidoPet.setComplete(true);

        Response response = pedidoPetClient.criarPedidoPet(pedidoPet);

        // Obtém o código de status da resposta
        int statusCode = response.getStatusCode();
        // Obtém o corpo da resposta em formato String
        String responseBody = response.getBody().asString();

        // Exibe o código de status e o corpo da resposta no console
        System.out.println("Status Code: " + statusCode);
        System.out.println("Response Body: " + responseBody);

        // Valida que a resposta tem o código de status 200 (OK)
        assertEquals(200, statusCode);

        // Converte a resposta da API para um objeto PedidoPet
        PedidoPet responsePedidoPet = response.as(PedidoPet.class);

        // Valida que os Dados na resposta são os mesmos que foram enviados
        assertEquals(pedidoPet.getId(), responsePedidoPet.getId());
        assertEquals(pedidoPet.getPetId(), responsePedidoPet.getPetId());
        assertEquals(pedidoPet.getQuantity(), responsePedidoPet.getQuantity());
        assertEquals(pedidoPet.getStatus(), responsePedidoPet.getStatus());
        assertEquals(pedidoPet.getComplete(), responsePedidoPet.getComplete());
    }
}
