package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
import pom.CheckOutPage;
import pom.InformationPage;
import pom.LoginPage;
import pom.VerifyDetailsPage;
import utility.Report;

public class SuccessfulOrder {


	CartPage cartPage;
	VerifyDetailsPage verifyDetails;
	LoginPage loginPage;
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
	public void verifyIsOrderIsSuccessfulyPlace() throws InterruptedException
	{
	test=extentreports.createTest("verifyIsOrderIsSuccessfulyPlace");
		
	
	
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterUsername("standard_user");
	loginPage.enterPassword("secret_sauce");
	loginPage.clickOnLoginButton();
	
	CartPage cartPage=new CartPage(driver);	
	cartPage.clickOnProduct(0);
	cartPage.clickOnATC();
	cartPage.clickOnATCIconButton();
	cartPage.clickOnCheckOut();
	
	InformationPage informationPage=new InformationPage(driver);
	informationPage.getfName("utkarsha");
	informationPage.getLName("kedari");
	informationPage.getZCode("412106");
	informationPage.clickOnContinue();
	
	CheckOutPage checkOutPage=new CheckOutPage(driver);
	checkOutPage.clickOnFinish();
	
	Assert.assertEquals(checkOutPage.getcheckOutText(), "Thank you for your order!");
	
	}
	
	@Test
	public void verifyIfUserIsAbleTCancelTheOrder() throws InterruptedException
	{
	test=extentreports.createTest("verifyIfUserIsAbleTCancelTheOrder");
		
	
	
	LoginPage loginPage=new LoginPage(driver);
	loginPage.enterUsername("standard_user");
	loginPage.enterPassword("secret_sauce");
	loginPage.clickOnLoginButton();
	
	CartPage cartPage=new CartPage(driver);	
	cartPage.clickOnProduct(0);
	cartPage.clickOnATC();
	cartPage.clickOnATCIconButton();
	cartPage.clickOnCheckOut();
	
	InformationPage informationPage=new InformationPage(driver);
	informationPage.getfName("utkarsha");
	informationPage.getLName("kedari");
	informationPage.getZCode("412106");
	informationPage.clickOnContinue();
	
	CheckOutPage checkOutPage=new CheckOutPage(driver);
	checkOutPage.clickOncancel();
	
	}
	@Test
	public void verifyIfUserIsAbleToOrderTheMultipleProduct() throws InterruptedException
	{
	test=extentreports.createTest("verifyIfUserIsAbleToOrderTheMultipleProduct");
		
	
	
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
	cartPage.clickOnCheckOut();
	
	InformationPage informationPage=new InformationPage(driver);
	informationPage.getfName("utkarsha");
	informationPage.getLName("kedari");
	informationPage.getZCode("412106");
	informationPage.clickOnContinue();
	
	CheckOutPage checkOutPage=new CheckOutPage(driver);
	checkOutPage.clickOnFinish();
	
	
	
	

	
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
