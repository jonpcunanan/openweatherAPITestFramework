package weatherapitest2.steps;

import config.ConfigLoader;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import testcontext.TestContext;

public class CommonSteps {

    private TestContext testContext;
    private ConfigLoader configLoader;

    public CommonSteps(TestContext testContext, ConfigLoader configLoader) {
        this.testContext = testContext;
        this.configLoader = configLoader;
    }

    @When("the response is retrieved")
    public void the_response_is_retrieved() {
        this.testContext.setResponse(testContext.getRequest().when().log().all().get());
    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer int1) {
        Assert.assertEquals(HttpStatus.SC_OK,
                this.testContext.getResponse().statusCode());
    }
}
