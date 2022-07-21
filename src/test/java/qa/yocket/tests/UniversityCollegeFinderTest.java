package qa.yocket.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import qa.yocket.utils.Constants;

public class UniversityCollegeFinderTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		Assert.assertTrue(homePage.isCollegeFinderLinkExist());
		universityCollegeFinderPage = homePage.clickOnCollegeFinderLink();
	}
	@Test(priority = 1)
	public void universityCollegeFinderPageTitleTest() {
		String universityCollegeFinderPageTitle = universityCollegeFinderPage.getCollegeFinderPageTitle();
		System.out.println("page title: " + universityCollegeFinderPageTitle);
		Assert.assertEquals(universityCollegeFinderPageTitle, Constants.CollegeFinder_PAGE_TITLE);
	}
	
	@Test(priority = 2)
	public void mastersDegreeTest() {
		universityCollegeFinderPage.availableDegrees();
		dreamEducationPage = universityCollegeFinderPage.selectDegree("Masters");
	}

}
