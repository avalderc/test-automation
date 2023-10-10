package com.builder;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class ApiBuilder {
    private ApiConfig apiConfig;
    private static RequestSpecification requestSpecs;
    public ApiBuilder (ApiConfig ac){
        this.apiConfig = ac;
    }
    public static ApiBuilder apiBuilder(){
        return new ApiBuilder(new ApiConfig());
    }
    public ApiBuilder withApiURL(String url){
        apiConfig.setApiUrl(url);
        return this;
    }
    public ApiBuilder withMethod(String method){
        apiConfig.setMethod(method);
        return this;
    }
    public ApiBuilder withHeaders(Headers headers){
        apiConfig.setHeaders(headers);
        return this;
    }

    public ApiBuilder withBody(String body){
        apiConfig.setBodyRequest(body);
        return this;
    }
    public ApiConfig build(){
        requestSpecs = RestAssured.given();
        if( apiConfig.getHeaders() != null) requestSpecs.headers(apiConfig.getHeaders());
        if( apiConfig.getBodyRequest() != null ) requestSpecs.body(apiConfig.getBodyRequest());
        apiConfig.setReqSpec(requestSpecs);
        return apiConfig;
    }
}
