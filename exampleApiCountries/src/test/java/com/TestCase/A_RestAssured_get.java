package com.TestCase;

import com.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class A_RestAssured_get extends TestBase {


    @BeforeClass
    public void tokenValue() throws IOException {
        logger.info("__________ Before Test __________");
        RestAssured.baseURI = "https://devtest.smartbutton.com";
        //for property file

        System.out.println(version3);
        //end property file

        logger.info("__________ Apply for Access Token __________");
        Response resp = RestAssured.
                given().
                formParam("client_ID", "41pDdTgdvZ1hCNCs").
                formParam("client_secret", "Wfy1jJyHPQXqyrMgt5FG7tc1").
                formParam("grant_type", "client_credentials").
                formParam("api_domain", "https://devtest.smartbutton.com/webapi").

                post("https://devtest.smartbutton.com/auth/connect/token");
        token = resp.jsonPath().get("access_token");
        logger.info("__________ Access token was successful! __________");
    }

    @Test(priority = 1)
    public void firstGet() {
        //get request with Status Code with Full Body Response.
        logger.info("__________ GET . Retrieve a list of countries __________");
        given().header("api-version", version3).and().
                auth().oauth2(token).
                when().get("/webapi/countries").
                then().statusCode(200).log().all();
        logger.info("__________ GET . 'Retrieve a list of countries'  request completed successfully! __________");
    }

    @Test(priority = 2)
    public void VerifyMultipleResponces() {
        //get request with Response code and  verifying multiple contents in response body.
        logger.info("__________ Validate multiple contents in GET request __________");
        given().header("api-version", "2020.3").
                auth().oauth2(token).
                when().get("/webapi/countries").
                then().statusCode(200).
                and().assertThat().body("links.self", equalTo("https://devtest.smartbutton.com/webapi/countries")).
                and().assertThat().body("meta.customerId", equalTo(53)).
                and().header("Content-Type", equalTo("application/json; charset=utf-8"));
        logger.info("__________ Validate multiple contents in GET request was successful! __________");
    }

    @Test(priority = 3)
    public void varifyMultipleValuesInBody() {
        //get request with Response code and  verifying Multiple values in response body.
        logger.info("__________ Validate multiple values in a content in GET request __________");
        given().header("api-version", "2020.3").
                auth().oauth2(token).
                when().get("/webapi/countries").
                then().statusCode(200).body("data.id", hasItems(13, 16, 19, 15));
        logger.info("__________ Validate multiple values in a content in GET request was successful! __________");
    }

}
/*



    @Test(priority = 1)

    public void RetrieveAListOfCountries_FBR() {

        //get request with Status Code with Full Body Response.
        given().header("api-version", "2020.3").and().
        auth().oauth2(token).
        when().get("/webapi/countries").
                then().statusCode(200).log().all();
    }


    @Test (priority = 2)

    public void RetrieveAListOfCountries_SCRB(){

        //get request with Response code and  verifying single content in response body.
         given().header("api-version", "2020.3").
                 auth().oauth2("").
                 when().get("/webapi/countries").
                then().statusCode(200).
                 and().body("links.self", equalTo("https://devtest.smartbutton.com/webapi/countries")).
                 and().body("meta.customerId", equalTo(53)).
                 and().header("Content-Type", equalTo("application/json; charset=utf-8"));
    }

    @Test (priority = 3)

     public void  RetrieveAListOfCountries_MCRB() {

        //get request with Response code and  verifying Multi content in response body.
        given().header("api-version", "2020.3").
                auth().oauth2("eyJhbGciOiJSUzI1NiIsImtpZCI6IjYyQjAyQUI3QzM3NEQ3MzI2MjFDNkNDRDA5RTZGNDRCMzJDMkRFRTYiLCJ0eXAiOiJKV1QiLCJ4NXQiOiJZckFxdDhOMDF6SmlIR3pOQ2ViMFN6TEMzdVkifQ.eyJuYmYiOjE1ODUwNjQ5MjIsImV4cCI6MTU4NTA2ODUyMiwiaXNzIjoiaHR0cHM6Ly9kZXZ0ZXN0LnNtYXJ0YnV0dG9uLmNvbS9hdXRoIiwiYXVkIjpbImh0dHBzOi8vZGV2dGVzdC5zbWFydGJ1dHRvbi5jb20vYXV0aC9yZXNvdXJjZXMiLCJjbGllbnRfYXBpIl0sImNsaWVudF9pZCI6IjUwOTk4NDU5MTUwNDkzNDEiLCJjdXN0b21lcl9pZCI6IjUzIiwic2NvcGUiOlsiYXBpIl19.kYbw8-qG5MODxu_ORmGD8kmf40E72bpEVnx_qw4Q7OCmRHOFV1VTwmhfd7evIFbufDphk92GTVFja1kb7u16pRoMfCr9ypDVZhVX_cSNz1yC5tm-9wik_PSV__oVbnyG2tquW1B7IOW3E0hqpS-yJKz7qt2yDdhvAAR5MPhiheSiMDWX_kTFpMyVa4EzvKr2OOI93JAUSZNY6JYcq_aPAlsJRPxHxC6otaN-SR4TWtNLRSvlREVz6iNWcxnBlWM339KtKJrouAHeIjol_PbohxG_RCiBmefSZjy71eoprnCRpaM9F9WCSvumyD5xgrXz7WfaOag7rvXZfea65rhr3w").
                when().get("/webapi/countries").
                then().statusCode(200).body("data.id", hasItems(13, 16, 19, 15));
    }*/


