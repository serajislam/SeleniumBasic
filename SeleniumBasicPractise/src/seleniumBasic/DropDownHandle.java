package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandle {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com/");
		driver.findElement(By.name("userName")).sendKeys("khokon");
		driver.findElement(By.name("password")).sendKeys("khokon1");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		
		Select pass = new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
		pass.selectByVisibleText("3");
		
		Select selDepAirport = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		selDepAirport.selectByVisibleText("London");
		
		
		
		
		
	}

}
