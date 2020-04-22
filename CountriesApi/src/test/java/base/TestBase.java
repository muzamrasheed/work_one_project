package base;

import io.restassured.response.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {

    public static Response Get_1;
    public static Response Post_1;
    public static Response GetAfterPost_1;
    public static Response Put_1;
    public static Response Delete_1;
    public static String token;
    public Logger logger;
    public static String version3;
    public static String BaseURI;
    public static String clinet_id;
    public static String client_secret;
    public static String grant_type;
    public static String api_domain;
    public static String postURLforToken;
    public static int IDnewCountry;


    @BeforeClass
    public void setuptestbase() throws IOException {

        // reading logger properties
        logger = Logger.getLogger("Api"); //add loggers
        PropertyConfigurator.configure("log4j.properties"); //add log with configurations set in log4j.property
        logger.setLevel(Level.DEBUG);
        logger.info("__________________________________________");
        //
        //Reading data properties
        //read  a file
        Properties configure = new Properties();
        InputStream TestFile = new FileInputStream("devtest.properties");
        configure.load(TestFile);
        version3= configure.getProperty("version");
        BaseURI=configure.getProperty("BaseURI");
        clinet_id=configure.getProperty("client_ID");
        client_secret=configure.getProperty("client_secret");
        grant_type=configure.getProperty("grant_type");
        api_domain=configure.getProperty("api_domain");
        postURLforToken=configure.getProperty("post");




    }
}
