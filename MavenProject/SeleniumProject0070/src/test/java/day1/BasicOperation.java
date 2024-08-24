package day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicOperation {

	public static void main(String[] args) {
		WebDriver driver = openBrowser.requiredBrowser0070("chrome");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		/*
		 * driver.get("https://online.actitime.com/uts/login.do");
		 * driver.findElement(By.cssSelector("input[id='username']")).sendKeys(
		 * "admin01", Keys.chord(Keys.CONTROL,"a"), Keys.chord(Keys.CONTROL,"c"));
		 * driver.findElement(By.cssSelector("input[name='pwd']")).sendKeys(Keys.chord(
		 * Keys.CONTROL,"v",Keys.ENTER));
		 * 
		 * driver.navigate().back(); driver.navigate().to(
		 * "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		 * driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(
		 * "Admin");
		 * driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(
		 * "admin123",Keys.ENTER);
		 */
		//driver.navigate().back();
		
		// for mouse operaion create an instance of Actions class and pass browser
		// instance to its constructor
		Actions action01 = new Actions(driver);
		driver.navigate().to("https://demo.vtiger.com/vtigercrm/index.php");

		WebElement username01 = driver.findElement(By.id("username"));
		// if password and user name is same then copy username by double clicking ..
		// for that need to do mouse click operation
		action01.moveToElement(username01).doubleClick().build().perform();
		username01.sendKeys(Keys.chord(Keys.CONTROL, "C"));

		driver.findElement(By.xpath("//input[@id='password']")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Keys.chord(Keys.CONTROL, "v"), Keys.ENTER);
// --------------------------------------------------------------------------
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		WebElement menuList =driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[2]/div[3]/div/div/span[2]"));
		String e=menuList.getText();
		System.out.println(e);

		/*WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(30));
		waitt.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//nav/div[1]/div/div[1]/div/div[1]/div")));
		driver.findElement(By.xpath("/html/body/div[1]/nav/div[1]/div/div[1]/div/div[1]/div")).click();
		List<WebElement> menuListt = driver.findElements(By.xpath("//div[@id='app-menu']/div/div[2]/div/div/span[2]"));
		// hover on menu options

		for (int i = 0; i < menuList.size(); i++)
		{
		action01.moveToElement(menuListt.get(i)).perform();
		}
*/
	}

}
