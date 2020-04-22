package com.APIs;

import com.base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;


public class Countries_Stepdefs extends TestBase {

    @Before
    public void setup() throws IOException {
        setuptestbase();
    }
    @Given("endpoint\\/countries is available, and generate the access token.")
    public void endpoint_countries_is_available_and_generate_the_access_token() {

        RestAssured.baseURI = BaseURI;
            Response resp = RestAssured.given().
            formParam("client_ID", clinet_id).
            formParam("client_secret", client_secret).
            formParam("grant_type", grant_type).
            formParam("api_domain", api_domain).
            post(postURLforToken);
            token = resp.jsonPath().get("access_token");
    }


    @Test(priority = 1)
    @And("version of API and token were added")
    public void version_of_API_and_token_were_added() {
        //Header, version and response set in Get_1.
    }

    @When("send a request to retrieve a lis of countries")
    public void send_a_request_to_retrieve_a_lis_of_countries() {
        Get_1 = given().header("api-version", version3).and().
                auth().oauth2(token).
                when().get("/countries");
    }

    @Then("validate the result of sent request")
    public void validate_the_result_of_sent_request() {

        // Response is not null and no errors.
        String results = Get_1.getBody().prettyPrint();
        Assert.assertTrue(results != null);
        Assert.assertEquals(results.contains("errors"), false);

        // validate status code
        int statuscode = Get_1.getStatusCode();
        Assert.assertEquals(statuscode, 200);

        //validate the response time if time is less then 2000ms
        long responseTime = Get_1.getTime();
            if(responseTime > 500){
                System.out.println("response time is more the 500ms");
            }System.out.println("Response time is less then 500ms");

        //collect only names of each country
        List<String> names = Get_1.jsonPath().get("data.name");
            System.out.println(names);

        //collect only id of each country
        List<Integer> IDs = Get_1.jsonPath().get("data.id");
            System.out.println(IDs);
    }


    @Test(priority = 2)
    @And("Version of API, token and payload for a new country were added")
    public void version_of_API_token_and_payload_for_a_new_country_were_added() {
        //Header, version and response set in Post_1.
    }

    @When("send a request to create a new country")
    public void send_a_request_to_create_a_new_country() {

        JSONObject payload = new JSONObject();
        payload.put("abbreviation", "XX");
        payload.put("name", "XXstringXX");
        payload.put("regionLabel", "string");
        payload.put("zipLabel", "string");
        payload.put("callingCode", 0);
        payload.put("sortOrder", 0);
        payload.put("hasRegions", true);
        payload.put("showInAddressList", true);
        payload.put("showInCallingCodeList", true);

        Post_1 = given().header("api-version", version3).and().contentType("application/json").and().
                auth().oauth2(token).body(payload).
                when().post("/countries");

    }

    @Then("match the result of a new country with \"postPayload.json\"")
    public void validate_the_result_of_a_new_country() {
        // Response is not null and no errors.
        String results = Post_1.getBody().prettyPrint();
        Assert.assertTrue(results != null);
        Assert.assertEquals(results.contains("errors"), false);
        //validate the response Code
        int statuscode = Post_1.getStatusCode();
        Assert.assertEquals(statuscode, 200);
        //collect the id of new new country
        int IDnewCountry = Post_1.jsonPath().get("data.id");
        System.out.println(IDnewCountry);

    }


    @Test(priority = 3)
    @And("token and version of API were added")
    public void token_and_version_of_API_were_added() {
        //Header, version and response set in GetAfterPost_1.
            }

    @When("send a request to retrieve newly created country")
    public void send_a_request_to_retrieve_newly_created_country() {
        GetAfterPost_1 = given().header("api-version", version3).
                auth().oauth2(token).
                when().get("/countries/1247");
    }

    @Then("validate the result of newly created country")
    public void validate_the_result_of_newly_created_country() {
        String results = GetAfterPost_1.getBody().prettyPrint();
        int statuscode = GetAfterPost_1.getStatusCode();
        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);
        Assert.assertEquals(results.contains("errors"), false);

        //validate the response with postPayload.json file
        String result01 = GetAfterPost_1.getBody().asString();
        assertThat(result01, matchesJsonSchemaInClasspath("PostPayload.json"));
    }


    @Test(priority = 4)
    @And("Version of API, token and payload to update name and abbriviation of newly created country were added")
    public void version_of_API_token_and_payload_to_update_name_and_abbriviation_of_newly_created_country_were_added() {
        //Header, version and response set in Put_1.
    }

    @When("send the request to update the country")
    public void send_the_request_to_update_the_country() {
        JSONObject ppayload = new JSONObject();
        ppayload.put("abbreviation","YY");
        ppayload.put("name", "YYstringYY");
        ppayload.put("regionLabel", "string");
        ppayload.put("zipLabel", "string");
        ppayload.put("callingCode", 0);
        ppayload.put("sortOrder", 0);
        ppayload.put("hasRegions", true);
        ppayload.put("showInAddressList", true);
        ppayload.put("showInCallingCodeList", true);

        Put_1 = given().header("api-version", version3).and().contentType("application/json").and().
                auth().oauth2(token).body(ppayload).
                when().put("/countries/1247");
    }

    @Then("collect the response and match with \"PutPayload.json\"")
    public void collect_the_response_and_validate() {
        String results = Put_1.getBody().prettyPrint();
        int statuscode = Put_1.getStatusCode();
        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);
        Assert.assertEquals(results.contains("errors"), false);

    }

    @Test(priority = 5)
    @And("Api version and token were added")
    public void api_version_and_token_were_added() {
            //Header, version and response set in Delete_1.
    }

    @When("send a request to delete record of newly created country")
    public void send_a_request_to_delete_record_of_newly_created_country() {
        Delete_1 = given().header("api-version", version3).and().
                auth().oauth2(token).
                when().delete("/countries/1247");
    }

    @Then("validate the response of deleted record")
    public void validate_the_response_of_deleted_record() {
        String results = Delete_1.getBody().prettyPrint();
        int statuscode = Delete_1.getStatusCode();
        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);
        Assert.assertEquals(results.contains("errors"), false);

            }


}
