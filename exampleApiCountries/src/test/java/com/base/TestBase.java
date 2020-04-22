package com.base;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.response.Response;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {


    public static String token;
    public Logger logger;
    public static String version3;

    @BeforeClass
    public void setup() throws IOException {

        //read  a file
        Properties configpro = new Properties();
        InputStream configproFile = new FileInputStream("config.properties");
        configpro.load(configproFile);
        version3= configpro.getProperty("version");

        //RestAssured.authentication = RestAssured.
        logger = Logger.getLogger("RestApi"); //add loggers
        PropertyConfigurator.configure("log4j.properties"); //add log with configurations set in log4j.property
        logger.setLevel(Level.DEBUG);




    }
}
