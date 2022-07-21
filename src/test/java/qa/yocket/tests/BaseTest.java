package qa.yocket.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import qa.yocket.factory.DriverFactory;
import qa.yocket.pages.DreamEducationPage;
import qa.yocket.pages.ExperienceCountPage;
import qa.yocket.pages.HomePage;
import qa.yocket.pages.TestScoresPage;
import qa.yocket.pages.UndergradPage;
import qa.yocket.pages.UniversitiesPage;
import qa.yocket.pages.UniversityCollegeFinderPage;

public class BaseTest {
	DriverFactory driverFactory;
	Properties prop;
	WebDriver driver;
	HomePage homePage;
	UniversityCollegeFinderPage universityCollegeFinderPage;
	DreamEducationPage dreamEducationPage;
	UndergradPage undergradPage;
	TestScoresPage testScoresPage;
	ExperienceCountPage experienceCountPage;
	UniversitiesPage universitiesPage;

	@Parameters({"browser"})
	@BeforeTest(alwaysRun = true)
	public void setup(@Optional String browser) {
		driverFactory = new DriverFactory();
		prop = driverFactory.init_prop();
		if(browser!=null) {
			prop.setProperty("browser", browser);
		}
		driver = driverFactory.initDriver(prop);
		homePage = new HomePage(driver);
		universityCollegeFinderPage = new UniversityCollegeFinderPage(driver);
		dreamEducationPage = new DreamEducationPage(driver);
		undergradPage = new UndergradPage(driver);
		testScoresPage = new TestScoresPage(driver);
		experienceCountPage = new ExperienceCountPage(driver);
		universitiesPage = new UniversitiesPage(driver);
	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
