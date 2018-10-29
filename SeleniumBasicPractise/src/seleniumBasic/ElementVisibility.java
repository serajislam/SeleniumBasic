package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibility {

	public static void main(String[] args) {
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("https://ebay.com");
		
		driver.findElement(By.xpath("//a[contains(text(),'register')]")).click();
		
		boolean b1=driver.findElement(By.id("ppaFormSbtBtn")).isDisplayed();
		System.out.println(b1);
		
		boolean b2=driver.findElement(By.id("ppaFormSbtBtn")).isEnabled();
		System.out.println(b2);

	}

}
