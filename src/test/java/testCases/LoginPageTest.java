package testCases;

import java.sql.SQLException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import page.DatabasePage;
import page.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpageObj;
	
	@BeforeMethod
	 public void setUp() {
	  initializeDriver();
	  loginpageObj = PageFactory.initElements(driver, LoginPage.class);
	 }
 @Test
 public void loginTest() throws ClassNotFoundException, SQLException, InterruptedException {
		
	 loginpageObj.enterUserName("demo@techfios.com");
	 //loginpageObj.enterUserName(DatabasePage.getData("username"));
	 loginpageObj.enterPassword("abc123");
	// loginpageObj.enterPassword(DatabasePage.getData("password"));
	 loginpageObj.clickSignInButton();
	 Thread.sleep(2000);
	}
 @Test
 public void loginTestPage() throws InterruptedException {
	 loginpageObj.enterUserName("demo@techfios.com");
	 //loginpageObj.enterUserName(DatabasePage.getData("username"));
	 loginpageObj.enterPassword("abc123");
	// loginpageObj.enterPassword(DatabasePage.getData("password"));
	 loginpageObj.clickSignInButton();
	 String expectedTitle="Dashboard- iBilling";
	  String actualTitle=loginpageObj.getPageTitle();
	  Assert.assertEquals(expectedTitle, actualTitle); 
	 Thread.sleep(2000);
 }
	
	
	
	 @AfterMethod
	 public void tearDown() {  
	  driver.close();
	  driver.quit();
	 }

}
