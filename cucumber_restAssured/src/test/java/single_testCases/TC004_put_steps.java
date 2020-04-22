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

public class TC004_put_steps extends TestBase_cucumber {
    @BeforeClass
    @Given("set PUT a country endpoint")
    public void set_PUT_a_country_endpoint() {
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
    @When("set put request with HEADERS, Token, updated Payload for PUT")
    public void set_post_request_with_HEADERS_Token_updated_Payload_for_PUT() {
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

        Put_1 = given().header("api-version", "2020.3").and().contentType("application/json").and().
                auth().oauth2(token).body(ppayload).
                when().put("https://devtest.smartbutton.com/webapi/countries/1247");
    }

    @Then("Send Put Request and validate response after Put.")
    public void send_Post_Request_and_validate_response_after_Put() {
        String results = Put_1.getBody().prettyPrint();
        int statuscode = Put_1.getStatusCode();
        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);
    }


}
