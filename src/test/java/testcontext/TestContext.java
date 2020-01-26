package testcontext;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TestContext {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public ValidatableResponse getJson() {
        return json;
    }

    public void setJson(ValidatableResponse json) {
        this.json = json;
    }

    public RequestSpecification getRequest() {
        return request;
    }

    public void setRequest(RequestSpecification request) {
        this.request = request;
    }
}
