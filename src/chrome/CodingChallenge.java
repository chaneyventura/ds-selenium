package chrome;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

public class CodingChallenge {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","//Users//myrnabeery//Desktop//chromedriver");
		
		//Initialize browser
		WebDriver driver = new ChromeDriver();
		
		//Open directscaledev
		driver.get("https://int.corpadmin.directscaledev.com");
		driver.manage().window().maximize();
		
		//Login failure
		driver.findElement(By.name("username")).sendKeys("saruman");
		driver.findElement(By.name("password")).sendKeys("youshallnotpass");
		driver.findElement(By.className("loginmodal-submit")).click();
		
		String actual_error = driver.findElement(By.id("loginError")).getText();
		String expected_error = "";
		Assert.assertEquals(actual_error, expected_error);
		
		
		//Login success
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys("gandalf");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("Sh@d0wf@x");
		driver.findElement(By.className("loginmodal-submit")).click();
	
		//Display name
		List<WebElement> menus = driver.findElements(By.cssSelector("div#navbar  ul li a.dropdown-toggle"));
		WebElement desiredMenu = menus.get(0);
		desiredMenu.click();
		WebElement choice1 = desiredMenu.findElement(By.linkText("My Profile"));
		choice1.click();
		String displayName = driver.findElement(By.id("displayName")).getText();
		String expected_displayName = "white wizard";
		Assert.assertEquals(displayName, expected_displayName);
		
	}
}
