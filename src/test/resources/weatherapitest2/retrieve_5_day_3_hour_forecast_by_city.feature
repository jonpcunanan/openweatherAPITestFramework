@ForecastByCityFeature
Feature: Retrieve 5 day 3 hour forecast from weather api
  Everybody wants to know the forecast

  Scenario: Retrieve 5 day 3 hour forecast for Waipahu
    Given User sets up request with id 5854686
    When the response is retrieved
    Then status code should be 200
    And list count should be greater than 10
