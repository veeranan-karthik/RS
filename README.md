###### RS Test Automation Framework

The framework incorporates design principle of BDD (Behaviour driven development) which promotes
writing acceptance tests by describing behaviour of application under test in simple english language from
the perspective of its stakeholders.
Having test written in Natural language helps the Project Team
(Product Owners, Business Analysts, Development and QA team) to understand and track the requirements

Supports Custom Page Object model and encapsulates the fields represented by a page, which ultimately avoids duplication and improves code maintainability and readability.

###### Notes about the Test Framework

This Test Framework is built with following tech stack:

Java
Selenium 3+
Cucumber
Maven
TestNG

###### How to run the tests

Clone the repostory locally (git clone https://bothi@bitbucket.org/bothi/testautomation.git)
Create a TestNG Runner with following VM options (Framework supports running tests using latest firefox and chrome browsers)
Runner Class to be selected is : com.rscomponent.RunCuckesTest -Dbrowser=chrome -Dcucumber.options="--tags @search"
WebDriverManager:
WebDriverManager dependency used to download the Browser Drivers on the fly.

###### Sample Test:

For simplicity, a test written to open the traceparts.com website and perform a search and navigate to PDP page to verify product informations. 
PageFactory model is used to initialise locators.