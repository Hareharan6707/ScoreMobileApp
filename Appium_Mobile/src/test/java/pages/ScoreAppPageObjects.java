package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class ScoreAppPageObjects   {
	    private AndroidDriver driver;

	    public ScoreAppPageObjects(AndroidDriver driver)
	{
		this.driver = driver;
	}

	    public By getstartedButton = By.id("com.fivemobile.thescore:id/action_button_text");

	    public By scoreLogo = By.id("com.fivemobile.thescore:id/icon_welcome");

	    public By continueButton =By.id("com.fivemobile.thescore:id/action_button_text");
	   
	    public By maybelaterButton = By.id("com.fivemobile.thescore:id/btn_disallow");

	    public By searchField = By.id("com.fivemobile.thescore:id/search_bar_placeholder");

	    public By searchTextbox = By.id("com.fivemobile.thescore:id/search_src_text");

	    public By teamLogo = By.xpath("//android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView");
     
	    public By doneButton =By.id("com.fivemobile.thescore:id/action_button_text");
		   
	    public By teampageElement =By.id("com.fivemobile.thescore:id/chips_container");

		public By permissionDialogbox =By.id("com.android.permissioncontroller:id/grant_dialog");

		public By popUp = By.xpath("//android.view.ViewGroup");

		public By dismissButton = By.id("com.fivemobile.thescore:id/dismiss_modal");

		public By toolBar = By.id("com.fivemobile.thescore:id/toolbar");

		public By allowButton = By.id("com.android.permissioncontroller:id/permission_allow_button");
		
	    public By teamFavpagelogo =By.id("com.fivemobile.thescore:id/icon_team_logo");
		
	    public By teamTeampagelogo =By.id("com.fivemobile.thescore:id/team_name");
		
		public By Teamstats =By.xpath("//android.widget.LinearLayout[@content-desc=\"Team Stats\"]/android.widget.TextView");

		public By TeamstatsData =By.xpath("//android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[2]");

		public void Wait(By Stringarg)
	    {
	    	WebDriverWait wait=  new WebDriverWait(driver, Duration.ofSeconds(10));
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(Stringarg));
	    }


}
