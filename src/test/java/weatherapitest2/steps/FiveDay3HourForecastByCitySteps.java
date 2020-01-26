package weatherapitest2.steps;

import com.jc.model.FiveDayThreeHourWeatherAPIResponse;
import config.ConfigLoader;
import constants.StringConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import testcontext.TestContext;

import java.util.List;

import static constants.StringConstants.MVN_WEATHER_API_KEY_SYSTEM_VARIABLE_KEY;
import static io.restassured.RestAssured.given;

public class FiveDay3HourForecastByCitySteps {

    private TestContext testContext;
    private ConfigLoader configLoader;

    public FiveDay3HourForecastByCitySteps(TestContext testContext, ConfigLoader configLoader) {
        this.testContext = testContext;
        this.configLoader = configLoader;
    }

    @Given("User sets up request with id {int}")
    public void userSetsUpRequestWithId(int cityID) {
        RequestSpecification request = given().baseUri(StringConstants.WEATHER_API_5_DAY_3_HOUR_FORECAST)
                .queryParam("id", cityID)
                .queryParam(StringConstants.APPID_KEY,
                        System.getProperty(MVN_WEATHER_API_KEY_SYSTEM_VARIABLE_KEY));
        this.testContext.setRequest(request);
    }

    @And("list count should be greater than {int}")
    public void listCountShouldBeGreaterThan(int arg0) {
        List<com.jc.model.List> list =
                this.testContext.getResponse().getBody().as(FiveDayThreeHourWeatherAPIResponse.class).getList();
        Assert.assertTrue(list.size() > 0,"Forecast list size is not greater than 0");
    }
}
