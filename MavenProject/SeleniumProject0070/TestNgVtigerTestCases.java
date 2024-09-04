package TestNgpractice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ReusableComponent.seleniumUtil;
import ReusableComponent.SeleniumUtility;

public class TestNgVtigerTestCases extends SeleniumUtility {

	@BeforeMethod
	public void LogInVitigerAppn() {
		// open browser
		driver = setUp("chrome", "https://demo.vtiger.com/vtigercrm/index.php");

		// find username element
		WebElement username = driver.findElement(By.xpath("//div[@id='loginFormDiv']/form/div[1]/input"));
		typeInput(username, "admin");

		// find password element
		WebElement pwd = driver.findElement(By.xpath("//div[@id='loginFormDiv']/form/div[2]/input"));
		typeInput(pwd, "admin");
		clickOnElement(driver.findElement(By.xpath("//button[text()='Sign in']")));
		// driver.findElement(By.xpath("//button[text()='Sign
		// in']")).sendKeys(Keys.chord(Keys.CONTROL,"v",Keys.ENTER));
		String title = "Dashboard";
		String actualTitle = GetCurrentTitle(title);
		System.out.println(actualTitle);
		Assert.assertEquals(title, actualTitle, "either login failed or home page got change..");
	}

	@Test(enabled = true, priority = 1)
	public void CreateLead() {
		setSleepTime(2000);
		WebElement MenuBtn = driver.findElement(By.xpath("//div[@class='row']/div[1]/div/div/div/span"));
		clickOnElement(MenuBtn);
		WebElement Marketing = driver.findElement(By.xpath("//span[text()=' MARKETING']"));
		clickOnElement(Marketing);
		WebElement Leads = driver.findElement(By.xpath("//a[@title='Leads']"));
		clickOnElement(Leads);
		WebElement AddLeads = driver.findElement(By.xpath("//button[@id='Leads_listView_basicAction_LBL_ADD_RECORD']"));
		clickOnElement(AddLeads);
		/*
		 * WebElement Arrow=driver.findElement(By.
		 * xpath("//table[@class='table table-borderless']/tbody/tr[1]/td[2]/div[1]/a/span[2]/b"
		 * )); clickOnElement(Arrow); WebElement
		 * SearchInput=driver.findElement(By.xpath("input[id='s2id_autogen2_search']"));
		 * typeInput(SearchInput, "Ms."); WebElement
		 * SelectMs=driver.findElement(By.xpath(
		 * "//ul[@class='select2-results']/li/div/span")); clickOnElement(SelectMs);
		 */

		WebElement FName = driver.findElement(By.xpath("//input[@name='firstname']"));
		typeInput(FName, "sakshi");
		WebElement LName = driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_lastname']"));
		typeInput(LName, "Wakode");
		WebElement CompName = driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_company']"));
		typeInput(CompName, "Accenture");
		WebElement Designation = driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_designation']"));
		typeInput(Designation, "QA");
		WebElement SaveLead = driver.findElement(By.xpath("//button[text()='Save']"));
		clickOnElement(SaveLead);
		/*
		 * WebElement AssignedTo=driver.findElement(By.xpath(
		 * "//tbody/tr[9]//td[@class=\"fieldValue\"]/div/a/span[2]/b"));
		 * clickOnElement(AssignedTo); WebElement
		 * AssignToSearch=driver.findElement(By.xpath(
		 * "//input[@id='s2id_autogen12_search']"));
		 * AssignToSearch.sendKeys("Team Selling",Keys.chord(Keys.ENTER));
		 */
		String ExpectedTitle = "Leads - sakshi Wakode";
		String ActualTitle = GetCurrentTitle(ExpectedTitle);
		Assert.assertEquals(ExpectedTitle, ActualTitle, "lead do not created..");

	}

