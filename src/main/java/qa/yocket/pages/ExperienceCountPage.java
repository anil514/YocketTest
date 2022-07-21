package qa.yocket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.qameta.allure.Step;
import qa.yocket.utils.Constants;
import qa.yocket.utils.ElementUtil;

public class ExperienceCountPage {
	// 1. declare private driver
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 2. page constructor
	public ExperienceCountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. By locators
	private By workExperience = By.id("work_exp");
	private By researchPapers = By
			.xpath("//*[@class = 'grid grid-cols-3 sm:grid-cols-3 gap-2 justify-center items-center']/div/div");
	private By projects = By.id("project");
	private By findUniversities = By.xpath("//div[@class = 'text-right']/button");

	// 4. Page Actions:
	@Step("Entering Experience details.....")
	public String enterExperienceDetails(String relevantWorkExperience, String relevantResearchPapers,
			String relevantProjects) {
		eleUtil.doSendKeys(workExperience, relevantWorkExperience);
		int resultCount1 = eleUtil.waitForElementsToBeVisible(researchPapers, Constants.DEFAULT_TIME_OUT).size();
		System.out.println("available research Papers options count: " + resultCount1);
		System.out.println("Research Paper option is : " + relevantResearchPapers);
		List<WebElement> searchList1 = eleUtil.waitForElementsToBeVisible(researchPapers, Constants.DEFAULT_TIME_OUT);
		for (WebElement e : searchList1) {
			String text1 = e.getText();
			if (text1.equals(relevantResearchPapers)) {
				e.click();
				break;
			}
		}
		eleUtil.doSendKeys(projects, relevantProjects);
		return relevantWorkExperience;
	}

	@Step("Getting Find Universities Page.....")
	public UniversitiesPage clickOnFindUniversities() {
		eleUtil.doClick(findUniversities, Constants.DEFAULT_TIME_OUT);
		return new UniversitiesPage(driver);

	}

}
