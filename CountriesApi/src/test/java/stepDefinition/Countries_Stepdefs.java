package stepDefinition;

import base.TestBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.List;

import static io.restassured.RestAssured.given;
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

        // Response body is not null and no errors.
        String results = Get_1.getBody().prettyPrint();
        Assert.assertTrue(results != null);
        Assert.assertEquals(results.contains("errors"), false);

        //Response Headers
        Headers headers = Get_1.headers();
        for (Header header:headers){logger.info(header.getName()+" = "+header.getValue());}

        // validate status code
        int statuscode = Get_1.getStatusCode();
        Assert.assertEquals(statuscode, 200);

        //validate the response time if time is less then 2000ms
        long responseTime = Get_1.getTime();
            if(responseTime > 500){
                logger.warn("response time is more the 500ms");
            }else{logger.info("Response time is less then 500ms"); }


        //collect only id of each country, and validate id 1247 exist in the list
        List<Integer> IDs = Get_1.jsonPath().get("data.id");
            logger.info(IDs);
        if(IDs.contains(1247)){ logger.info("Country ID = 1247 is present in the List"); }
        else{ logger.warn("Country ID = 1247 does not exist!");}


        //collect only abbreviation of each country and validate if abbreviation XX exist in the lsit.
        List <String> abbreviation = Get_1.jsonPath().getList("data.abbreviation");
        logger.info(abbreviation);
        if(abbreviation.contains("XX")){logger.info("Abbreviation XX exist in the lsit.");}
        else{logger.warn("Abbreviation XX does not exit in the list.");}


        //collect only names of each country and validate if name "abcd....." exist in the lsit.
        List<String> names = Get_1.jsonPath().get("data.name");
        logger.info(names);
        if (names.contains("abcdefghijklmnopqrstuvwxyz")){logger.info("Name abcd.... exist in the list.");}
        else {logger.warn("Name XXstringXX does not exist in the list.");}


        // collect Data Type of each field of any record.
        logger.info("Data Type of data = "+Get_1.jsonPath().get("data").getClass().getSimpleName());
        logger.info("Data Type of id = "+Get_1.jsonPath().get("data[0].id").getClass().getSimpleName());
        logger.info("Data Type of abbreviation  = "+Get_1.jsonPath().get("data[0].abbreviation").getClass().getSimpleName());
        logger.info("Data Type of name = "+Get_1.jsonPath().get("data[0].name").getClass().getSimpleName());
        logger.info("Data Type of  regionLabel= "+Get_1.jsonPath().get("data[0].regionLabel").getClass().getSimpleName());
        logger.info("Data Type of zipLabel = "+Get_1.jsonPath().get("data[0].zipLabel").getClass().getSimpleName());
        logger.info("Data Type of callingCode = "+Get_1.jsonPath().get("data[0].callingCode").getClass().getSimpleName());
        logger.info("Data Type of sortOrder = "+Get_1.jsonPath().get("data[0].sortOrder").getClass().getSimpleName());
        logger.info("Data Type of hasRegions = "+Get_1.jsonPath().get("data[0].hasRegions").getClass().getSimpleName());
        logger.info("Data Type of showInAddressList = "+Get_1.jsonPath().get("data[0].showInAddressList").getClass().getSimpleName());
        logger.info("Data Type of showInCallingCodeList = "+Get_1.jsonPath().get("data[0].showInCallingCodeList").getClass().getSimpleName());
        logger.info("Data Type of meta = "+Get_1.jsonPath().get("meta").getClass().getSimpleName());
        logger.info("Data Type of Customerid = "+Get_1.jsonPath().get("meta.customerId").getClass().getSimpleName());
        logger.info("Data Type of links = "+Get_1.jsonPath().get("links").getClass().getSimpleName());
        logger.info("Data Type of self = "+Get_1.jsonPath().get("links.self").getClass().getSimpleName());





    }


    @Test(priority = 2)
    @And("Version of API, token and payload for a new country were added")
    public void version_of_API_token_and_payload_for_a_new_country_were_added() {
        //Header, version and response set in Post_1.
    }

    @When("send a request to create a new country")
    public void send_a_request_to_create_a_new_country() throws IOException, ParseException {

        /*
        JSONObject payload = new JSONObject();
        payload.put("abbreviation", "XX");
        payload.put("name", "abcdefghijklmnopqrstuvwxyz");
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
        */
        //OR

        FileInputStream fileInputStream = new FileInputStream(new File(".\\JsonFiles\\postPayLoad.json"));
        Post_1 = given().header("api-version", version3).and().contentType("application/json").and().
                auth().oauth2(token).body(IOUtils.toString(fileInputStream, "UTF-8")).
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
        IDnewCountry = Post_1.jsonPath().get("data.id");
        logger.info(IDnewCountry);

        //System.out.println("Lenght of ID = "+Post_1.jsonPath().get("data.id").getClass().getName().length());
        logger.info("Data Type of ID = "+Post_1.jsonPath().get("data.id").getClass().getSimpleName());

    }


    @Test(priority = 3)
    @And("token and version of API were added")
    public void token_and_version_of_API_were_added() {
        //Header, version and response set in GetAfterPost_1.
        //System.out.println(IDnewCountry);
            }

    @When("send a request to retrieve newly created country")
    public void send_a_request_to_retrieve_newly_created_country() {
        GetAfterPost_1 = given().header("api-version", version3).
                auth().oauth2(token).
               when().get(String.format("/countries/%s", IDnewCountry));
               // when().get("/countries/1247");
    }

    @Then("validate the result of newly created country")
    public void validate_the_result_of_newly_created_country() {

        String results = GetAfterPost_1.getBody().prettyPrint();
        int statuscode = GetAfterPost_1.getStatusCode();
        Assert.assertEquals(results.contains("errors"), false);

        Assert.assertTrue(results != null);
        Assert.assertEquals(statuscode, 200);


        //validate the response with postPayload.json file
        String result01 = GetAfterPost_1.getBody().asString();
        GetAfterPost_1.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("PostPayLoad.json"));

        //validate if id = 1247, abbreviation = XX, name = XXstringXX
        Integer id = GetAfterPost_1.jsonPath().get("data.id");
        logger.info("ID = "+id);
        //OR
        //Assert.assertEquals(result01.contains("1247"), true);

        String abbrevuation = GetAfterPost_1.jsonPath().get("data.abbreviation");
        logger.info("Abbreviation = "+abbrevuation);

        String name = GetAfterPost_1.jsonPath().get("data.name");
        logger.info("Name = "+name);


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

        //validate if id = 1247, abbreviation = YY, name = YYstringYY
        logger.info("ID = "+given().header("api-version", version3).
                auth().oauth2(token).
                when().get("/countries/1247").jsonPath().get("data.id"));

        logger.info("Abbreviation = "+given().header("api-version", version3).
                auth().oauth2(token).
                when().get("/countries/1247").jsonPath().get("data.abbreviation"));

        logger.info("Name = "+given().header("api-version", version3).
                auth().oauth2(token).
                when().get("/countries/1247").jsonPath().get("data.name"));
        /*
        Integer id = Put_1.jsonPath().get("data.id");
        logger.info("ID = "+id);
        //OR
        //Assert.assertEquals(results.contains("1247"), true);

        String abbrevuation = Put_1.jsonPath().get("data.abbreviation");
        logger.info("Abbreviation = "+abbrevuation);

        String name = Put_1.jsonPath().get("data.name");
        logger.info("Name = "+name);
        */
        //validate the response with PutPayLoad.json file
        given().header("api-version", version3).
        auth().oauth2(token).
        when().get("/countries/1247").then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("PutPayLoad.json"));



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

        //collect all headers for delete a country request.
        Headers headers = Delete_1.headers();
        for (Header header:headers){logger.info(header.getName()+" = "+header.getValue());}


        logger.info("Country Id = 124 has been deleted. ");

            }


}
