package Practice0070;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ReusableComponent.seleniumUtil;
public class MultipleElementHandling {

	public static void main(String[] args)
	{
		WebDriver driver=seleniumUtil.requiredBrowser("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		//-----------------------------UserName------------------------
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		//-----------------------------
		WebElement btn=driver.findElement(By.xpath("//button[@class='oxd-icon-button oxd-main-menu-button']"));
		btn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='PIM']")));
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		driver.findElement(By.xpath("//aside/nav/div[2]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Sakshi");
		driver.findElement(By.xpath("//input[@name='middleName']")).sendKeys("Vilas");
		driver.findElement(By.xpath("//input[@name=\"lastName\"]")).sendKeys("Wakode");
		Actions action=new Actions(driver);
		WebElement EmployeeId=driver.findElement(By.xpath("//div[@class=\"oxd-grid-item oxd-grid-item--gutters\"]/div/div/input"));
		action.moveToElement(EmployeeId).doubleClick().build().perform();
		EmployeeId.sendKeys("0070");
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		
		
		

		
	}

}
