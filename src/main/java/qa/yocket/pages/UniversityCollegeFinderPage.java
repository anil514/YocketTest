package qa.yocket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import qa.yocket.utils.Constants;
import qa.yocket.utils.ElementUtil;

public class UniversityCollegeFinderPage {
	// 1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page constructor
	public UniversityCollegeFinderPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. By locators
	private By degree = By.xpath("//*[@id=\"__layout\"]/div/main/div/div[1]/a");
	
	@Step("Getting College Finder title value.....")
	public String getCollegeFinderPageTitle() {
		return eleUtil.doGetTitle(Constants.CollegeFinder_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	@Step("Fetching available degrees from College Finder page.....")
	public int availableDegrees() {
		int resultCount = eleUtil.waitForElementsToBeVisible(degree, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("Available Degrees count: " + resultCount);
		return resultCount;
	}
	
	
	@Step("Selecting degrees forn College Finder page.....")
	public DreamEducationPage selectDegree(String degreeName) {
		System.out.println("Degree name is : " + degreeName);
		List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(degree, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList) {
			String text = e.getText();
			if (text.equals(degreeName)) {
				e.click();
				break;
			}
		}
		return new DreamEducationPage(driver);

	}

}
