package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyDetailsPage {
	
	@FindBy (xpath = "//div[@class='inventory_item_name ']")private List<WebElement> productName;//product Display page

	@FindBy (xpath = "//div[@class='inventory_details_name large_size']")private WebElement DecProductName;//product Description Page
	
	@FindBy (xpath = "//div[@class='inventory_item_name']")private List<WebElement> ATCproductName; //Add to cart
	
	@FindBy (xpath = "//div[@class='inventory_item_price']")private List<WebElement> productPrice;//Product Display page
	
	@FindBy (xpath = "//div[@class='inventory_details_price']")private WebElement DecProductPrice;//Description page
	
	@FindBy (xpath = "//div[@class='inventory_item_price']")private List<WebElement> ATCproductprice;//Atc page
	
	public VerifyDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String getProductName(int index, WebDriver driver) throws InterruptedException
	{
		
		return productName.get(index).getText();
	}
	
	public String getDecProductName(WebDriver driver) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.visibilityOf(DecProductName));
		
		return DecProductName.getText();
	}
	public String getAtcProductName(int index, WebDriver driver) throws InterruptedException
	{
		
		return ATCproductName.get(index).getText();
	}
	
	public double getProductPrice(int index)
	{
		return Double.parseDouble(productPrice.get(index).getText().substring(1));
	}
	
	public double getDecProductPrice()
	{
		return Double.parseDouble(DecProductPrice.getText().substring(1));
	}
	
	public double getAtcProductPrice(int index)
	{
		return Double.parseDouble(ATCproductprice.get(index).getText().substring(1));
	}
	
	
}
