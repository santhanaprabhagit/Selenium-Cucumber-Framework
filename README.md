# Selenium Cucumber Framework

---

## Framework Purpose
This project aims to give an inspiring or sample of automation test framework that uses Selenium and Cucumber with Java as the programming language.Sample web page used to test : https://www.automationexercise.com/ Please register at the above website and update your credentials into configuration.properties

---

## Tools and Libraries
This project using 2 main tools, Selenium and Cucumber.
On the other hand, I using some of the tools that support this great framework.
The complete list of tools, you can see in the `pom.xml` file.

## Requirements
* Java Development Kit
* Maven
* WebDriverChromeDriver

## Running Tests
* Clone the repository from your fork to this directory
* Open the project using any Java IDE
* Run the tests with the script below

```shell
$ mvn clean install
```
* If you want to run the specific test, use the cucumber tags like this
```shell
$ mvn clean install -Dcucumber.filter.tags="@REPLACE_WITH_ANY_TAGS_THAT_YOU_WANT"
```

## Test Results
* Test report automatically generated on `target` folder after finished the test execution
* See test report from `target/cucumber-reports/advanced-reports/cucumber-html-reports/overview-features.html`
* You can also share your Cucumber Report with another person at https://reports.cucumber.io, just go to `src/test/resources/cucumber.properties` then change the value to be `true` and add your collection token from cucumber.io account.
  (Note: Suggest using github credentials to log in to cucumber.io)
```properties
cucumber.publish.enabled=true
```
* For more information about reports cucumber you can go to https://reports.cucumber.io/docs/cucumber-jvm

---
