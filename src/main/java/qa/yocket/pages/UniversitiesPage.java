package qa.yocket.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import qa.yocket.utils.ElementUtil;

public class UniversitiesPage {

	private ElementUtil eleUtil;
	
	//2. page constructor
	public UniversitiesPage(WebDriver driver) {
		eleUtil = new ElementUtil(driver);
	}

	// 3. By locators
	private By ambitiousUniversities = By.xpath("//p[@class='text-2xl pb-4 text-center lg:text-left']");
	private By totalUniversities = By.xpath("//*[@class = 'text-lg font-medium mt-2']/a");

	// 4. Page Actions:
	public boolean isAmbitiousUniversitiesExist() {
		return eleUtil.doIsDisplayed(ambitiousUniversities, 10);
	}

	public String getAmbitiousUniversities() {
		return eleUtil.doGetText(ambitiousUniversities, 15);
	}

	public void totalUniversitiesList() {
		int resultCount1 = eleUtil.waitForElementsToBeVisible(totalUniversities, 15).size();
		System.out.println("total Universities count: " + resultCount1);
		List<WebElement> searchList1 = eleUtil.waitForElementsToBeVisible(totalUniversities, 15);
		for (WebElement e : searchList1) {
			String text1 = e.getText();
			System.out.println("Universities Name: " + text1);
		}
	}
}
