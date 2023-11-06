package learnappium.Appium_Mobile;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import pages.ScoreAppPageObjects;

public class ScoreAPP extends BaseTest {

	@Test
	public void ScoreAPPMethod() throws MalformedURLException, InterruptedException 
	{
		ScoreAppPageObjects ScoreAPPObj=new ScoreAppPageObjects(driver);
		ConfigFileReader config =new ConfigFileReader();
		
		ExtentTest test =extent.createTest("Score Application launched successfully");
		//test.log(Status.PASS, "Application launch");
		
		ScoreAPPObj.Wait(ScoreAPPObj.logo);
		test.pass("Score logo is visible");
		
		//verifyText(ScoreAPPObj.Startbutton,"Get Started","the button is verified & displayed");
		clickElement(ScoreAPPObj.Startbutton);
		test.pass("Get start button clicked");
		
		ScoreAPPObj.Wait(ScoreAPPObj.continuebutton);
		//verifyText(ScoreAPPObj.continuebutton,"Continue","the button is verified & displayed");
        clickElement(ScoreAPPObj.continuebutton);
        test.pass("Continue button clicked");
        
        ScoreAPPObj.Wait(ScoreAPPObj.maybelaterbuttonbutton);
        verifyText(ScoreAPPObj.maybelaterbuttonbutton,"Maybe Later","the button is verified & displayed");
		clickElement(ScoreAPPObj.maybelaterbuttonbutton);
		test.pass("Maybe later button clicked successfully");
		 
		ScoreAPPObj.Wait(ScoreAPPObj.Searchfield);
		clickElement(ScoreAPPObj.Searchfield);
		enterText(ScoreAPPObj.SearchTextbox,config.getTeam_name());
		test.pass("Manchester united Entered successfully");
        clickElement(ScoreAPPObj.manchisterunitedlogo);
        
		//Continue
		clickElement(ScoreAPPObj.continuebutton);
		test.pass("Continue button clicked successfully");
		//done
		clickElement(ScoreAPPObj.donebutton);
		test.pass("Done button clicked successfully");

		//permission dialog box and pop-ups
		if (pageIsDisplayed(ScoreAPPObj.permissionDialogbox)) {
            clickElement(ScoreAPPObj.allowButton);
			ScoreAPPObj.Wait(ScoreAPPObj.popUp);
			clickElement(ScoreAPPObj.dismiss_Button);
        }

		//verify page
		ScoreAPPObj.Wait(ScoreAPPObj.manchesterunitedpageElement);
		verifyPage(ScoreAPPObj.manchesterunitedpageElement,"Man United team landing page displayed correctly");
		test.pass("Team page is verified successfully");
		
		ScoreAPPObj.Wait(ScoreAPPObj.manchesterunitedlogo);
		clickElement(ScoreAPPObj.manchesterunitedlogo);
		verifyText(ScoreAPPObj.manchesterunitedTeamlogo,"Manchester United","the Text is verified & displayed");
		test.pass("Manchester united text is verified");

		clickElement(ScoreAPPObj.Teamstats);
		verifyPage(ScoreAPPObj.TeamstatsData,"Team stats page is loaded as expected");
		test.pass("Team stats Data is loaded successfully");

		//navigate back
        navigateBack();
        test.pass("Able to navigate back successfully");
		pageIsDisplayed(ScoreAPPObj.toolBar);
        ScoreAPPObj.Wait(ScoreAPPObj.manchesterunitedpageElement);
		verifyPage(ScoreAPPObj.manchesterunitedpageElement,"Navigated to the right page successfully");
        
	}
}
