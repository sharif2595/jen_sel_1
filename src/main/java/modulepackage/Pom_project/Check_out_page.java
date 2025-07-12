package modulepackage.Pom_project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Check_out_page {

    WebDriver driver;
    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
    String  attribute_value;
	//input[@value='SelectableAddCreditCard']
	@FindBy (xpath="//input[@type='radio']")
	List<WebElement> options_of_radio_button;
	public void select_credit_card_options(String payment_method)
	{
		for(int i=0; i<=options_of_radio_button.size()-1; i++)
		{
		attribute_value =options_of_radio_button.get(i).getDomAttribute("value");
		System.out.println(attribute_value);
		if (attribute_value.equals(payment_method)) 
		{
			options_of_radio_button.get(i).click();
			break;
		}
	}
		
	}
		
	
	
	//promo code 
	
	@FindBy (xpath="//input[@placeholder='Enter Code']")
	WebElement promo_code_element;
	public void input_promo_code(String promo_code)
	{
		wait.until(ExpectedConditions.visibilityOf(promo_code_element));
		promo_code_element.sendKeys(promo_code);
	}
	
	//apply button
	@FindBy (xpath="//input[@value='Apply']")
	WebElement Apply_button;
	public void click_apply_button()
	{
		wait.until(ExpectedConditions.visibilityOf(Apply_button));
		Apply_button.click();
	}
	
	
	//promo code msg
		@FindBy (xpath="(//div[@class='a-alert-content']//p)[2]")
		WebElement promo_code_msg_element;
		public boolean verfiy_promo_code_msg_is_displayed()
		{
			wait.until(ExpectedConditions.visibilityOf(promo_code_msg_element));
			boolean value=promo_code_msg_element.isDisplayed();
			return  value;			
		}
	
		public String verfiy_promo_code_msg()
		{
			wait.until(ExpectedConditions.visibilityOf(promo_code_msg_element));
			String value=promo_code_msg_element.getText();
			return value;
		
		}
	
	
	
	
	
	
	
	
	
	
	
	
		
		public boolean check_payment_options_before_clicking()
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(options_of_radio_button));
			for(int i=0; i<=options_of_radio_button.size()-1; i++)
			{
				
				boolean value=options_of_radio_button.get(i).isSelected();
				Assert.assertFalse(value);
				System.out.println( "value of radio button before clicking" + " "  +value + " "+ i);
				
			}
			return false;		
			
		}
			
			
		public boolean check_payment_options_after_clicking()
		{
			wait.until(ExpectedConditions.visibilityOfAllElements(options_of_radio_button));
			for(int i=0; i<=options_of_radio_button.size()-1; i++)
			{
				options_of_radio_button.get(i).click();
				boolean value=options_of_radio_button.get(i).isSelected();
				System.out.println( "value of radio button after clicking" + " "  +value + " "+ i);
				Assert.assertTrue(value);
				
			}
			return false;
		}
			
			
			
		
			
	/*	
	public boolean check_payment_options_before_clicking()
	{
		
		wait.until(ExpectedConditions.visibilityOfAllElements(options_of_radio_button));
		for(int i=0; i<=options_of_radio_button.size()-1; i++)
		{
			boolean value=options_of_radio_button.get(i).isSelected();
			return value;
			
		}
		return true;
	}
		
		
	public boolean check_payment_options_after_clicking()
	{
		wait.until(ExpectedConditions.visibilityOfAllElements(options_of_radio_button));
		for(int i=0; i<=options_of_radio_button.size()-1; i++)
		{
			options_of_radio_button.get(i).click();
			boolean value=options_of_radio_button.get(i).isSelected();
			System.out.println( "value of radio button after clicking" + " "  +value + " "+ i);
			Assert.assertTrue(value);
			
		}
		return false;
	}	
		
		*/
	

		
		
		public Check_out_page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
	}

	
	
	
