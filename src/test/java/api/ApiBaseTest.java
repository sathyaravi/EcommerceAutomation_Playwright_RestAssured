package api;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    @BeforeClass(alwaysRun = true)
    public void apiSetup(){

        RestAssured.baseURI="https://automationexercise.com/";

        RestAssured.defaultParser= Parser.JSON;

        Response response;
    }



}
