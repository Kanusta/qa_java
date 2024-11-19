package client;

import Praktikum.OrderRequest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrderClients {

    private static OrderRequest orderRequest;

    public static Response getOrderList() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("/v1/orders");
    }
}
