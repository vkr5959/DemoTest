package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class MainPage  extends TestBase {

	//Page Factory - OR:
	@FindBy(id="link-create")
	WebElement createAnApp;

	////*[@id="intro-dialog-cont"]/div[2]/button

	@FindBy(xpath="//*[@id=\"intro-dialog-cont\"]/div[2]/button")
	WebElement getStartedButton;

	@FindBy(id="add-page")
	WebElement newPage;

	@FindBy(xpath="//*[@class=\"indented submitonenter\"]")
	WebElement name;

	@FindBy(xpath="/html/body/div[20]/div[3]/button[1]")
	//*[@class="ui-corner-all ui-button ui-state-default"]
	WebElement creatButton;


	@FindBy(xpath="//*[@class=\"ui-accordion-header ui-helper-reset ui-state-default ui-corner-top ui-corner-all\"][3]")
	WebElement messagingButton;


	@FindBy(xpath="//*[@class=\"module-item ui-widget-content ui-corner-all module-item-green ui-draggable\"][3]")
	WebElement sendSMSbutton;

	@FindBy(xpath="//*[@class=\"module-item ui-widget-content ui-corner-all module-item-green ui-draggable\"][2]")
	WebElement sendEmailButton;



	@FindBy(xpath="//*[@id=\"tabs-2\"]")   
	//	@FindBy(xpath="//*[@id=\"rec-416090\"]")
	WebElement dragSmstoArea;

	@FindBy(xpath="(//*[@class=\"syn-node ui-draggable syn-node-active\"])[2]")
	WebElement startNode;

	@FindBy(xpath="//*[@class=\"syn-receptor ui-droppable syn-receptor-north ui-draggable syn-receptor-draggable\"]")
	WebElement smsNode;


	@FindBy(xpath="//*[@name=\"phone_constant\"]")
	WebElement phoneNo_SMS;

	////*[@name="message_phrase[]"]

	@FindBy(xpath="//*[@name=\"message_phrase[]\"]")
	WebElement msg_SMS;


	//name="smtp_url"

	@FindBy(xpath="//*[@name=\"smtp_url\"]")
	WebElement smtphostEmail;

	@FindBy(xpath="//*[@name=\"port\"]")
	WebElement portEmail;

	@FindBy(xpath="(//*[@name=\"username\"])[1]")
	WebElement userNameEmail;

	@FindBy(xpath="(//*[@name=\"password\"])[1]")
	WebElement passwordEmail;

	//(//*[@name="to_constant"])[1]

	@FindBy(xpath="(//*[@name=\"from_constant\"])[1]")
	WebElement fromEmail;

	@FindBy(xpath="(//*[@name=\"to_constant\"])[1]")
	WebElement toEmail;

	@FindBy(xpath="(//*[@name=\"subject_constant\"])[1]")
	WebElement subEmail;



	@FindBy(xpath="(//*[@name=\"cc_constant\"])[1]")
	WebElement ccEmail;



	@FindBy(xpath="(//*[@name=\"message_phrase[]\"])[1]")
	WebElement pharseEmail;


	@FindBy(xpath="//*[@class=\"module-item ui-widget-content ui-corner-all module-item-red ui-draggable\"]")
	WebElement hangUp;

	////*[@class="ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-state-hover"]
	@FindBy(xpath="//*[@class=\"ui-accordion-header ui-helper-reset ui-state-default ui-corner-all\"]")
	WebElement basicButton;

	//Initializing the Page Objects:	
	public MainPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions :
	public String validateMainPageTitle(){
		return driver.getTitle();
	}
	public void clickOngetStartedButton()
	{
		getStartedButton.click();
	}

	public void clickOnNewPage()
	{
		newPage.click();
	}

	public void clickOnCreateButton() {
		creatButton.click();
	}

	public void enterDataOnName()
	{
		name.sendKeys("test123");
	}
	public void clickOnCreateApp(){

		createAnApp.click();
		//return new HomePage();
	}

	public void clickOnMessaging(){

		messagingButton.click();

	}

	public void dragSmsToArea()
	{

		Actions action = new Actions(driver);
		action.dragAndDrop(sendSMSbutton, dragSmstoArea).build().perform();
		//action.clickAndHold(sendSMSbutton).moveByOffset(250, 10).build().perform();

	}

	public void startToSMS() {
		Actions action = new Actions(driver);
		//smsNode.click();
		//action.clickAndHold(startNode).build().perform();
		action.dragAndDrop(startNode, smsNode).build();
		//action.clickAndHold(startNode).moveByOffset(250, 10).build().perform();
		//action.clickAndHold().moveToElement(smsNode).release(smsNode).build().perform();


	}

	public void dragEmailToArea() {
		sendEmailButton.click();
		Actions action = new Actions(driver);
		action.dragAndDrop(sendEmailButton, dragSmstoArea).build().perform();
	}


	public void sendDataToSMS(String ph,String msg)
	{
		phoneNo_SMS.sendKeys(ph);
		msg_SMS.sendKeys(msg);

	}

	public void sendDatatoEmail(String smtp,String port,String username,String password,String from,String to,String sub,String cc,String pharse )
	{
		smtphostEmail.sendKeys(smtp);
		portEmail.sendKeys(port);
		userNameEmail.sendKeys(username);
		passwordEmail.sendKeys(password);
		fromEmail.sendKeys(from);
		toEmail.sendKeys(to);
		subEmail.sendKeys(sub);
		ccEmail.sendKeys(cc);
		pharseEmail.sendKeys(pharse);



	}


	public void hangupDrag()
	{
		basicButton.click();
		Actions action = new Actions(driver);
		action.dragAndDrop(hangUp, dragSmstoArea).build().perform();
	}

}
