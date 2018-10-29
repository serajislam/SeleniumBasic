package seleniumBasic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RadioButtonAndCheckBoxTest {

	
	public static void main(String[] args) throws InterruptedException {
		
		
System.setProperty("webdriver.chrome.driver", "C:\\Users\\Seraj Islam\\Desktop\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.get("http://toolsqa.wpengine.com/automation-practice-form");
		System.out.println(driver.getTitle());
		
		List <WebElement> sexCheckBox = driver.findElements(By.name("sex"));
		
		
		boolean bl = sexCheckBox.get(1).isSelected();
		
		if(bl==false)
		{
			sexCheckBox.get(1).click();
			
			System.out.println("Female radio button is selected");
		}
		else
		{
			sexCheckBox.get(0).click();
			System.out.println("Male radio button is selected");
		}
		
		WebElement expRadioButton = driver.findElement(By.id("exp-5"));
		expRadioButton.click();
		if(expRadioButton.isSelected())
		{
			System.out.println("6 radio button is selected");
		}
		else
		{
			System.out.println("Radio button is not selected");
		}
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("datepicker")).sendKeys("09-26-2018");
		
		List <WebElement> profRadioButton  = driver.findElements(By.name("Profession"));
		
		for(int i=0;i<profRadioButton.size();i++)
		{
			String st =profRadioButton.get(i).getAttribute("value");
			if(st.equalsIgnoreCase("Automation Tester"))
			{
				profRadioButton.get(i).click();
				break;
				
			}
		}
		
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\Seraj Islam\\Pictures\\Pic1.png");
		WebElement toolCheckBox = driver.findElement(By.cssSelector("#tool-1"));
		
		toolCheckBox.click();
		
		Select selContinents = new Select(driver.findElement(By.id("continents")));
		selContinents.selectByVisibleText("Australia");
		
		Select multySelect = new Select(driver.findElement(By.id("selenium_commands")));
		
		multySelect.selectByVisibleText("Wait Commands");
		driver.findElement(By.xpath("//button[@id='submit']")).submit();
	}
}
