package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle {

	public static void main(String[] args) {
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://www.rediff.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		
		driver.findElement(By.name("proceed")).click();
		
		Alert alert= driver.switchTo().alert();
		
		String alText=alert.getText();
		System.out.println(alText);
		
		String alertText="please enter a valid user name";
		
		if(alText.equalsIgnoreCase(alertText))
		{
			System.out.println("Correct text");
		}
		else
		{
			System.out.println("Incorrect text");
		}
		
		alert.accept();
		
		
		

	}

}
