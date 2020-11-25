package com.glue.code.pkg;


import com.utilities.pkg.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertEquals;

public class StepDefAPI extends Utils {

    private Response response;
    private JsonPath js;

    @Given("^To initiate Rest service to get Carbon Credits API response$")
    public void to_Initiate_Rest_Service_To_Get_Charities_List() throws Throwable {
        setBaseURI();
        cratePath("/v1/Categories/6327/Details.json");
        response = getResponse();
    }

    @When("^Response status code should be \"([^\"]*)\"$")
    public void response_status_code_should_be(Integer arg1) throws Throwable {
        assertEquals("Status Check Failed!", (long)arg1, response.getStatusCode());
    }

    @Then("In the response the attribute {string} should return value as {string}")
    public void in_the_response_the_attribute_should_return_value_as_name(String attribute, String value) {
        response.then().body(attribute, equalTo(value));
    }

    @Then("In the response the attribute {string} returns value as true")
    public void in_the_response_the_attribute_returns_value_as_true(String attribute) {
        response.then().body(attribute, equalTo(true));
    }

    @When("In the response the {string} element has a data with {string} = {string}")
    public void in_the_response_the_element_has_a_data_with(String string, String string2, String string3) {
        response.then().body("Promotions.Name", hasItem("Gallery"));
    }

    @Then("In the response the {string} element with {string} = {string} has {string} that contains the text {string}")
    public void in_the_response_the_element_with_has_a_that_contains_the_text(String att1, String att2, String value1, String att3, String expectedResult) {
        js = new JsonPath(response.asString());
        int count =	js.getInt(att1+".size()");

        String value = null;

        for (int i=0;i<count;i++) {
            String att2Value = js.get(att1+"["+i+"]."+att2);
            if(att2Value.equalsIgnoreCase(value1))
            {
                value = js.get(att1+"["+i+"]."+att3);
                break;
            }
        }
        assertEquals(expectedResult,value);
    }

}
