package qa.yocket.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import qa.yocket.utils.Constants;
import qa.yocket.utils.ElementUtil;

public class HomePage {
	// 1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. By locators
	private By collegeFinderlink = By.id("college-finder");

	// 4. Page Actions:
	@Step("Getting Login Page title value.....")
	public String getLoginPageTitle() {
		return eleUtil.doGetTitle(Constants.Home_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	@Step("is College Finder Link Exist.....?")
	public boolean isCollegeFinderLinkExist() {
		return eleUtil.doIsDisplayed(collegeFinderlink, Constants.DEFAULT_TIME_OUT);
	}

	@Step("navigating to College Finder Page.....")
	public UniversityCollegeFinderPage clickOnCollegeFinderLink() {
		eleUtil.doClick(collegeFinderlink, Constants.DEFAULT_TIME_OUT);
		return new UniversityCollegeFinderPage(driver);
	}

}
