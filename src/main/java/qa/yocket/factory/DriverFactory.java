package qa.yocket.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	
	
	/**
	 * This method is used to initialize the driver
	 * 
	 * @param browserName
	 * @return
	 */
	public WebDriver initDriver(Properties prop) {
		
		String browserName = prop.getProperty("browser");
		

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();	
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		else {
			System.out.println("please pass the right browserName : " + browserName);
		}

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	/**
	 * this method is used to initialize the properties
	 * 
	 * @return this will return properties prop reference
	 */
	
	public Properties init_prop() {
		prop = new Properties();
		try {
			
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			try {
				prop.load(ip);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return prop;
	}
	
	/**
	 * take screenshot
	 */

	public String getScreenshot() {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
}
