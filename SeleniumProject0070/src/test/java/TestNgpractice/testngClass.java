package TestNgpractice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testngClass {
	WebDriver driver;
  
	@Test
  public void OpebnBrowser()
  {
	WebDriver driver = new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  // Perform login
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	
  }
	@Test(priority = 1)
	public void createEmployee()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Navigate to PIM module
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		driver.findElement(By.xpath("//i[@class='oxd-icon bi-chevron-left']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']")));
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		// Fill in employee details
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Sakshi");
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Vilas");
		driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Wakode");
		// double click on id to remove already exist id
		Actions action=new Actions(driver);
		WebElement EmployeeId=driver.findElement(By.xpath("//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]/div/div/input"));
		action.moveToElement(EmployeeId).doubleClick().build().perform();
		EmployeeId.sendKeys("0070");
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		// Verify employee is created or not
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		WebElement employee = driver.findElement(By.xpath("//div[text()='0070']"));
		Assert.assertNotNull(employee, "Employee was not created successfully.");	
	}
	@Test(priority = 2)
	public void updateEmployee()
	{// Navigate to PIM module and search for the employee
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("SAKSHI");
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		// Click on the employee record and update details
        driver.findElement(By.xpath("//div[div[div[div[text()='SAKSHI VILAS']]]]/div/div/div/div/label")).click();
        driver.findElement(By.xpath("//div[div[div[div[text()='SAKSHI VILAS']]]]/div/div[9]/div/button")).click();
        driver.findElement(By.xpath("input//[@name='firstName']")).sendKeys("radha");
        driver.findElement(By.id("//button[text=' Save ']")).click();
        // Verify employee details are updated
        String fName = driver.findElement(By.xpath("//div[div[div[text()='radha vilas']]]")).getText();
        Assert.assertEquals(fName, "radha vilas", "Employee details were not updated correctly.");
    
	}
	
	@Test(priority = 3)
	public void deleteEmployee()
	{
		// Navigate to PIM module and search for the employee
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//a[text()='Employee List']")).click();
		driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("radha vilas");
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		// Select and delete the employee
		driver.findElement(By.xpath("//div[div[div[div[text()='SAKSHI VILAS']]]]/div/div/div/div/label")).click();
		driver.findElement(By.xpath("//div[div[div[div[text()='radha vilas']]]]/div/div[9]/div/button[2]")).click();
		driver.findElement(By.xpath("//body")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//form/div[1]/div/div[1]/div/div[2]/div/div/input")).sendKeys("radha vilas");
        WebElement noRecordsMessage = driver.findElement(By.xpath("//td[contains(text(),'No Records Found')]"));
        Assert.assertTrue(noRecordsMessage.isDisplayed(), "Employee was not deleted successfully.");
	}
	
	
	
}
