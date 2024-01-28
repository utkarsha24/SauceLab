package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

	
	
	@FindBy (xpath = "//button[@id='finish']")private WebElement finish;//payment
	@FindBy (xpath = "//h2[text()='Thank you for your order!']")private WebElement checkOutText;//checkOut
	@FindBy (xpath = "//button[@id='cancel']")private WebElement cancelPayment;//checkOut
	
	public CheckOutPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		public String getcheckOutText()
		{
			return checkOutText.getText();
		}
		public void clickOnFinish() throws InterruptedException
		{
			Thread.sleep(3000);
			finish.click();
		}
		
		public void clickOncancel() throws InterruptedException
		{
			Thread.sleep(3000);
			cancelPayment.click();
		}
}