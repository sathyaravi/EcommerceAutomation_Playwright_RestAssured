package api;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ProductApiTest extends ApiBaseTest {


    @Test
    public void getAllProducts(){

        given()
                .when()
                .get("/api/productsList")
                .then().statusCode(200)
               .body("products",not(empty()));

    }


    @Test
    public void getAllBrands(){

        given()
                .when()
                .get("/api/brandsList")
                .then().statusCode(200)
                .body("brands",not(empty()));

    }


    @Test
    public void searchProduct(){
        
        given().formParam("search_product","Jeans")
                .when()
                .post("/api/searchProduct")
                .then().statusCode(200)
                .body("products",not(empty()));


    }


    @Test
    public void searchProductWithoutParam(){

        Response response=given()
                .when()
                .post("/api/searchProduct");

        response.then().statusCode(200);

        String actualmessage=response.body().jsonPath().get("message");

        Assert.assertEquals(actualmessage,"Bad request, search_product parameter is missing in POST request.","Bad Request!!!");


    }


}
