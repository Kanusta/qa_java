package client;

import Praktikum.OrderRequest;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class OrderClients {

    private static OrderRequest orderRequest;

    public static Response createOrder(OrderRequest orderRequest) {;
        OrderClients.orderRequest = orderRequest;

        return given()
                .header("Content-Type", "application/json")
                .body(orderRequest)
                .when()
                .post("/api/v1/orders");
    }

    public static Response getOrderList() {

        return given()
                .header("Content-Type", "application/json")
                .when()
                .get("/v1/orders");
    }

    public static Response cancel(String track) {

        return given()
                .header("Content-type", "application/json")
                .when()
                .put("/api/v1/orders/cancel?track="+ track);
    }
}
