package mousekeyboardoperation0070;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import day1.openBrowser;

public class hover0070 {

	public static void main(String[] args)
	{
		// hover
		WebDriver driver = openBrowser.requiredBrowser0070("chrome");
		driver.get("https://www.espncricinfo.com/");
		List<WebElement> e=driver.findElements(By.xpath("//div[@class='ds-flex ds-items-center ds-justify-between ds-flex-1']/div/div/a"));
		e.size();
		Actions action0070=new Actions(driver);
		for (int i=0;i<e.size();i++)
		{
			action0070.moveToElement(e.get(i)).perform();
		}
		System.out.println("---------------------------------");
		action0070.moveToElement(e.get(3),100,0).perform();
		action0070.moveToElement(e.get(0),100,0).perform();
	}

}
