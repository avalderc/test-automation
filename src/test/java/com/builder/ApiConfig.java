package com.builder;

import io.restassured.http.Headers;
import io.restassured.specification.RequestSpecification;

public class ApiConfig {
    private String apiUrl;
    private String method;
    private Headers headers;
    private String bodyRequest;
    private RequestSpecification reqSpec;

    public RequestSpecification getReqSpec() {
        return reqSpec;
    }

    public void setReqSpec(RequestSpecification reqSpec) {
        this.reqSpec = reqSpec;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }

    public String getBodyRequest() {
        return bodyRequest;
    }

    public void setBodyRequest(String bodyRequest) {
        this.bodyRequest = bodyRequest;
    }
}
