package ReusableComponent;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class seleniumUtil
{		public static WebDriver driver;
		public static WebDriverWait waitt;
		public static Actions action;
		public static WebElement element;
	public WebDriver requiredBrowser(String browserName, String url)
	{
		WebDriver driver=null;
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();			
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(url);
		driver.manage().window().maximize();
		waitt=new WebDriverWait(driver,Duration.ofSeconds(30));
		return driver;		
	}
	public static void WaitTillElementIsClickable(WebElement element)
	{
		waitt.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForTitle(String title)
	{
		waitt.until(ExpectedConditions.titleIs(title));
	}
	//just for orangehrm username and password
	public static String splitUsrenameAndPwdFromUI(WebElement element)
	{	
		String[] elist=element.getText().split(":");
		String usernameAndPwdIs=elist[1];
		return usernameAndPwdIs;		
	}
	
	public static void EnterUserNameAndPwd(WebElement element,String usernameAndPwd)
	{
		element.clear();
		element.sendKeys(usernameAndPwd);	
	}
	// method to click on required element
	public static void clickOnElement(WebElement element)
	{
		waitt.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
}