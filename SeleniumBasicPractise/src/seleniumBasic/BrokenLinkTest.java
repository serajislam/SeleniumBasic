package seleniumBasic;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.ebay.com");
		
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
		System.out.println("Total links are "+linkList.size());
		
		for(int i=0;i<linkList.size();i++)
		{
			WebElement we = linkList.get(i);
			String totalLinksWithHttp =we.getAttribute("href");
			
			
			System.out.println(totalLinksWithHttp);
			
			URL url = new URL(totalLinksWithHttp);
			
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			Thread.sleep(5000);
			
			httpCon.connect();
			int resCode = httpCon.getResponseCode();
			
			if(resCode>=400)
			{
				System.out.println(resCode +" " + "Broken Url" );
			}
			
			else
			{
				System.out.println(resCode +" " + "Valid Url" );
			}
			
			
		}
		
		
		driver.close();

	}

}
