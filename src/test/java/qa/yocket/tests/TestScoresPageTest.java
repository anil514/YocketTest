package qa.yocket.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScoresPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		Assert.assertTrue(homePage.isCollegeFinderLinkExist());
		universityCollegeFinderPage = homePage.clickOnCollegeFinderLink();
		dreamEducationPage = universityCollegeFinderPage.selectDegree("Masters");
		dreamEducationPage.selectCountryName("Canada");
		dreamEducationPage.selectStudy("Engineering", "Mechanical Engineering");		
		Assert.assertEquals(dreamEducationPage.doIsDisplayedSpecialization(), true);
		undergradPage = dreamEducationPage.clickOnNext();
		undergradPage.selectUnderGraduateCollegeName("JNTU", "JNTUK");
		undergradPage.selectMajorCourseWithScore("Engineering", "Mechanical Engineering", "7");
		testScoresPage = undergradPage.clickOnNext();
	}
	
	@Test(priority = 1)
	public void selectDreamEducationTest() {
		String testName = testScoresPage.selectEnglishTestwithMarks("PTE", "70");
		System.out.println("TestName Name: "+testName);
		String appTest = testScoresPage.selectAptitudeTesttWithNone("None");	
		System.out.println("App Test Name: "+appTest);
		experienceCountPage = testScoresPage.clickOnNext();
	}


}
