import client.CourierClients;
import Praktikum.Courier;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static courierGenerator.CourierGenerator.randomCourier;
import static io.restassured.RestAssured.given;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;

public class ScooterTest {

    @Before
    public void SetUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
        Courier courier = new Courier().withLogin("fghdgfhj")
                .withFirstName("sfghfgh").withPassword("sdfhg");

    }

    @Test
    @Step("Создание курьера")
    public void сreateACourierTest() {
        Courier courier = randomCourier();
        CourierClients courierClients = new CourierClients();
        Response response = courierClients.create(courier);
        assertEquals(201,response.statusCode());
        Response loginResponse = courierClients.login(courier);
        assertEquals(SC_OK,loginResponse.statusCode());
        System.out.println(response.asString());
    }

    @Test
    @Step("Нельзя создать 2-х одинаковых курьеров")
    public void createTwoIdenticalCourier() {
         Courier courier = new Courier().withLogin("fghdgfhj")
                .withFirstName("sfghfgh").withPassword("sdfhg");
        CourierClients courierClients = new CourierClients();
        Response response =courierClients.create(courier);
        assertEquals(409,response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    @Step("Если одного из полей нет(не заполнено поле password), запрос возвращает ошибку")
    public void oneFieldIsEmptyPassword() {
        Courier courier = new Courier().withLogin("fd8gh");
        CourierClients courierClients = new CourierClients();
        Response response = courierClients.create(courier);
        assertEquals(400,response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    @Step("Если одного из полей нет(не заполнено поле login), запрос возвращает ошибку")
    public void oneFieldIsEmptyLogin() {
        Courier courier = new Courier().withPassword("fd8gh");
        CourierClients courierClients = new CourierClients();
        Response response = courierClients.create(courier);
        assertEquals(400,response.statusCode());
        System.out.println(response.asString());
    }

    @Test
    @Step("Курьер может авторизоваться")
    public void courierAuthorization() {
        Courier courier = new Courier().withLogin("fd8gh").withPassword("1253");
        Response response =  given()
                .header("Content-Type","application/json")
                .and()
                .body(courier)
                .post("api/v1/courier/login")
                .then()
                .statusCode(200)
                .extract().response();
        System.out.println(response.asString());
    }

    @Test
    @Step("Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку")
    public void nonExistentUser(){
        Courier courier = new Courier().withLogin("11").withPassword("1253");
        Response response = given()
                .header("Content-Type","application/json")
                .and()
                .body(courier)
                .post("api/v1/courier/login")
                .then()
                .statusCode(404)
                .extract().response();
        System.out.println(response.asString());
    }
   @Test
    @Step("Проверь, что в тело ответа возвращается список заказов")
    public void checklistOfOrders (){
       given()
               .get("/api/v1/orders")
              .then().statusCode(200);

    }
}


