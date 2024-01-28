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
import pom.LoginPage;
import utility.Report;

public class LoginPageTest {

	

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
public void verifyTheLoginPage()
{
	test=extentreports.createTest("verifyTheLoginPage");
	
	LoginPage login=new LoginPage(driver);
	login.enterUsername("standard_user");
	login.enterPassword("secret_sauce");
	login.clickOnLoginButton();
	
	
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
