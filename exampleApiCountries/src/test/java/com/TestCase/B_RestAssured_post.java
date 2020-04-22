package com.TestCase;

import com.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class B_RestAssured_post extends TestBase {

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
       public void postCountry(){
        logger.info("__________ Post REquest Started __________");
        JSONObject payload = new JSONObject();
        payload.put("abbreviation","xx");
        payload.put("name", "xxyystringxxyy");
        payload.put("regionLabel", "string");
        payload.put("zipLabel", "string");
        payload.put("callingCode", 0);
        payload.put("sortOrder", 0);
        payload.put("hasRegions", true);
        payload.put("showInAddressList", true);
        payload.put("showInCallingCodeList", true);

                given().header("api-version", "2020.3").and().contentType("application/json").and().
                        auth().oauth2(token).body(payload).
                when().post("https://devtest.smartbutton.com/webapi/countries").
                        then().log().all();
         logger.info("__________ Post Request was successful __________");

    }

}