package com.utilities.pkg;


import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class Utils{
    //Global Setup Variables
    private static String path;
    private static ReadProperties rp = new ReadProperties();

    //Sets Base URI
    public static void setBaseURI() throws IOException {
        RestAssured.baseURI = rp.readProps("uri");
    }

    public static void cratePath (String resource) throws IOException {
        path = rp.readProps("uri") + resource;
    }

    //Returns response
    public static Response getResponse() {
        String resp = get(path).toString();
        return get(path);
    }

}