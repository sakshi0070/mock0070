package mousekeyboardoperation0070;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import day1.openBrowser;

public class drag_drop 
{
public static void main(String[] args)
{
	WebDriver driver = openBrowser.requiredBrowser0070("chrome");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get("https://jqueryui.com/droppable/");
	//moving control inside the frame
			driver.switchTo().frame(0);
	Actions actn=new Actions(driver);
	WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
	WebElement target=driver.findElement(By.xpath("//div[@id=\'droppable\']"));
	System.out.println(source.getText());
	System.out.println(target.getText());
	
	actn.dragAndDrop(source, target).build().perform();
	 //or
	actn.dragAndDropBy(source,100,200).build().perform();

	
}
}
