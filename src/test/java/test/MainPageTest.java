package test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.MainPage;

public class MainPageTest extends TestBase {

	MainPage main;

	public MainPageTest()
	{
		super();

	}

	@BeforeTest
	public void setUp() {
		initialization();
		main=new MainPage();

	}


	@Test(priority=1)
	public void verifyMainPageTitleTest() throws InterruptedException{
		String mainPageTitle = main.validateMainPageTitle();
		Assert.assertEquals(mainPageTitle, "Login :: Plum Fuse");

	}

	@Test(priority=2)
	public void  dragAndDropFlow()
	{
		main.clickOnCreateApp();
		main.clickOngetStartedButton();
		main.clickOnNewPage();
		main.clickOnCreateButton();
		main.clickOnMessaging();
		main.dragSmsToArea();//to area
		System.out.println("drag sms to area");
		main.startToSMS();
		System.out.println("adding node to node");
		//	Thread.sleep(5000);
		System.out.println(prop.getProperty("phone"));
		main.sendDataToSMS(prop.getProperty("phone"), prop.getProperty("message"));
		main.dragEmailToArea();
		main.sendDatatoEmail(prop.getProperty("smtpHost"), prop.getProperty("port"), prop.getProperty("username"), prop.getProperty("password"), prop.getProperty("from"), prop.getProperty("to"), prop.getProperty("sub"), prop.getProperty("cc"), prop.getProperty("pharse"));
		main.hangupDrag();

	}
	@AfterMethod
	public void quitBrowser(){
		driver.quit();
	}

}
