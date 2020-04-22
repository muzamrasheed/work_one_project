package com.APIs;
import com.base.TestBase;
import com.utility.restUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.given;


public class GroupRuleOptions_StepDef extends TestBase {

    public static Response Get;
    String number= restUtil.resultNumber();


    @Given("version of API and token are set")
    public void version_of_API_and_token_are_set() {
        RestAssured.baseURI = BaseURI;
        Response resp = RestAssured.given().
                formParam("client_ID", clinet_id).
                formParam("client_secret", client_secret).
                formParam("grant_type", grant_type).
                formParam("api_domain", api_domain).
                post(postURLforToken);
        token = resp.jsonPath().get("access_token");
    }

    @When("send a request to retrieve result of each {string}")
    public void send_a_request_to_retrieve_result_of_each(String apiQuery) {
        Get = given().header("api-version", "2020.3").and().
                auth().oauth2(token).
                when().get(apiQuery);
    }


    @Then("collect the response of each api.")
    public void collect_the_response_of_each_api() {

        String resultQuery=Get.getBody().prettyPrint();
        Assert.assertEquals(resultQuery.contains("errors"), false);
        System.out.println(number);

    }
}
