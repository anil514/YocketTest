package qa.yocket.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import qa.yocket.listeners.TestAllureListener;
import qa.yocket.utils.Constants;

@Listeners(TestAllureListener.class)
public class HomePageTest extends BaseTest {
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String actTitle = homePage.getLoginPageTitle();
		System.out.println("page title: " + actTitle);
		Assert.assertEquals(actTitle, Constants.Home_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void homePageTest() {
		Assert.assertTrue(homePage.isCollegeFinderLinkExist());
		universityCollegeFinderPage = homePage.clickOnCollegeFinderLink();
		Assert.assertEquals(universityCollegeFinderPage.getCollegeFinderPageTitle(), Constants.CollegeFinder_PAGE_TITLE);
	}

}
