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
import pom.LoginPage;
import pom.VerifyDetailsPage;
import utility.Report;

public class VerifyDetailsTest {

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
public void verifyDetailsOnProductDescriptionPageIsSimiliarToProductDisplayPage() throws InterruptedException
{
test=extentreports.createTest("verifyDetailsOnProductDescriptionPageIsSimiliarToProductDisplayPage");
	
	loginPage=new LoginPage(driver);
	loginPage.enterUsername("standard_user");
	loginPage.enterPassword("secret_sauce");
	loginPage.clickOnLoginButton();

	
	
	verifyDetails=new VerifyDetailsPage(driver);
	String ProductName=verifyDetails.getProductName(0, driver);
	System.out.println(ProductName);
	double productPrice=verifyDetails.getProductPrice(0);
	System.out.println(productPrice);
	
	cartPage=new CartPage(driver);	
	cartPage.clickOnProduct(0);
	String DecName=verifyDetails.getDecProductName(driver);
	System.out.println(DecName);
	double DecproductPrice=verifyDetails.getDecProductPrice();
	System.out.println(DecproductPrice);
	
	Assert.assertEquals(ProductName,DecName);
	Assert.assertEquals(productPrice,DecproductPrice);
	
	
	
	
}

@Test
public void verifyDetailsOnAddToCartPageIsSimiliarToProductDescriptionPage() throws InterruptedException
{
test=extentreports.createTest("verifyDetailsOnAddToCartPageIsSimiliarToProductDescriptionPage");
	
	loginPage=new LoginPage(driver);
	loginPage.enterUsername("standard_user");
	loginPage.enterPassword("secret_sauce");
	loginPage.clickOnLoginButton();

	cartPage=new CartPage(driver);
	cartPage.clickOnProduct(0);
	
	verifyDetails=new VerifyDetailsPage(driver);
	String DecName=verifyDetails.getDecProductName(driver);
	System.out.println(DecName);
	double DecproductPrice=verifyDetails.getDecProductPrice();
	System.out.println(DecproductPrice);
	
	cartPage.clickOnATC();
	cartPage.clickOnATCIconButton();
	
	String AtcName=verifyDetails.getAtcProductName(0, driver);
	System.out.println(AtcName);
	double AtcproductPrice=verifyDetails.getAtcProductPrice(0);
	System.out.println(AtcproductPrice);
	
	Assert.assertEquals(DecName,AtcName);
	Assert.assertEquals(DecproductPrice,AtcproductPrice);
	
	
	
	
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
