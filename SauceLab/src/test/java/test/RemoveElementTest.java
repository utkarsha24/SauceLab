package test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pojo.LaunchBrowser;
import pom.CartPage;
import pom.LoginPage;
import utility.Report;

public class RemoveElementTest {

	
	ExtentReports extentreports;
	ExtentTest test;
	WebDriver driver;
	
	@BeforeTest
	public void configureReport()
	{
		extentreports=Report.generateReport();
	}
	
	//@Parameters({"browser"})
	@BeforeMethod
	public void openApp() {
		driver=LaunchBrowser.chrome();
	}

	@Test
	public void verifyIfUserIsAbleToRemoveTheProductFromAddTOCartPage() throws InterruptedException
	{
		test=extentreports.createTest("verifyIfUserIsAbleToRemoveTheProductFromAddTOCartPage");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLoginButton();

		CartPage cartPage=new CartPage(driver);	
		cartPage.clickOnProduct(0);
		cartPage.clickOnATC();
		
		cartPage.clickOnBackToProduct();
		cartPage.clickOnProduct(1);
		cartPage.clickOnATC();
		cartPage.clickOnATCIconButton();
		cartPage.clickOnATCRemove(0);
	}
	
	
	@Test
	public void verifyIfUserIsAbleToRemoveTheProductFromProductDescriptionPage() throws InterruptedException
	{
		test=extentreports.createTest("verifyIfUserIsAbleToRemoveTheProductFromProductDescriptionPage");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLoginButton();

		CartPage cartPage=new CartPage(driver);	
		cartPage.clickOnProduct(0);
		cartPage.clickOnATC();
		
		cartPage.clickOnDecRemove();
	}

	
	@Test
	public void verifyIfUserIsAbleRemoveProductFromProductDisplayPage() throws InterruptedException
	{
		test=extentreports.createTest("verifyIfUserIsAbleRemoveProductFromProductDisplayPage");
		
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickOnLoginButton();
		
		CartPage cartPage=new CartPage(driver);
		
		cartPage.clickOnDPAddtoCart(0);
		
		cartPage.clickOnPdisRemove(0);
		
		

	}

@AfterMethod
public void addTestStatus(ITestResult result)
{
	if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, result.getName());
	}
	else if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL, result.getName());
	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		test.log(Status.SKIP, result.getName());
	}

}

@AfterTest
public void publishReports() {

	 extentreports.flush();
   }


}
