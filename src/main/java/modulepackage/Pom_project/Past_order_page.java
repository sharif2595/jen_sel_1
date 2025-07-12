package modulepackage.Pom_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Past_order_page {
	
	WebDriver driver;
	WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	
	
	
	@FindBy (name="timeFilter")
	WebElement timefilter;
	public boolean select_timefilter(String pass_value)
	{
		Wait.until(ExpectedConditions.visibilityOf(timefilter));
		boolean value=timefilter.isDisplayed();
		Select sel=new Select(timefilter);
		sel.selectByValue(pass_value);
		return value;
		
	}
	
	
	
	
	@FindBy (xpath="(//div[@class='a-box delivery-box'])[1]")
	WebElement first_element;
	public boolean first_element_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(first_element));
		boolean value=first_element.isDisplayed();
		return value;
	}
	
	@FindBy (xpath="((//div[@class='a-box delivery-box'])[1]//ul[@class='yohtmlc-shipment-level-connections'][1]//span[@class='a-button-inner']/a)[8]")
	WebElement Click_on_product_review;
	public void click_on_review_button()
	{
		Wait.until(ExpectedConditions.visibilityOf(Click_on_product_review));
		Click_on_product_review.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public Past_order_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

}
