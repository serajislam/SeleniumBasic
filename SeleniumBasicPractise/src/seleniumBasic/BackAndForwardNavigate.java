package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackAndForwardNavigate {

	public static void main(String[] args) throws InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com");
		System.out.println(driver.getTitle());
		
		
		Thread.sleep(5000);
		driver.navigate().to("https://www.yahoo.com");
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		
		Thread.sleep(5000);
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		
		Thread.sleep(5000);
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		Thread.sleep(5000);
		driver.navigate().refresh();
		

	}

}
