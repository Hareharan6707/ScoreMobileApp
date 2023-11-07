package learnappium.Appium_Mobile;

import java.net.MalformedURLException;

import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.ScoreAppPageObjects;

public class ScoreAPP extends BaseTest {

	@Test
	public void ScoreAPPMethod() throws Exception {
		ExtentTest test = extent.createTest("Validating the data load and smooth navigation of "+ config.getTeam_name()+" team page and it's sub-pages")
				.assignAuthor("Hareharan");

		try {
			ScoreAppPageObjects ScoreAPPObj = new ScoreAppPageObjects(driver);

			//Launch app
			ScoreAPPObj.Wait(ScoreAPPObj.scoreLogo);
			test.info("Score logo is visible");

			verifyText(ScoreAPPObj.getstartedButton, "Get Started", "the button is verified & displayed");
			clickElement(ScoreAPPObj.getstartedButton);
			test.info("Get start button clicked");

			ScoreAPPObj.Wait(ScoreAPPObj.continueButton);
			verifyText(ScoreAPPObj.continueButton, "Continue", "the button is verified & displayed");
			clickElement(ScoreAPPObj.continueButton);
			test.info("Continue button clicked");

			//Location permissions
			ScoreAPPObj.Wait(ScoreAPPObj.maybelaterButton);
			verifyText(ScoreAPPObj.maybelaterButton, "Maybe Later", "the button is verified & displayed");
			clickElement(ScoreAPPObj.maybelaterButton);
			test.info("Maybe later button clicked successfully");

			//Search bar for league,team,player
			ScoreAPPObj.Wait(ScoreAPPObj.searchField);
			clickElement(ScoreAPPObj.searchField);
			enterText(ScoreAPPObj.searchTextbox, config.getTeam_name());
			test.log(Status.PASS,config.getTeam_name() + " entered Successfully");
			clickElement(ScoreAPPObj.teamLogo);

			//Continue button
			test.addScreenCaptureFromPath(takeSnapShot(driver));
			clickElement(ScoreAPPObj.continueButton);
			test.info("Continue button clicked successfully");

			//done button
			clickElement(ScoreAPPObj.doneButton);
			test.log(Status.PASS,"Done button clicked successfully");

			//notifications permission dialog box and pop-ups
			if (pageIsDisplayed(ScoreAPPObj.permissionDialogbox)) {
				clickElement(ScoreAPPObj.allowButton);
				ScoreAPPObj.Wait(ScoreAPPObj.popUp);
				clickElement(ScoreAPPObj.dismissButton);
			}

			//verify landing page
			ScoreAPPObj.Wait(ScoreAPPObj.teampageElement);
			verifyPage(ScoreAPPObj.teampageElement, config.getTeam_name() + "team landing page displayed correctly");
			test.log(Status.PASS,"Team page is verified successfully");
			test.addScreenCaptureFromPath(takeSnapShot(driver));

			//Team page
			ScoreAPPObj.Wait(ScoreAPPObj.teamFavpagelogo);
			clickElement(ScoreAPPObj.teamFavpagelogo);
			verifyPage(ScoreAPPObj.teamTeampagelogo, config.getTeam_name() + "the Text is verified & displayed");
			test.info(config.getTeam_name() + " logo is clicked");

			//Sub-page navigation
			clickElement(ScoreAPPObj.Teamstats);
			verifyPage(ScoreAPPObj.TeamstatsData, "Team stats page is loaded as expected");
			test.log(Status.PASS,"Team stats Data is loaded successfully");
			test.addScreenCaptureFromPath(takeSnapShot(driver));

			//navigate back
			navigateBack();
			test.log(Status.PASS,"Able to navigate back successfully");
			test.addScreenCaptureFromPath(takeSnapShot(driver));
			pageIsDisplayed(ScoreAPPObj.toolBar);
			ScoreAPPObj.Wait(ScoreAPPObj.teampageElement);
			verifyPage(ScoreAPPObj.teampageElement, "Navigated to the right page successfully");
		}
		catch (Exception e){
			test.log(Status.FAIL,"unexpected technical issue" + test.addScreenCaptureFromPath(takeSnapShot(driver)));

			}
		}
	}

