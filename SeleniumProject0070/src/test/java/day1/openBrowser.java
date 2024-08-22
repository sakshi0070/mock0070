package day1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class openBrowser {
 public static void main(String[] args)
 	{
	WebDriver driver= requiredBrowser0070("firefox");
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		/* or 
		WebDriver dvr=new ChromeDriver();
		ChromeDriver cdvr=new ChromeDriver();
		FirefoxDriver fdvr=new FirefoxDriver();
		EdgeDriver edvr=new EdgeDriver();
		*/	
	}
 
 	public static WebDriver requiredBrowser0070(String BrowserName)
 	{
 		WebDriver driver=null;
 		if( BrowserName.equalsIgnoreCase("chrome"))
 		{
 			driver=new ChromeDriver();
 		}
 		else if(BrowserName.equalsIgnoreCase("firefox"))
 		{
 			driver=new FirefoxDriver();
 		}
 		else if(BrowserName.equalsIgnoreCase("egde"))
 		{
 			driver=new EdgeDriver();
 		}
 		return driver;
 	}

}
 
