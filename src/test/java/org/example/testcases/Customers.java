package org.example.testcases;

import io.restassured.specification.RequestSpecification;
import org.example.base.Base;
import org.testng.annotations.Test;

public class Customers extends Base {

    @Test
    public void getbalance200ok(){
        setbaseURI();
        setaccesstoken("valid");
        get("/v1/balance");
        verify200ok();
    }
    @Test
    public void getbalance401(){
        setbaseURI();
        setaccesstoken("invalid");
        get("/v1/balance");
        verify401unauthorized();
    }

    public void geturl(){

    }
}
