package client;

import Praktikum.Courier;
import io.restassured.response.Response;

import static Praktikum.CourierCreds.credsFromCourier;
import static io.restassured.RestAssured.given;

public class CourierClients {


    public Response create(Courier courier) {
        return given()
                .header("Content-type","application/json")
                .and()
                .body(courier)
                .when()
                .post("api/v1/courier");
    }

        public Response login(Courier courier) {
            return given()
                    .header("Content-type", "application/json")
                    .and()
                    .body(credsFromCourier(courier))
                    .when()
                    .post("api/v1/courier/login");
        }

        public Response delete(int id) {
            return given()
                    .header("Content-type", "application/json")
                    .and()
                    .when()
                    .delete("api/v1/courier/" + id);
        }
    }

