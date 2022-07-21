package qa.yocket.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UniversitiesPageTest extends BaseTest{
	
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
		testScoresPage.selectEnglishTestwithMarks("PTE", "70");
		testScoresPage.selectAptitudeTesttWithNone("None");
		experienceCountPage = testScoresPage.clickOnNext();
	    experienceCountPage.enterExperienceDetails("2", "None", "4");
		universitiesPage = experienceCountPage.clickOnFindUniversities();
	}
	
	@Test(priority = 1)
	public void universitiesTest() {
		universitiesPage.isAmbitiousUniversitiesExist();
		String ambitiousUniversities = universitiesPage.getAmbitiousUniversities();
		System.out.println("page title: " + ambitiousUniversities);
		universitiesPage.totalUniversitiesList();
	}


}
