# YocketTest

# Selenium project template:

This is web automation framework, implemented using Java, Selenium/Webdriver, TestNG & Maven. Page Object Model (POM) is used to make the code more readable, maintainable, and reusable.

## Prerequisite

- Java
- Maven 
- Selenium WebDriver
- TestNg Browsers (Firefox, Chrome, Edge)
- Intellij or Eclipse 
- allure2

## Page Objects Pattern

Page Objects Pattern page object pattern is used to have reusable WebElements/small helper methods separated from actual test classes and give the opportunity to have nice structured and easily readable tests.

Page:
for every page in web/mobile app, we need to create separate page java class.
never use assertions in page class.
page actions need to provide the page behaviour.
page locators(BY) should be private and will be accessed via public page actions.

Test: -- have to use a test client : TestNG/Junit/Pytest/Nunit/Jasmine/Mocha -- assertions should be written in test class -- never use driver apis in test class


# DriverFactory
DriverFactory class used to initialize the webdriver, initialize the properties and taking screenshot.
This class is responsible for loading drivers and properties file.


# BaseTest
This testing pattern was implemented on the BaseTest class to automatically run the 
the pre (setup) and post (teardown) conditions.

The pre-condition uses @BeforeTest from TestNG, creates the browser instance based on the values passed either local or remote execution. The post-condition uses @AfterTest to close the browser instance. Both have the alwaysRun parameter as true to force the run on a pipeline.

# TestListener
The TestListener is a class that implements ITestListener. The following method is used to help logging errors and attach additional information to the test report:

onTestStart: add the browser information into the test report

onTestFailure: log the exceptions and add a screenshot to the test report

onTestSkipped: add the skipped test on the log

# Parallel execution
The parallel test execution is based on the parallel tests feature on TestNG. This is used by parallel.xml test suite file which has the parallel="tests" attribute and value, whereas test item inside the test suite will execute in parallel. The browser in use for each test should be defined by a parameter, like:


`<parameter name="browser" value="chrome"/>`

## Sameple Test Cases Covered:

## https://yocket.com/

- HomePageTest
- UniversityCollegeFinderTest
- DreamEducationTest
- UndergradTest
- TestScoresPageTest
- ExperienceCountPageTest
- UniversitiesPageTest

## Git Commands

- From project loaction > git version [to know the version]
- From project loaction> git init [to create initiate git folder hidden]
- From project loaction> git status
- From project loaction> git add with file [example: Git add pom.xml]
- From project loaction> git commit -m "Your comment"
- From project loaction> git remote add origin https://github.com/Username/RepositoryName
- From project loaction> git push -u origin master [to push your code remotly with first time]

## Execute Commands

To execute tests run

`mvn clean test`

To generate a report run

`allure serve allure-results`
