package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy (xpath = "//input[@id='user-name']")private WebElement txtUsername;
	@FindBy (xpath = "//input[@id='password']")private WebElement txtPassword;
	@FindBy (xpath = "//input[@id='login-button']")private WebElement btnLogin;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername(String value) {
		txtUsername.sendKeys(value);
	}
	
	public void enterPassword(String value) {
		txtPassword.sendKeys(value);
	}
	public void clickOnLoginButton() {
		btnLogin.click();
	}
	
}
