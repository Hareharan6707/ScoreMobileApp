package learnappium.Appium_Mobile;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class BaseTest {

	public AndroidDriver driver;
	ConfigFileReader config =new ConfigFileReader();
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("Extentreport.html");

	//File declarations for dynamic path reading
	File rootPath = new File("src/test/java/resource");
	File apkFile = new File(rootPath,"thescore_23.14.0.apk");
	public AppiumDriverLocalService server;

	@BeforeSuite
	public void ConfigureAppium() throws MalformedURLException {

		ConfigFileReader.ConfigFileReaders();

		//to start the server

		 server = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\Haree\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.usingPort(4723).withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
				.withLogFile(new File("appiumlog.txt"))
				.withIPAddress("127.0.0.1")
				.withTimeout(Duration.ofSeconds(300))
				.build();

			    server.start();

				//Automator Initialization
				UiAutomator2Options options= new UiAutomator2Options();

				//Setting the capabilities
				//options.setDeviceName(config.getDevice_name());
				//options.setAvd(config.getDevice_name());
				//options.setAvdLaunchTimeout(Duration.ofSeconds(18000));
				options.setUdid(config.getUDID_name());
				options.setApp(apkFile.getAbsolutePath());

				//Driver Instantiation
                driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);
				System.out.println("Driver launched");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));	

	}

	@BeforeTest

	public void beforeTest()
	{
		extent.attachReporter(spark);
	}

	public void clickElement(By locatorobj) {
		 driver.findElement(locatorobj).click();
	}
	
	public void enterText(By locatorobj,String Text) {
		driver.findElement(locatorobj).sendKeys(Text);
	}
	
	public boolean pageIsDisplayed(By locatorobj) {
	return	driver.findElement(locatorobj).isDisplayed();	
	}
	
	public void navigateBack() 
	{
		driver.navigate().back();
	}
	
	public void verifyText(By locatorobj,String arg,String message) 
	{
	String Element=driver.findElement(locatorobj).getText();
	Assert.assertEquals(Element, arg, message);
	}

	public void verifyPage(By locatorobj,String message) 
	{
		boolean pageElement=pageIsDisplayed(locatorobj);
		Assert.assertTrue(pageElement, message);
	}

	public static String takeSnapShot(AndroidDriver webdriver) throws Exception{

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		File DestFile=new File("src/images/snap"+System.currentTimeMillis()+".png");
		String absolutePath = DestFile.getAbsolutePath();
		FileHandler.copy(SrcFile,DestFile);
		return absolutePath;
	}

	@AfterSuite
	public void tearDown() throws InterruptedException
	{
		extent.flush();
		driver.quit();
		server.stop();
	}

}
