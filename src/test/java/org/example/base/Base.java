package org.example.base;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import javax.swing.text.Utilities;
import java.util.Properties;
import java.util.logging.Logger;

public class Base {
utilities utility=new utilities();
Properties properties=utility.readproperties();
RequestSpecification requestSpecification;
Response response;
String env="test";
Logger logger=Logger.getLogger("");

public void setbaseURI(){
    //env=System.getProperty("envt");
    switch (env){
        case "dev": {
            requestSpecification = given().baseUri(properties.getProperty("devBaseURI"));
            logger.info("the enviroment was set to development");
            break;
        }
        case "test": {
            requestSpecification = given().baseUri(properties.getProperty("testBaseURI"));
            logger.info("the enviroment was set to test");
            break;
        }
        case "staging": {
            requestSpecification = given().baseUri(properties.getProperty("stagingBaseURI"));
            logger.info("the enviroment was set to staging");
            break;
        }
        default:{
            logger.info("No env is set so the default env is dev");
            requestSpecification = given().baseUri(properties.getProperty("devBaseURI"));
        }
    }

    }
    public void setaccesstoken(String type){
    switch (type){
        case "valid":
            requestSpecification=requestSpecification.auth().oauth2(properties.getProperty("apikey"));
            break;
        case "invalid":
            requestSpecification=requestSpecification.auth().oauth2("invald");
            break;
        case "null":
            requestSpecification=requestSpecification.auth().oauth2(null);
            break;
        default:
            logger.info("setting valid value to default access token as no valid type was pased");
            requestSpecification=requestSpecification.auth().oauth2(properties.getProperty("apikey"));
    }
    }
    public void get(String basepath){
    response=requestSpecification.log().all().when().get(basepath);
    response.prettyPrint();
    }

    public void verify200ok(){
    response.then().statusCode(200);
    }
    public void verify401unauthorized(){
    response.then().statusCode(401);
    }


public void rough(){
    System.out.println(properties.getProperty("BaseURI"));
}
}
