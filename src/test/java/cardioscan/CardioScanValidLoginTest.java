package cardioscan;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CardioScanValidLoginTest extends TestBase{
	
	@BeforeMethod
	public void initializeDriver() {
		
		driver=initialize();
	}
	


	//@Test
	public void cardioScanValidLogin() {
		
//		  <name>com.cardioscan</name>
//		  <url>http://maven.apache.org</url>  <packaging>jar</packaging>
		
		userLogin("atif.raza@Cardioscan.com.au","Admin@321");
		System.out.println(driver.findElement(By.linkText("Home")));
		Assert.assertTrue(driver.findElement(By.linkText("XHomeX")).isDisplayed(),"Volenterly failing with invalid locator");
	}
	
	@Test
	public void cardioScanInvalidLogin() {
		
		userLogin("atif.raza@Cardioscan.com.au","Admin@321aaa");
		String msg=	driver.findElement(By.cssSelector(".field-validation-error.text-danger")).getText();
		System.out.println(msg);
		Assert.assertTrue(driver.findElement(By.cssSelector(".field-validation-error.text-danger")).isDisplayed());
		//Assert.assertTrue(false);
		
	}
	
	public void userLogin(String userName, String password) {
		
		driver.get("http://bbv2dev.cardioscan.com.au/Account/Login");
		driver.findElement(By.cssSelector("#Email")).sendKeys(userName);
		driver.findElement(By.cssSelector("#Password")).sendKeys(password);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-block btn-lg btn-signin']")).click();
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
}
