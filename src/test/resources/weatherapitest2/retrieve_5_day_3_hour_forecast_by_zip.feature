@ForecastByZipcodeFeature
Feature: Retrieve 5 day 3 hour forecast from weather api
  Everybody wants to know the forecast

  Scenario: Retrieve 5 day 3 hour forecast for Waipahu
    Given User sets up request with 96797
    When the response is retrieved
    Then status code should be 200
    And city should be 'Waipahu'