# openweatherAPITestFramework
A test project I created for calling the open weather api and retrieving some forecasts.  The framework uses Java, TestNG, Maven, Cucumber and more.

Getting Started:

1. Sign up for a open weather api account.
https://home.openweathermap.org/users/sign_up

2. After signing in, browse to api keys page.
https://home.openweathermap.org/api_keys

3. Run the tests via Maven.  Pass your api key from step 2 as an argument to maven. Remove and replace {your api key from open weather api goes here} with your api key.
test -DWEATHER_API_KEY="{your api key from open weather api goes here}"
