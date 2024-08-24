package Practice0070;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ReusableComponent.seleniumUtil;

public class TakeScreenshot {

	public static void main(String[] args) throws IOException {
		seleniumUtil s1=new seleniumUtil();
		WebDriver driver=s1.requiredBrowser("chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		seleniumUtil.waitt.until(ExpectedConditions.invisibilityOfElementWithText(
			      By.xpath("//h5[text()='Login']"),"Login"));
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(".\\src\\test\\resources\\ScreenShots0070\\LoginPagee.jpg"));
		
                                                                                                                                       	
		/*TakesScreenshot ts = (TakesScreenshot) driver;
		// to get screenshot in the file format which return File class instance
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(".\\src\\test\\resources\\ScreenShots0070\\LoginPage4.jpg"));                     
		*/
		
		// type username
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(("admin123"), Keys.ENTER);

	}

}
