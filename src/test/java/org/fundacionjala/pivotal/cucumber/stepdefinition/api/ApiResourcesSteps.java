package org.fundacionjala.pivotal.cucumber.stepdefinition.api;

import java.util.Map;

import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.fundacionjala.pivotal.api.Mapper.addResponse;
import static org.fundacionjala.pivotal.api.Mapper.mapEndpoint;
import static org.fundacionjala.pivotal.api.RequestManager.deleteRequest;
import static org.fundacionjala.pivotal.api.RequestManager.getRequest;
import static org.fundacionjala.pivotal.api.RequestManager.postRequest;
import static org.fundacionjala.pivotal.api.RequestManager.putRequest;
import static org.junit.Assert.assertEquals;

/**
 * This class provide the basic step definitions to work with api rest requests
 * <p>
 *
 * @author Henrry Salinas.
 */
public class ApiResourcesSteps {

    private Response response;


    private String endPoint;

    @Given("^I have the (.*) endpoint$")
    public void iHaveTheEndpoint(String endPoint) {
        this.endPoint = mapEndpoint(endPoint);
    }

    @When("^I send a GET request to (.*) endpoint$")
    public void iSendAGETRequest(String endPoint) {
        response = getRequest(endPoint);
    }

    @When("^I sen(?:d|t) a POST request to (.*)$")
    public void iSendAPOSTRequestWith(String endPoint, Map<String, Object> parameters) {
        response = postRequest(mapEndpoint(endPoint), parameters);
    }

    @When("^I send a PUT request to (.*?)$")
    public void iSendAPUTRequest(String endPoint, Map<String, Object> parameters) {
        response = putRequest(mapEndpoint(endPoint), parameters);
    }

    @When("^I send a DELETE request$")
    public void iSendADELETERequest() {
        response = deleteRequest(endPoint);
    }

    @And("^stored as (.*)")
    public void storedAs(String key) {
        addResponse(key, response);
    }

    @Then("^I expect the status code (\\d+)$")
    public void iExpectStatusCode(int statusCodeExpected) {
        assertEquals(statusCodeExpected, response.statusCode());
    }

    public Response getResponse() {
        return response;
    }

}
