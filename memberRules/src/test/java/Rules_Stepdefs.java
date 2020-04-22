import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;

public class Rules_Stepdefs {

    public static String token;
    public static Response Get_rules;
    public static Response Get;
    String number=restUtil.resultNumber();



    @Test(priority = 1)
    @Given("version of API and token were added")
    public void version_of_API_and_token_were_added() {
        RestAssured.baseURI = "https://devtest.smartbutton.com/webapi/";
        Response resp = RestAssured.
                given().
                formParam("client_ID", "5099845915049341").
                formParam("client_secret", "k9gbN2kQzWC5N1sLFy7QnXhb").
                formParam("grant_type", "client_credentials").
                formParam("api_domain", "https://devtest.smartbutton.com/webapi").
                post("https://devtest.smartbutton.com/auth/connect/token");
        token = resp.jsonPath().get("access_token");

    }

    @When("send a request to retrieve response of rules")
    public void send_a_request_to_retrieve_response_of_rules() {
        Get_rules = given().header("api-version", "2020.3").and().
                auth().oauth2(token).
                when().get("groups/ruleDefinitions");


    }

    @Then("validate the result of each request with json validation")

    public void validate_the_result_of_each_request() {

       String result = Get_rules.getBody().prettyPrint();
              // Assert.assertTrue(result != null);
       // System.out.println("test validation with G values ");

       // JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze()).freeze();
       // Get_rules.then().assertThat().body(matchesJsonSchemaInClasspath("GroupRule.json").using(settings().with().checkedValidation(false)));
      // System.out.println( Get_rules.then().assertThat().body(matchesJsonSchemaInClasspath("GroupRule.json")));
        System.out.println("test validation with 16 values ");
        String result01 = Get_rules.getBody().asString();
        assertThat(result01, matchesJsonSchemaInClasspath("GroupRule.json"));
        System.out.println("test validation with 16 values ");









    }
   /*
    @Test(priority = 2)
    @Given("version of API and token were added for extraction")
    public void version_of_API_and_token_were_added_for_extraction() {
        RestAssured.baseURI = "https://devtest.smartbutton.com/webapi/";
        Response resp = RestAssured.
                given().
                formParam("client_ID", "5099845915049341").
                formParam("client_secret", "k9gbN2kQzWC5N1sLFy7QnXhb").
                formParam("grant_type", "client_credentials").
                formParam("api_domain", "https://devtest.smartbutton.com/webapi").
                post("https://devtest.smartbutton.com/auth/connect/token");
        token = resp.jsonPath().get("access_token");

    }

    @When("send a request to extract all api queries from response")
    public void send_a_request_to_extract_all_api_queries_from_response() {

        Get_rules=given().header("api-version", "2020.3").and().
                auth().oauth2(token).
                get("groups/ruleDefinitions");
           }

    @Then("log all queries")
    public void log_all_queries() throws IOException, ParseException {
        System.out.println("extraction has been complete");
    }*/

    @Test(priority = 3)
    @Given("version of API and token are set")
    public void version_of_API_and_token_are_set() {
        RestAssured.baseURI = "https://devtest.smartbutton.com/webapi/";
        Response resp = RestAssured.
                given().
                formParam("client_ID", "5099845915049341").
                formParam("client_secret", "k9gbN2kQzWC5N1sLFy7QnXhb").
                formParam("grant_type", "client_credentials").
                formParam("api_domain", "https://devtest.smartbutton.com/webapi").
                post("https://devtest.smartbutton.com/auth/connect/token");
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
        System.out.println("test 2 valuses ");
    }

}




