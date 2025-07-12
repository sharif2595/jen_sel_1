package modulepackage.Pom_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Product_detail_page {
	
	
	WebDriver driver;
	WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	
	@FindBy (xpath="(//input[@type='submit'])[2]")
	WebElement Add_to_Cart_button;
	
	@FindBy (xpath="//input[@name='proceedToRetailCheckout']")
	WebElement proceed_To_buy;
	
	@FindBy (xpath="(//h3[@class='product-facts-title'])[1]")
	WebElement wishlist_button;
	public boolean wishlist_button_is_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(wishlist_button));
		boolean value=wishlist_button.isDisplayed();
		return value;
		
	}
	
	@FindBy (xpath="//span[@id='productTitle']")
	WebElement product_heading;
	public boolean product_heading_is_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(product_heading));
		boolean value=product_heading.isDisplayed();
		return value;
	}
	
	
	
	@FindBy (xpath="(//span[@class='a-price-whole'])[1]")
	WebElement product_price;
	public boolean product_price_is_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(product_price));
		boolean value=product_price.isDisplayed();
		return value;
	}
	
	
	
	@FindBy (xpath="(//span[@class='a-size-base a-color-base'])[2]")
	WebElement product_rating_element;
	public boolean product_rating_is_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(product_rating_element));
		boolean value=product_rating_element.isDisplayed();
		return value;
	}
	
	
	
	
	
	
	
	@Test(priority = 3)
	public void  verfiy_product_page() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement wishlist_button=	driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		Assert.assertTrue(wishlist_button.isDisplayed(), "product details heading is wrong");
		Thread.sleep(4000);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean cartbutton_is_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(Add_to_Cart_button));
		boolean value=Add_to_Cart_button.isDisplayed();
		return value;
	}
	
	
	
	public void click_on_add_to_cart_button()
	{
		Wait.until(ExpectedConditions.visibilityOf(Add_to_Cart_button));
		Add_to_Cart_button.click();
	}
	
	
	public boolean proceed_to_buy_button_is_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(proceed_To_buy));
		boolean value=proceed_To_buy.isDisplayed();
		return value;
	}
	
	public void click_on_proced_to_buy()
	{
		Wait.until(ExpectedConditions.visibilityOf(proceed_To_buy));
		proceed_To_buy.click();
	}
	
	
	public Product_detail_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
