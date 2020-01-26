package weatherapitest2.steps;

import config.ConfigLoader;
import constants.StringConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.specification.RequestSpecification;
import com.jc.model.*;
import org.testng.Assert;
import testcontext.TestContext;

import static constants.StringConstants.MVN_WEATHER_API_KEY_SYSTEM_VARIABLE_KEY;
import static io.restassured.RestAssured.given;

public class FiveDay3HourForecastByZipSteps {

    private TestContext testContext;
    private ConfigLoader configLoader;

    public FiveDay3HourForecastByZipSteps(TestContext testContext, ConfigLoader configLoader) {
        this.testContext = testContext;
        this.configLoader = configLoader;
    }

    @Given("User sets up request with {int}")
    public void user_sets_up_request_with(Integer int1) {
        RequestSpecification request = given().baseUri(StringConstants.WEATHER_API_5_DAY_3_HOUR_FORECAST)
                .queryParam("zip", int1, "us")
                .queryParam(StringConstants.APPID_KEY,
                        System.getProperty(MVN_WEATHER_API_KEY_SYSTEM_VARIABLE_KEY));
        this.testContext.setRequest(request);
    }

    @And("city should be {string}")
    public void cityShouldBeWaipahu(String city) {
        FiveDayThreeHourWeatherAPIResponse weatherResponse = this.testContext.getResponse().getBody().as(FiveDayThreeHourWeatherAPIResponse.class);
        Assert.assertEquals(city, weatherResponse.getCity().getName());
    }
}
