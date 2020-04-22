package com.TestCase;

import com.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class D_RestAssured_Put extends TestBase {

    @BeforeClass
    public void tokenValue() {
        logger.info("__________ Before Class C__________");
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
    public void PutRequest(){
        logger.info("__________ Put Request __________");
        JSONObject ppayload = new JSONObject();
        ppayload.put("abbreviation","xx");
        ppayload.put("name", "xxstringZZ");
        ppayload.put("regionLabel", "string");
        ppayload.put("zipLabel", "string");
        ppayload.put("callingCode", 0);
        ppayload.put("sortOrder", 0);
        ppayload.put("hasRegions", true);
        ppayload.put("showInAddressList", true);
        ppayload.put("showInCallingCodeList", true);

        given().header("api-version", "2020.3").and().contentType("application/json").and().
                auth().oauth2(token).body(ppayload).
                when().put("https://devtest.smartbutton.com/webapi/countries/1247").
                then().log().all();
        logger.info("__________ Put request was succuessful __________");
    }

}
