package C_Base;

import C_Utility.util;
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

public class TestBase_cucumber {

    public static Response Get_1;
    public static Response Post_1;
    public static Response GetAfterPost_1;
    public static Response Put_1;
    public static Response GetAfterPut_1;
    public static Response Delete_1;
    public static String token;
    public  static Logger logger; //variable of Logger class
    public static String version;

    @BeforeClass
    public void setup() throws IOException {

        //read  a file
        Properties configpro = new Properties();
        InputStream configproFile = new FileInputStream("configcucu.properties");
        configpro.load(configproFile);
        version= configpro.getProperty("version");
        //

        logger = Logger.getLogger("RestApi"); //add loggers
        PropertyConfigurator.configure("log4j.properties"); //add log with configurations set in log4j.property
        logger.setLevel(Level.DEBUG);

    }


}
