package single_testCases;

import C_Base.TestBase_cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC006_Delete extends TestBase_cucumber {
    @BeforeClass
    @Given("set Delete country api endpoints")
    public void set_Delete_country_api_endpoints() {
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
    @When("set request HEADERS and token for delete")
    public void set_request_HEADERS_and_token_for_detele() {
        Delete_1 = given().header("api-version", "2020.2").and().
                auth().oauth2(token).
                when().delete("/webapi/countries/1247");
    }

    @Then("send DELETE HTTP request and validate response")
    public void send_DELETE_HTTP_request_and_validate_response() {
        String results = Delete_1.getBody().prettyPrint();
        int statuscode = Delete_1.getStatusCode();
        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);
    }

}
