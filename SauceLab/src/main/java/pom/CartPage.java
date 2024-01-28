package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

	@FindBy (xpath = "//div[@class='inventory_item_img']")private List<WebElement>  ProductImg;
	@FindBy (xpath = "//button[text()='Add to cart']")private WebElement AddtoCart;//product Description Page
	@FindBy (xpath = "//button[@id='back-to-products']")private WebElement BackToProduct;
	@FindBy (xpath = "//a[@class='shopping_cart_link']")private WebElement ATCIcon;
	
	@FindBy (xpath = "//button[@class='btn btn_primary btn_small btn_inventory ']")private List<WebElement> DisPAddtoCart;//Product Display Page
	
	@FindBy (xpath = "//button[@class='btn btn_secondary btn_small cart_button']")private List<WebElement> ATCRemove;//AddToCartPage
	
	@FindBy (xpath = "//button[@class='btn btn_secondary btn_small btn_inventory']")private WebElement PDecRemove;///product Description Page
	
	@FindBy (xpath = "//button[@class='btn btn_secondary btn_small btn_inventory ']")private List<WebElement> PDisRemove;//product Display page
	
	@FindBy (xpath = "//button[@id='checkout']")private WebElement Checkout;
	
	public CartPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnProduct(int index)
	{
		ProductImg.get(index).click();
	}
	
	
	public void clickOnATC()
	{
		AddtoCart.click();
	}
	
	public void clickOnBackToProduct()
	{
		BackToProduct.click();
	}

	public void clickOnATCIconButton() throws InterruptedException
	{
		Thread.sleep(3000);
		ATCIcon.click();
	}
	public void clickOnDPAddtoCart(int index) throws InterruptedException
	{
		Thread.sleep(3000);
		DisPAddtoCart.get(index).click();
	}
	
	public void clickOnATCRemove(int index) throws InterruptedException
	{
		Thread.sleep(3000);
		ATCRemove.get(index).click();
	}
	
	public void clickOnDecRemove() throws InterruptedException
	{
		Thread.sleep(3000);
		PDecRemove.click();
	}
	
	public void clickOnPdisRemove(int index) throws InterruptedException
	{
		Thread.sleep(5000);
		PDisRemove.get(index).click();
	}
	
	public void clickOnCheckOut() throws InterruptedException
	{
		Thread.sleep(2000);
		Checkout.click();
	}
	
	
	
}
