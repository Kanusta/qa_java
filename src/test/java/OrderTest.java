import client.OrderClients;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static java.util.Optional.empty;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.not;

public class OrderTest {
    private OrderClients orderClient;
    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
         orderClient = new OrderClients();
    }
    @Test
    @Step("Проверь, что в тело ответа возвращается список заказов")
    public void checklistOfOrders (){
        Response response = OrderClients.getOrderList();
        response
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .assertThat()
                .body("orders", not(empty()));
    }
}
