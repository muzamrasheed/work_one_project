package single_testCases;

import C_Base.TestBase_cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC002_post_setps extends TestBase_cucumber {

    @BeforeClass
    @Given("set post a country endpoint")
    public void set_post_a_country_endpoint() {
        RestAssured.baseURI = "https://devtest.smartbutton.com";
        Response resp = RestAssured.
                given().
                formParam("client_ID", "41pDdTgdvZ1hCNCs").
                formParam("client_secret", "Wfy1jJyHPQXqyrMgt5FG7tc1").
                formParam("grant_type", "client_credentials").
                formParam("api_domain", "https://devtest.smartbutton.com/webapi").
                post("https://devtest.smartbutton.com/auth/connect/token");
        token = resp.jsonPath().get("access_token");
    }
    @Test
    @When("set post request with HEADERS, Token, Payload")
    public void set_post_request_with_HEADERS_Token_Payload() {
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

        Post_1 = given().header("api-version", "2020.3").and().contentType("application/json").and().
                auth().oauth2(token).body(payload).
                when().post("https://devtest.smartbutton.com/webapi/countries");


    }
    @Then("Send Post Request and validate response")
    public void send_Post_Request_and_validate_response() {
        String results = Post_1.getBody().prettyPrint();
        int statuscode = Post_1.getStatusCode();
        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);

    }
}
