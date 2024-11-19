import Praktikum.Courier;
import Praktikum.CourierId;
import client.CourierClients;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static courierGenerator.CourierGenerator.randomCourier;
import static org.apache.hc.core5.http.HttpStatus.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class CreateCourierTest {
    private int id;
    private CourierClients courierClients;

    @Before
    public void setUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";
    }

    @Test
    @Step("Создание курьера")
    public void сreateACourierTest() {
        Courier courier = randomCourier();
        courierClients = new CourierClients();
        Response response = courierClients.create(courier);
        Response loginResponse  = courierClients.login(courier);
        id = loginResponse.as(CourierId.class).getId();
        response
                .then()
                .assertThat()
                .statusCode(SC_CREATED)
                .body("ok", equalTo(true));
    }
    @Test
    @Step("Нельзя создать 2-х одинаковых курьеров")
    public void createTwoIdenticalCourier() {
        Courier courier = randomCourier();
        courierClients = new CourierClients();
        courierClients.create(courier);
        Response response = courierClients.create(courier);
        Response loginResponse = courierClients.login(courier);
        id = loginResponse.as(CourierId.class).getId();
        response
                .then()
                .assertThat()
                .statusCode(SC_CONFLICT)
                .assertThat()
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
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
    @After
    public void tearDown() {
        courierClients.delete(id);
    }
}
