package TestNgpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ReusableComponent.SeleniumUtility;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class vtigerCampaigns extends SeleniumUtility {

	@BeforeTest
	public void openBrowser() {
		System.out.println("Starts.....");
	}

	@BeforeMethod
	public void LogIn() {
		setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");
		WebElement userInput = driver.findElement(By.xpath("//input[@id='username']"));
		typeInput(userInput, "admin");
		WebElement pwdInput = driver.findElement(By.xpath("//input[@id='password']"));
		typeInput(pwdInput, "admin");
		WebElement signInBtn = driver.findElement(By.xpath("//button[text()='Sign in']"));
		clickOnElement(signInBtn);
		WebElement ClickOnMenu = driver.findElement(By.xpath("//div[@class='row']/div[1]/div/div/div/span"));
		clickOnElement(ClickOnMenu);
		WebElement clickOnMarketing = driver.findElement(By.xpath("//span[text()=' MARKETING']"));
		clickOnElement(clickOnMarketing);
		WebElement clickOnCampaigns = driver.findElement(By.xpath("//span[text()=' Campaigns']"));
		clickOnElement(clickOnCampaigns);

	}

	@Test(groups="Smoke Test",enabled = true, priority = 1,description="creating campaign...")
	public void createCampaign() {
		WebElement addCampaign = driver
				.findElement(By.xpath("//button[@id='Campaigns_listView_basicAction_LBL_ADD_RECORD']"));
		clickOnElement(addCampaign);
		WebElement First_Name = driver
				.findElement(By.xpath("//input[@id='Campaigns_editView_fieldName_campaignname']"));
		typeInput(First_Name, "Rekha");
		WebElement Date = driver.findElement(By.xpath("//input[@id='Campaigns_editView_fieldName_closingdate']"));
		typeInput(Date, "08-25-2024");
		WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
		clickOnElement(saveBtn);
		String actualTitle = GetCurrentTitle("Campaigns - Rekha");
		Assert.assertEquals("Campaigns - Rekha", actualTitle);
	}

	@Test(groups="Sanity Test",enabled = true, priority = 2,description="updating campaign...")
	public void UpdateCampaign() {
		setSleepTime(2000);
		WebElement SearchInput = driver.findElement(By.xpath("//input[@name='campaignname']"));
		typeInput(SearchInput, "Rekha");
		WebElement ClickOnSearchBtn = driver.findElement(By.xpath("//span[text()='Search']"));
		clickOnElement(ClickOnSearchBtn);
		setSleepTime(3000);
		WebElement CheckBox = driver.findElement(By.xpath(
				"//html/body/div[1]/div[4]/div[3]/div/div[3]/div[2]/table/thead/tr[1]/th[1]/div/div[1]/span/input"));
		clickOnElement(CheckBox);
		WebElement EditBtn = driver.findElement(By.xpath("//button[@id='Campaigns_listView_massAction_LBL_EDIT']"));
		clickOnElement(EditBtn);
		WebElement Date = driver.findElement(By.xpath("//input[@id='Campaigns_editView_fieldName_closingdate']"));
		typeInput(Date, "06-23-2000");
		WebElement saveBtn = driver.findElement(By.xpath("//button[@class='btn btn-success saveButton']"));
		clickOnElement(saveBtn);
		setSleepTime(3000);
		WebElement dateIs = driver.findElement(
				By.xpath("//table[tbody[tr[td[2][span[span[a[text()='Rekha']]]]]]]/tbody/tr/td[6]/span/span"));
		String actualDateIs = getTextFromElement(dateIs);
		String ExpectedDateIs = "06-23-2000";
		Assert.assertEquals(actualDateIs, ExpectedDateIs);

	}

	@Test(groups="Regression",enabled = true, priority = 3,description="deleting campaign...")
	public void deleteCampaign() {
		WebElement SearchInput = driver.findElement(By.xpath("//input[@name='campaignname']"));
		typeInput(SearchInput, "Rekha");
		WebElement ClickOnSearchBtn = driver.findElement(By.xpath("//span[text()='Search']"));
		clickOnElement(ClickOnSearchBtn);
		setSleepTime(3000);
		WebElement chekbox = driver
				.findElement(By.xpath("//tr[td[span[span[a[text()='Rekha']]]]]/td[1]/div/span[1]/input"));
		clickOnElement(chekbox);
		WebElement deleteBtn=driver.findElement(By.xpath("//button[@id='Campaigns_listView_massAction_LBL_DELETE']"));		
		clickOnElement(deleteBtn);
		WebElement yespopup=driver.findElement(By.xpath("//button[text()='Yes']"));
		clickOnElement(yespopup);
		WebElement noRecordFound=driver.findElement(By.xpath("//div[@class='emptyRecordsContent']"));
		boolean ActualRecordStatus=isElementExist(noRecordFound);
		boolean ExpectedRecordStatus=true;
		Assert.assertEquals(ActualRecordStatus,ExpectedRecordStatus);	
	}
	@AfterMethod
	public void LogOut()
	{
		WebElement Dropdown=driver.findElement(By.xpath("//a[@class='userName dropdown-toggle pull-right']"));
		clickOnElement(Dropdown);
		WebElement LogOut=driver.findElement(By.xpath("//a[@id='menubar_item_right_LBL_SIGN_OUT']"));
		clickOnElement(LogOut);
		
	}
	@AfterTest
	public void closeAllBrowser()
	{
		tearDown();
		System.out.println("Ends...");
	}

}
