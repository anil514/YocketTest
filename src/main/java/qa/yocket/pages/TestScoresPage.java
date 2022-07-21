package qa.yocket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import qa.yocket.utils.Constants;
import qa.yocket.utils.ElementUtil;

public class TestScoresPage {
	// 1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page constructor
	public TestScoresPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. By locators
	private By englishTestBtn = By.xpath(
			"//*[@class = 'grid grid-cols-3 sm:grid-cols-3 gap-2 justify-center items-center pt-2']/div/div[@tabindex = '0']");
	// private By clkOnTest =
	// By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/main/div/div/div/div/span/form/div[1]/div[2]/div/div[1]/div[2]/div");

	private By overallScore = By.xpath("//*[contains(@id, '_overall_score')]");

	private By aptitudeTestBtn = By.xpath(
			"//*[@class = 'grid grid-cols-3 md:grid-cols-3 gap-2 justify-center items-center']/div/div[@tabindex = '0']");
	private By NextBtn = By.xpath("//div[@class = 'text-right']/button");

	// 4. Page Actions:
	@Step("Selecting English Test.....")
	public String selectEnglishTestwithMarks(String testName, String scoreValue) {
		int resultCount1 = eleUtil.waitForElementsToBeVisible(englishTestBtn, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("total english tests count: " + resultCount1);
		System.out.println("English Test name is : " + testName);
		List<WebElement> searchList1 = eleUtil.waitForElementsToBeVisible(englishTestBtn, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList1) {
			String text1 = e.getText();
			if (text1.equals(testName)) {
				e.click();
				break;
			}
		}
		eleUtil.doSendKeys(overallScore, scoreValue);
		return testName;
	}

	/*
	 * @Step("Selecting English Test.....") public String enterScore(String
	 * scoreValue) { eleUtil.doSendKeys(overallScore, scoreValue); return
	 * scoreValue; }
	 */

	@Step("Selecting Aptitude Test.....")
	public String selectAptitudeTesttWithNone(String appTestName) {
		int resultCount1 = eleUtil.waitForElementsToBeVisible(aptitudeTestBtn, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("total Aptitude Tests count: " + resultCount1);
		System.out.println("Aptitude Test name is : " + appTestName);
		List<WebElement> searchList1 = eleUtil.waitForElementsToBeVisible(aptitudeTestBtn, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList1) {
			String text1 = e.getText();
			if (text1.equals(appTestName)) {
				e.click();
				break;
			}
		}
		return appTestName;

	}

	@Step("navigating to Experience Count Page.....")
	public ExperienceCountPage clickOnNext() {
		eleUtil.doClick(NextBtn, Constants.DEFAULT_TIME_OUT);
		return new ExperienceCountPage(driver);
	}

}
