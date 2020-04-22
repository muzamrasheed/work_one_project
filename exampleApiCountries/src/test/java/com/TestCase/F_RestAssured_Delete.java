package com.TestCase;

import com.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class F_RestAssured_Delete extends TestBase {

    @BeforeClass
    public void tokenValue() {
        logger.info("__________ Before Test __________");
        RestAssured.baseURI = "https://devtest.smartbutton.com";

        logger.info("__________ Apply for Access Token __________");
        Response resp = RestAssured.
                given().
                formParam("client_ID", "41pDdTgdvZ1hCNCs").
                formParam("client_secret", "Wfy1jJyHPQXqyrMgt5FG7tc1").
                formParam("grant_type", "client_credentials").
                formParam("api_domain", "https://devtest.smartbutton.com/webapi").

                post("https://devtest.smartbutton.com/auth/connect/token");
        token = resp.jsonPath().get("access_token");
        logger.info("__________ Access Token was successful __________");

    }

    @Test(priority = 1)
    public void Delete() {
        //delete 1247
        logger.info("__________ delete Request __________");
        given().header("api-version", "2020.2").and().
                auth().oauth2(token).
                when().delete("/webapi/countries/1247").
                then().log().all();
        System.out.println("country id = 1247 has been deleted. ");
        logger.info("__________ Delete Request was successful __________");
    }
}