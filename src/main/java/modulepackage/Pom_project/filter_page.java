package modulepackage.Pom_project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class filter_page {

	 WebDriver driver;
	 WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	    
		
	    @FindBy (xpath="(//span[@class='a-size-base a-color-base a-text-bold'])[3]")
		WebElement max_price_element_before_filter;
	    public String  max_price_element_before_filter_get_text()
	    {
	    	String value=max_price_element_before_filter.getText();
	    	return value;
	    }
	    
	    public String  remove_currency_symbol(String passvalue)
	    {
	    	String value=passvalue.substring(1);
	    	return value;
	    }
	    
	    public String  repalce_comma(String passvalue)
	    {
	    	String value=passvalue.replace(",", "");
	    	return value;
	    }
	    
	    public String  repalce_plus_sign(String passvalue)
	    {
	    	String value=passvalue.replace("+", "");
	    	return value;
	    }
	    
	    @FindBy (xpath="//ul[@id='filter-n']//li[@id='n/1378509031']//span[@class='a-size-base a-color-base']")
	    WebElement category_name;
	    public String verify_category()
	    {
	    	String value=category_name.getText();
	    	return value;
	    }
	    
	    
	  
	    
	    
	    
	    @FindBy (id="p_36/range-slider_slider-item_upper-bound-slider")
	    WebElement upper_bond;
	    @FindBy (xpath="//input[@aria-label='Go - Submit price range']")
	    WebElement go_button;
	    public void Handle_slider_click_on_go_button(WebDriver driver, int range) throws InterruptedException
	    {
			String max_value=upper_bond.getAttribute("max");
			int new_value=Integer.parseInt(max_value);
			for (int i=new_value; i>=range-1; i--)
			{
				upper_bond.sendKeys(Keys.LEFT);
			}
			Thread.sleep(2000);	
			go_button.click();
			Thread.sleep(4000);	
	    }
	    
	    
	    
	    
	    public filter_page( WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }

	    
	    
	
	
}
