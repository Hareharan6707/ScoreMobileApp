package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import learnappium.Appium_Mobile.BaseTest;

public class ScoreAppPageObjects   {
	 private AndroidDriver driver;

	    public By Startbutton = By.id("com.fivemobile.thescore:id/action_button_text");

	    public By logo = By.id("com.fivemobile.thescore:id/icon_welcome");

	    public By continuebutton =By.id("com.fivemobile.thescore:id/action_button_text");
	   
	    public By maybelaterbuttonbutton = By.id("com.fivemobile.thescore:id/btn_disallow");

	    public By Searchfield = By.id("com.fivemobile.thescore:id/search_bar_placeholder");

	    public By SearchTextbox = By.id("com.fivemobile.thescore:id/search_src_text");

	    public By manchisterunitedlogo = By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
     
	    public By donebutton =By.id("com.fivemobile.thescore:id/action_button_text");
		   
	    public By manchesterunitedpageElement =By.id("com.fivemobile.thescore:id/chips_container");

		public By permissionDialogbox =By.id("com.android.permissioncontroller:id/grant_dialog");

		public By popUp = By.xpath("//android.view.ViewGroup");

		public By dismiss_Button = By.id("com.fivemobile.thescore:id/dismiss_modal");

		public By toolBar = By.id("com.fivemobile.thescore:id/toolbar");

		public By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
		
	    public By manchesterunitedlogo =By.id("com.fivemobile.thescore:id/icon_team_logo");
		
	    public By manchesterunitedTeamlogo =By.id("com.fivemobile.thescore:id/team_name");
		
	    public ScoreAppPageObjects(AndroidDriver driver)
	    {
	        this.driver = driver;
	    }

		public By Teamstats =By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]/android.widget.TextView");

		public By TeamstatsData =By.xpath("//android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");

		public void Wait(By Stringarg)
	    {
	    	WebDriverWait wait=  new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Stringarg));
	    }




	    

}
