package seleniumBasic;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkAndImageTest {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		//driver.get("https://www.ebay.com");
		driver.get("https://www.freecrm.com/");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.name("username")).sendKeys("SerajIslam");
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		System.out.println(driver.getTitle());
		
		
		driver.switchTo().frame(1);
		
		List<WebElement> linkLists = driver.findElements(By.tagName("a"));
		linkLists.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Total links are "+linkLists.size());
		
		ArrayList <WebElement> activeLinks = new ArrayList <WebElement>();
		
		for(int i=0;i<linkLists.size();i++)
		{
			//System.out.println(linkLists.get(i).getAttribute("href"));
			if(linkLists.get(i).getAttribute("href")!= null && ( !linkLists.get(i).getAttribute("href").contains("javascript")))
			{
				activeLinks.add(linkLists.get(i));
			}
		}
		
		System.out.println("Total active links are "+activeLinks.size());
		
		for(int j=0;j<activeLinks.size();j++)
		{
			HttpURLConnection httpCon = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
			Thread.sleep(500);
			httpCon.connect();
			String ok = httpCon.getResponseMessage();
			
			System.out.println(activeLinks.get(j).getAttribute("href")+ "-->> "+ok);
			
			httpCon.disconnect();
			
			
		}

		driver.close();
	}

}
