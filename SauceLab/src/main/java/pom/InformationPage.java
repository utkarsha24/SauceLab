package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InformationPage {
	
	
@FindBy (xpath = "//input[@id='first-name']")private WebElement fName;
@FindBy (xpath = "//input[@id='last-name']")private WebElement LName;
@FindBy (xpath = "//input[@id='postal-code']")private WebElement ZCode;
@FindBy (xpath = "//input[@id='continue']")private WebElement Continue;

	public InformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getfName(String value)
	{
		fName.sendKeys(value);
	}
	public void getLName(String value)
	{
		LName.sendKeys(value);
	}
	public void getZCode(String value)
	{
		ZCode.sendKeys(value);
	}
	public void clickOnContinue()
	{
		Continue.click();
	}
	



}
