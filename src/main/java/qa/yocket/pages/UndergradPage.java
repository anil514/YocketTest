package qa.yocket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import qa.yocket.utils.Constants;
import qa.yocket.utils.ElementUtil;

public class UndergradPage {
	// 1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page constructor
	public UndergradPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	// 3. By locators
	private By undergraduateCollegeName = By.xpath("//*[@id=\"vs4__combobox\"]/div[1]/input");
	private By selectUnderGraduateCollegeName = By.xpath("//*[@id=\"vs4__listbox\"]/li[@class = 'vs__dropdown-option']");
	private By majorCourse = By.xpath("//input[@placeholder='Select Major']");
	private By selectMajorCourse = By.xpath("//*[@id=\"vs6__listbox\"]/li[@class = 'vs__dropdown-option']");
	private By nextBtn = By.xpath("//div[@class = 'text-right']/button");
	private By score = By.xpath("//*[@id=\"marks\"]");
	
	// 4. Page Actions:
	@Step("Selecting UnderGraduate CollegeName value.....")
	public String selectUnderGraduateCollegeName(String typeCollege, String collegeName) {
		eleUtil.doClick(undergraduateCollegeName, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(undergraduateCollegeName, typeCollege);
		int resultCount = eleUtil.waitForElementsToBeVisible(selectUnderGraduateCollegeName, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("the total college count: " + resultCount);	
		System.out.println("College name is : " + collegeName);
		List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(selectUnderGraduateCollegeName, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList) {
			String text = e.getText();
			if (text.equals(collegeName)) {
				e.click();
				break;
			}
		}
		return collegeName;
	}
	
	@Step("Selecting Major Course value.....")
	public String selectMajorCourseWithScore(String typeMajor, String majorName, String scoreNumber) {
		eleUtil.doClick(majorCourse, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(majorCourse, typeMajor);
		int resultCount = eleUtil.waitForElementsToBeVisible(selectMajorCourse, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("the total course count: " + resultCount);	
		System.out.println("Course name is : " + majorName);
		List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(selectMajorCourse, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList) {
			String text = e.getText();
			if (text.equals(majorName)) {
				e.click();
				break;
			}
		}
		eleUtil.doSendKeys(score, scoreNumber);
		return majorName;
	}
	
	@Step("navigating to Test Scores Page.....")
	public TestScoresPage clickOnNext() {	
		 eleUtil.doClick(nextBtn, Constants.DEFAULT_TIME_OUT);
		 return new TestScoresPage(driver);
	}

}
