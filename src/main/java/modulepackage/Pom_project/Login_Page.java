package modulepackage.Pom_project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v134.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Page {
	
	
	 WebDriver driver;
	 WebDriverWait Wait= new WebDriverWait(driver, Duration.ofSeconds(60));
		
		@FindBy (id="ap_email_login")
		WebElement email_component;
		
		@FindBy (xpath="//input[@class='a-button-input']")
		WebElement Continue_button_loginpage;

		@FindBy (id="ap_password")
		WebElement password_component;
		
		@FindBy (id="signInSubmit")
		WebElement signin_button_from_login_page;
		
		@FindBy (id="auth-error-message-box")
		WebElement error_box;
		
		public boolean error_box_displayed()
		{
			Wait.until(ExpectedConditions.visibilityOf(error_box));
			boolean value=error_box.isDisplayed();
			return value;
		}
		
		
		public String get_number()
		{
			Wait.until(ExpectedConditions.visibilityOf(email_component));
			String fetch_num=email_component.getAttribute("value");
			return fetch_num;
		}
		
		public String get_password()
		{
			Wait.until(ExpectedConditions.visibilityOf(password_component));
			String fetch_pass=password_component.getAttribute("value");
			return fetch_pass;
		}
		
		
		public void input(String mobnumber)
		{
			Wait.until(ExpectedConditions.visibilityOf(email_component));
			email_component.sendKeys(mobnumber);
		}
		
		public void Click_on_continue_button()
		{
			Wait.until(ExpectedConditions.visibilityOf(Continue_button_loginpage));
			Continue_button_loginpage.click();
		}
		
		public void input_password(String pass)
		{
			Wait.until(ExpectedConditions.visibilityOf(password_component));
			password_component.sendKeys(pass);
		}
		
		public void click_on_sign_button()
		{
			Wait.until(ExpectedConditions.visibilityOf(signin_button_from_login_page));
			signin_button_from_login_page.click();
		}
		
		public Login_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

}
