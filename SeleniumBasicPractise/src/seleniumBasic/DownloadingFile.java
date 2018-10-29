package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DownloadingFile {

	public static void main(String[] args) {
		
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/FileDownload.html");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("textbox")).sendKeys("Hello World");
		driver.findElement(By.id("createTxt")).click();
		driver.findElement(By.id("link-to-download")).click();
		
		System.out.println(driver.getTitle());

	}

}
