package qa.yocket.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qa.yocket.utils.Constants;

public class DreamEducationTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		Assert.assertTrue(homePage.isCollegeFinderLinkExist());
		universityCollegeFinderPage = homePage.clickOnCollegeFinderLink();
		dreamEducationPage = universityCollegeFinderPage.selectDegree("Masters");
	}
	
	@Test(priority = 1)
	public void dreamEducationPageTitleTest() {
		String dreamEducationPageTitle = dreamEducationPage.getDreamEducationPageTitle();
		System.out.println("page title: " + dreamEducationPageTitle);
		Assert.assertEquals(dreamEducationPageTitle, Constants.DreamEducation_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void selectDreamEducationTest() {
		dreamEducationPage.selectCountryName("Canada");
		dreamEducationPage.selectStudy("Engineering", "Mechanical Engineering");		
		Assert.assertEquals(dreamEducationPage.doIsDisplayedSpecialization(), true);
		undergradPage = dreamEducationPage.clickOnNext();
	}

}
