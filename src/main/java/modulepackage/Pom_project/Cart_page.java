package modulepackage.Pom_project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart_page {

	WebDriver driver;
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
	
	
		//cart button heading
		@FindBy (xpath="(//span[@class='a-button-inner']//span[@class='a-size-base-plus'])[1]")
		WebElement cart_pagetext;
		public String signup_button_text()
		{
			String value=cart_pagetext.getText();
			return value;
		}
	
	
	
	//cart page button
	@FindBy (xpath="(//span[@class='a-button-inner']//span[@class='a-size-base-plus'])[1]")
	WebElement signup_button;
	public boolean signup_button_displayed()
	{
		boolean value=signup_button.isDisplayed();
		return value;
	}
	
	//cart heading verification
	@FindBy (xpath="//div[@class='a-column a-span8 a-span-last']/h3")
	WebElement verify_cartPage_txt;
	public boolean verfiy_cartpage_text_isDispalayed()
	{
		wait.until(ExpectedConditions.visibilityOf(verify_cartPage_txt));
		boolean value=verify_cartPage_txt.isDisplayed();
		return value;
	}
	public String verfiy_cartpage_text_heading()
	{
		wait.until(ExpectedConditions.visibilityOf(verify_cartPage_txt));
		String value=verify_cartPage_txt.getText();
		return value;
	}
	
	
	
	
	
	
	public Cart_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
}
