package qa.yocket.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExperienceCountPageTest extends BaseTest{
	
	@BeforeClass
	public void pageSetup() {
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
		testScoresPage.selectEnglishTestwithMarks("PTE", "70");
		testScoresPage.selectAptitudeTesttWithNone("None");
		experienceCountPage = testScoresPage.clickOnNext();
	}
	
	@Test(priority = 1)
	public void selectDreamEducationTest() {
		String relevantWorkExperience = experienceCountPage.enterExperienceDetails("2", "None", "4");
		System.out.println("WorkExperience title: " + relevantWorkExperience);
		universitiesPage = experienceCountPage.clickOnFindUniversities();
	}


}
