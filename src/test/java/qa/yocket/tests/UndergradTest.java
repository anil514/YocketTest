package qa.yocket.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UndergradTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetup() {
		Assert.assertTrue(homePage.isCollegeFinderLinkExist());
		universityCollegeFinderPage = homePage.clickOnCollegeFinderLink();
		dreamEducationPage = universityCollegeFinderPage.selectDegree("Masters");
		dreamEducationPage.selectCountryName("Canada");
		dreamEducationPage.selectStudy("Engineering", "Mechanical Engineering");		
		Assert.assertEquals(dreamEducationPage.doIsDisplayedSpecialization(), true);
		undergradPage = dreamEducationPage.clickOnNext();
	}
	
	@Test(priority = 1)
	public void selectDreamEducationTest() {
		String college = undergradPage.selectUnderGraduateCollegeName("JNTU", "JNTUK");
		System.out.println("College Name: "+college);
		String branch = undergradPage.selectMajorCourseWithScore("Engineering", "Mechanical Engineering", "7");
		System.out.println("Branch Name: "+branch);
		testScoresPage = undergradPage.clickOnNext();
	}

}
