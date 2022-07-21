package qa.yocket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import qa.yocket.utils.Constants;
import qa.yocket.utils.ElementUtil;

public class DreamEducationPage {
	// 1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page constructor
	public DreamEducationPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. By locators
	private By enterCountryName = By.className("vs__selected-options");
	private By selectCountryName = By.xpath("//*[@id=\"vs1__listbox\"]/li");
	private By clickOnStudyName = By.id("vs2__combobox");
	private By selectStudyName = By.xpath("//*[@id=\"vs2__combobox\"]/div[1]/input");
	private By selectStudyFromDropdown = By.xpath("//*[@id=\"vs2__listbox\"]/li[@class = 'vs__dropdown-option']");
	private By specialization  = By.xpath("//*[@id=\"vs3__combobox\"]/div[1]/input");
	private By nextBtn = By.xpath("//*[@class = 'text-right']/button");

	// 4. Page Actions:
	@Step("Getting Dream Education Page title value.....")
	public String getDreamEducationPageTitle() {
		// return eleUtil.doGetTitle(Constants.MastersDegree_PAGE_TITLE,
		// Constants.DEFAULT_TIME_OUT);
		return eleUtil.doGetTitle(Constants.DreamEducation_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
	}

	@Step("Selecting country name for Dream Education.....")
	public String selectCountryName(String countryName) {
		eleUtil.doClick(enterCountryName, Constants.DEFAULT_TIME_OUT);
		int resultCount = eleUtil.waitForElementsToBeVisible(selectCountryName, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("the total country count: " + resultCount);
		System.out.println("Country name is : " + countryName);
		List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(selectCountryName, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList) {
			String text = e.getText();
			if (text.equals(countryName)) {
				e.click();
				break;
			}
		}
		return countryName;
	}

	@Step("Selecting study for Dream Education.....")
	public String selectStudy(String typeStudy, String branchName) {
		eleUtil.doClick(clickOnStudyName, Constants.DEFAULT_TIME_OUT);
		eleUtil.doSendKeys(selectStudyName, typeStudy);
		int resultCount = eleUtil.waitForElementsToBeVisible(selectStudyFromDropdown, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("the total studyname count: " + resultCount);
		System.out.println("Study name is : " + branchName);
		List<WebElement> searchList = eleUtil.waitForElementsToBeVisible(selectStudyFromDropdown, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList) {
			String text = e.getText();
			if (text.equals(branchName)) {
				e.click();
				break;
			}
		}
		return branchName;
	}

	@Step("specialization exist for Dream Education.....?")
	public boolean doIsDisplayedSpecialization() {
		return eleUtil.getElement(specialization).isDisplayed();
	}

	@Step("navigating to Undergrad Page.....")
	public UndergradPage clickOnNext() {
		eleUtil.doClick(nextBtn, Constants.DEFAULT_TIME_OUT);
		return new UndergradPage(driver);

	}

}
