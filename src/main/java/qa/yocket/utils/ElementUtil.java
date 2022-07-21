package qa.yocket.utils;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver;
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	public String doGetTitle(String title, int timeOut) {
		if (waitForTitleToBe(title, timeOut)) {
			return driver.getTitle();
		}
		return null;
	}
	public WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		return element;
	}
	
	public WebElement getElement(By locator, int timeOut) {
		return doPresenceOfElementLocated(locator, timeOut);
	}
	
	public boolean doIsDisplayed(By locator, int timeOut) {
		return getElement(locator,  timeOut).isDisplayed();
	}
	
	public void doClick(By locator, int timeOut) {
		doPresenceOfElementLocated(locator, timeOut).click();
	}
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public String doGetText(By locator, int timeOut) {
		return getElement(locator,  timeOut).getText();
	}
	
	public void doSendKeys(By locator, String value) {
		doClear(locator);
		getElement(locator).sendKeys(value);
	}
	
	public void doClear(By locator) {
		getElement(locator).clear();
	}
	
	
	/***************************** Wait Utils **************************/
	public WebElement doPresenceOfElementLocated(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
	
	public boolean waitForTitleToBe(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.titleIs(title));
	}
	
	public List<WebElement> waitForElementsToBeVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

}
