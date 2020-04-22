package single_testCases;

import C_Base.TestBase_cucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;



public class TC001_get_steps extends TestBase_cucumber {
    @BeforeClass
    @Given("Endpoint /counties is available")
    public void setGETListOfCountiresApiEndpoints() throws IOException {
        Properties configpro = new Properties();
        InputStream configproFile = new FileInputStream("configcucu.properties");
        configpro.load(configproFile);
        version= configpro.getProperty("version");

        System.out.println(version);
        RestAssured.baseURI = "https://devtest.smartbutton.com/webapi/";
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
    @When("set request HEADERS")
    public void set_request_HEADERS() {
        Get_1 = given().header("api-version", "2020.3").and().
                auth().oauth2(token).
                when().get("groups/ruleDefinitions");


    }

     @Then("send GET HTTP request and validate response")
    public void send_GET_HTTP_request() {
        String results = Get_1.getBody().prettyPrint();
        int statuscode = Get_1.getStatusCode();
        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);

    }
}