	@Test(enabled =true, priority = 2)
	public void UpdateLead() {
		setSleepTime(3000);
		WebElement MenuBtn = driver.findElement(By.xpath("//div[@class='row']/div[1]/div/div/div/span"));
		clickOnElement(MenuBtn);
		WebElement Marketing = driver.findElement(By.xpath("//span[text()=' MARKETING']"));
		clickOnElement(Marketing);
		WebElement Leads = driver.findElement(By.xpath(" //span[text()=' Leads']"));
		clickOnElement(Leads);
		// WebElement
		// searchInput=driver.findElement(By.xpath("//input[@name='firstname']"));
		// typeInput(searchInput, "sakshi");
		// WebElement
		// clickOnSearch=driver.findElement(By.xpath("//span[text()='Search']"));
		// clickOnElement(clickOnSearch);
		WebElement checkBox = driver
				.findElement(By.xpath("//tbody[tr[td[2][span[span[a[text()='sakshi']]]]]]/tr/td[1]/div/span[1]/input"));
		clickOnElement(checkBox);
		WebElement EditPencil = driver
				.findElement(By.xpath("//div[div[div[div[@class='col-md-3']]]]/div[2]/div/div/div/button/i"));
		clickOnElement(EditPencil);
		WebElement writeSurname = driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_lastname']"));
		typeInput(writeSurname, "patil");
		WebElement SaveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
		clickOnElement(SaveBtn);
		driver.navigate().refresh();
		WebElement surname = driver
				.findElement(By.xpath("//tbody[tr[td[span[span[a[text()='sakshi']]]]]]/tr[1]/td[3]/span/span/a"));
		String actualsurname = getTextFromElement(surname);
		String Expectedsurname = "patil";
		System.out.println("Expected" + Expectedsurname);
		System.out.println("actual" + actualsurname);
		Assert.assertEquals(Expectedsurname, actualsurname);
		System.out.println("validation Successful...");

	}

	@Test(enabled = true, priority = 3)
	public void DeleteLead() {
		WebElement MenuBtn = driver.findElement(By.xpath("//div[@class='row']/div[1]/div/div/div/span"));
		clickOnElement(MenuBtn);
		WebElement Marketing = driver.findElement(By.xpath("//span[text()=' MARKETING']"));
		clickOnElement(Marketing);
		WebElement Leads = driver.findElement(By.xpath("//a[@title='Leads']"));
		Leads.click();
		WebElement checkBox = driver
				.findElement(By.xpath("//tr[td[span[span[a[text()='sakshi']]]]]/td[1]/div/span[1]/input"));
		clickOnElement(checkBox);
		WebElement DeleteBtn = driver.findElement(By.xpath("//button[@id='Leads_listView_massAction_LBL_DELETE']"));
		clickOnElement(DeleteBtn);
		WebElement YesNoPopUp = driver.findElement(By.xpath("//button[text()='Yes']"));
		clickOnElement(YesNoPopUp);
	}

	@Test(priority = 4)
	public void isLeadPresent() {
		
		// Search for the lead again to check if it's still present
		WebElement MenuBtn = driver.findElement(By.xpath("//div[@class='row']/div[1]/div/div/div/span"));
		clickOnElement(MenuBtn);
		WebElement Marketing = driver.findElement(By.xpath("//span[text()=' MARKETING']"));
		clickOnElement(Marketing);
		WebElement Leads = driver.findElement(By.xpath("//a[@title='Leads']"));
		clickOnElement(Leads);
		WebElement searchInput = driver.findElement(By.xpath("//input[@name='firstname']"));
		typeInput(searchInput, "sakshi");
		WebElement clickOnSearch = driver.findElement(By.xpath("//span[text()='Search']"));
		clickOnElement(clickOnSearch);
		//driver.navigate().refresh();
		WebElement NoRecordMsg = driver
				.findElement(By.xpath("//div[@class='emptyRecordsContent']")); 
		Boolean LeadRowStatus = NoRecordMsg.isDisplayed();
		Boolean expectedStatus = true;
		Assert.assertEquals(expectedStatus, LeadRowStatus);
		

	}

}
