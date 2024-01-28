package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyPricePage {

	@FindBy (xpath = "//div[@class='inventory_item_price']")private List<WebElement> ProductPrice;//paymentPage
	@FindBy (xpath = "//div[@class='summary_tax_label']")private WebElement Tax;
	@FindBy (xpath = "//div[@class='summary_info_label summary_total_label']")private WebElement TotalPrice;
	@FindBy (xpath = "//div[@class='inventory_item_name']")private List<WebElement> ProductName;//payment Page

	

		public VerifyPricePage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public double getProductPrice(int index)
		{
			return Double.parseDouble(ProductPrice.get(index).getText().substring(1));
		}
		public double getTaxPrice()
		{
			return Double.parseDouble(Tax.getText().substring(6));
		}
		
		public double getTotalPrice()
		{
			return Double.parseDouble(TotalPrice.getText().substring(8));
		}
		public String getProductName(int index, WebDriver driver) throws InterruptedException
		{
			Thread.sleep(3000);
			return ProductName.get(index).getText();
		}
		
		
}
