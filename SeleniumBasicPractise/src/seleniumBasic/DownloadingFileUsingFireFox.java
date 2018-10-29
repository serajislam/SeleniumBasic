package seleniumBasic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class DownloadingFileUsingFireFox {

	public static void main(String[] args) {
//		
//		FirefoxProfile profile = new FirefoxProfile();
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
//		profile.setPreference("browser.download.manager.showWhenStarting", false);
//		
//		FirefoxOptions option = new FirefoxOptions();
//		option.setProfile(profile);
		
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference( "pdfjs.disabled", true );
		
		FirefoxOptions option =new FirefoxOptions();
		option.setProfile(profile);
		
		profile.setPreference("browser.download.dir", "C:\\Users\\Seraj Islam\\Desktop\\DownloadBySelenium");
		
		
System.setProperty("webdriver.gecko.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\geckodriver-v0.21.0-win64\\geckodriver.exe");
		
		//WebDriver driver= new ChromeDriver();

		WebDriver driver= new FirefoxDriver(option);
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
		
		driver.close();
	}

}
