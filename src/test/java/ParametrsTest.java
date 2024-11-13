import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Collections;
import java.util.List;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

@RunWith(Parameterized.class)
public class ParametrsTest {
    private static String firstName;
    private static String lastName;
    private static String address;
    private static String metroStation;
    private static String phone;
    private static int rentTime;
    private static String deliveryDate;
    private static String comment;
    private static List<String> color;

    public ParametrsTest(String firstName,String lastName,String address,String metroStation,String phone,int rentTime,String deliveryDate,String comment,List<String> color){
         ParametrsTest.firstName=firstName;
         ParametrsTest.lastName = lastName;
         ParametrsTest.address = address;
         ParametrsTest.metroStation=metroStation;
         ParametrsTest.phone = phone;
         ParametrsTest.rentTime = rentTime;
         ParametrsTest.deliveryDate= deliveryDate;
         ParametrsTest.comment = comment;
         ParametrsTest.color = color;
}
    @Parameterized.Parameters
    public static Object[][] order() {
        return new Object[][]  {
                 {"khgjk","khgjk","khgjk","4","123456789",7,"2020-10-10","sfs",List.of("BLACK")},
                {"khgjk","khgjk","khgjk","4","123456789",7,"2020-10-10","sfs",List.of("BLACK","GREY")},
                {"khgjk","khgjk","khgjk","4","123456789",7,"2020-10-10","sfs",List.of("GREY")},
                {"khgjk","khgjk","khgjk","4","123456789",7,"2020-10-10","sfs",Collections.emptyList()},

         };
}
    @Before
    public void SetUp() {
        RestAssured.baseURI = "https://qa-scooter.praktikum-services.ru/";}

    @Test
   public void colorTest() {
        ParametrsTest parametrsTest = new ParametrsTest("khgjk","khgjk","khgjk","4","123456789",7,"2020-10-10","sfs",List.of());
       given().log().all()
                .header("Content-Type","application/json")
                .body(parametrsTest)
                .when()
                .post("/api/v1/orders")
                .then()
                .assertThat().statusCode(201);
    }
    }