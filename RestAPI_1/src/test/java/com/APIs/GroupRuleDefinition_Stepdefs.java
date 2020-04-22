package com.APIs;

import com.base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;


import java.util.List;



public class GroupRuleDefinition_Stepdefs extends TestBase {

    public static Response Get_rules;



    @Given("^version of API & token were added$")
    public void version_of_api_and_token_were_added() throws Throwable {
        RestAssured.baseURI = BaseURI;
        Response resp = RestAssured.given().
                formParam("client_ID", clinet_id).
                formParam("client_secret", client_secret).
                formParam("grant_type", grant_type).
                formParam("api_domain", api_domain).
                post(postURLforToken);
        token = resp.jsonPath().get("access_token");

    }

    @When("^send a request to retrieve response of rules$")
    public void send_a_request_to_retrieve_response_of_rules() throws Throwable {
        Get_rules = given().header("api-version", "2020.3").and().
                auth().oauth2(token).
                when().get("groups/ruleDefinitions");


    }

    @Then("^validate the result of each request$")
    public void validate_the_result_of_each_request() throws Throwable {
        String result = Get_rules.getBody().prettyPrint();
        Assert.assertTrue(result != null);
        Assert.assertEquals(result.contains("errors"), false);

        List<String> ruleEndpoints = Get_rules.jsonPath().get("data.components.datasource");
        System.out.println(ruleEndpoints);

        //validate and match response with GroupRule.json file
        Get_rules.then().assertThat().body(matchesJsonSchemaInClasspath("GroupRule.json"));
        System.out.println(Get_rules.then().assertThat().body(matchesJsonSchemaInClasspath("GroupRule.json")));
    }

}

