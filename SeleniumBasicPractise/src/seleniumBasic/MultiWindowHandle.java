package seleniumBasic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultiWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://toolsqa.com/automation-practice-switch-windows");
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@onclick='newBrwTab()']")).click();
		
		Set<String> winHandler = driver.getWindowHandles();
		
		Iterator <String> it =winHandler.iterator();
		
		String parendWinId = it.next();
		System.out.println("Parent window id is "+parendWinId);
		
		String childWinId = it.next();
		System.out.println("Child window id is "+childWinId);
		
		Thread.sleep(3000);
		
		driver.switchTo().window(childWinId);
		System.out.println("Child window title is "+driver.getTitle());
		
		Thread.sleep(3000);
		
		Actions action= new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//span[text()='ABOUT']"))).build().perform();
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("About")).click();
		System.out.println(driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parendWinId);
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("FORUM")).click();
		System.out.println(driver.getTitle());
		driver.quit();
		
		
		
		
	}

}
