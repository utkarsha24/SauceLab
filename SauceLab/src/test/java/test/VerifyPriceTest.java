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
import pom.VerifyPricePage;
import utility.Report;

public class VerifyPriceTest {


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
	public void verifyITwoProductPriceEqualToTotalAmount() throws InterruptedException
	{
	test=extentreports.createTest("verifyITwoProductPriceEqualToTotalAmount");
		
	
	
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
	
	VerifyPricePage verifyPrice=new VerifyPricePage(driver);
	double firstPrice=verifyPrice.getProductPrice(0);
	System.out.println(firstPrice);
	double SecondPrice=verifyPrice.getProductPrice(1);
	System.out.println(SecondPrice);
	double tax=verifyPrice.getTaxPrice();
	System.out.println(tax);
	double total=verifyPrice.getTotalPrice();
	System.out.println(total);
	
	
	VerifyDetailsPage verifyDetails=new VerifyDetailsPage(driver);
	String AtcProduct1=verifyDetails.getAtcProductName(0, driver);
	System.out.println(AtcProduct1);
	String AtcProduct2=verifyDetails.getAtcProductName(1, driver);
	System.out.println(AtcProduct2);
	
	
	String fProdctName=verifyPrice.getProductName(0, driver);
	System.out.println(fProdctName);
	String SProdctName=verifyPrice.getProductName(1, driver);
	System.out.println(SProdctName);
	
	
	Assert.assertTrue(firstPrice+SecondPrice+tax==total);
	Assert.assertEquals(AtcProduct1,fProdctName);
	Assert.assertEquals(AtcProduct2,SProdctName);
	
	
	
	
	
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
