import Praktikum.Courier;
import client.OrderClients;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static java.util.Optional.empty;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.not;

public class LoginCourierTest {

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
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
       Response response = OrderClients.getOrderList();
       response
               .then()
               .assertThat()
               .statusCode(SC_OK)
               .assertThat()
               .body("orders", not(empty()));
    }
}