package action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonWishList {
	
	
	
WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws Exception {
		
		System.out.println("========launchApp==========");
		
		
		
//		driver = new ChromeDriver();
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(5000);
		
	}
	
	
	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(7000);
		System.out.println("========closeApp==========");
		driver.close();
		driver.quit();
		
	}
	
	
	@Test
	public void verifyWishList() throws Exception {
		
		
		WebElement SingIn = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
//		SingIn.click();
		WebElement WishList = driver.findElement(By.xpath("//span[contains(text(),'Create a Wish')]"));
		
		
		
		Actions act = new Actions(driver);
		
		
		//app1
		act.moveToElement(SingIn).perform();
		act.moveToElement(WishList).perform();
		act.click().perform();
		
		
		
		//app2
		act.moveToElement(SingIn).moveToElement(WishList).click().perform();
		
		
		//app3
		act.moveToElement(SingIn).click(WishList).perform();
		
		Thread.sleep(3000);
		System.out.println("Application title: " + driver.getTitle());
		
	}

}
