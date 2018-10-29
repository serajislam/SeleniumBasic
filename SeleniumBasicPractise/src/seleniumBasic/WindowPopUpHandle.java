package seleniumBasic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://popuptest.com/goodpopups.html");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[contains(text(),'Good PopUp #4')]")).click();
		
		Set <String> winHandler = driver.getWindowHandles();
		Iterator<String> it  = winHandler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("Paren window id is "+parentWindowId);
		
		String childWindowId = it.next();
		System.out.println("Child window id is "+childWindowId);
		
		
		Thread.sleep(5000);
		driver.switchTo().window(childWindowId);
		System.out.println("Child window title is "+driver.getTitle());
		driver.close();
		
		Thread.sleep(5000);
		driver.switchTo().window(parentWindowId);
		System.out.println("Parent window title is "+driver.getTitle());
		driver.close();
		
		

	}

}
