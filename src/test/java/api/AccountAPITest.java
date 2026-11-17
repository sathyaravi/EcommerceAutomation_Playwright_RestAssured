package api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AccountAPITest extends ApiBaseTest {

    private final String email = "NewUser" + System.currentTimeMillis() + "mail.com";

    private final String password = "Test@123";

    Response response;

    private HashMap<String, String> user() {

        HashMap<String, String> accountPayload = new HashMap<>();

        accountPayload.put("name", "NewUser123");

        accountPayload.put("email", email);

        accountPayload.put("password", password);

        accountPayload.put("title", "Mr");

        accountPayload.put("birth_date", "8");

        accountPayload.put("birth_month", "August");

        accountPayload.put("birth_year", "1970");

        accountPayload.put("firstname", "New");

        accountPayload.put("lastname", "User123");

        accountPayload.put("company", "abc");

        accountPayload.put("address1", "243 Privet Drive");


        accountPayload.put("address2", "Mapletown");


        accountPayload.put("country", "United States");

        accountPayload.put("zipcode", "123456");

        accountPayload.put("state", "AL");

        accountPayload.put("city", "Mapletown");

        accountPayload.put("mobile_number", "1234567890");

        return accountPayload;


    }


    @Test
    public void createAccount() {

        Response response = given().formParams(user())

                .when()

                .post("https://automationexercise.com/api/createAccount");
        response.prettyPrint();

        int actualStatusCode = response.body().jsonPath().get("responseCode");

        System.out.println(actualStatusCode);

        Assert.assertEquals(actualStatusCode, 201, "Response Code mismatch!!!");
    }

    @Test(dependsOnMethods = "createAccount")
    public void verifyLogin() {

        Response response = given().formParam("email", email)
                .formParam("password", password)
                .when()
                .post("/api/verifyLogin");

        System.out.println(response.prettyPrint());


    }

    @Test(dependsOnMethods = "verifyLogin")
    public void getAccountdetails() {

        Response response = given().formParam("email", email)
                .when()
                .get("/api/getUserDetailByEmail");

        System.out.println(response.prettyPrint());

    }

    @Test(dependsOnMethods = "getAccountdetails")
    public void deleteAccount() {

        Response response = given().formParam("email", email).formParam("password", password)
                .when()
                .delete("/api/deleteAccount");

        response.then().statusCode(200);

        String actualMessage = response.body().jsonPath().get("message");

        Assert.assertEquals(actualMessage, "Account deleted!", "User account deleted");


    }




}