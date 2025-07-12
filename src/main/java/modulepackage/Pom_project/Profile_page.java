package modulepackage.Pom_project;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Profile_page {
	
	WebDriver driver;
	WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(60));
	
	
	
	//profile page verification
	@FindBy (xpath="(//div[@class='primary desktop'])[1]")
	WebElement verify_title;
	public boolean profile_page_verfication()
	{
		wait.until(ExpectedConditions.visibilityOf(verify_title));
		boolean value=verify_title.isDisplayed();
		return value;
	}
	
	@FindBy (xpath="//button[@class='edit-pencil-icon-button']")
	WebElement edit_pencil_icon;
	public void click_on_edit_icon()
	{
		wait.until(ExpectedConditions.visibilityOf(edit_pencil_icon));
		edit_pencil_icon.click();
	}

	@FindBy (xpath="//div[@class='profile-name desktop']")
	WebElement get_actual_name;
	public String get_actual_name()
	{
		String actual_val=get_actual_name.getText();
		return actual_val;
	}
	
	@FindBy (id="editProfileNameInputId")
	WebElement profile_edit_icon;
	public void profile_edit_icon()
	{
		wait.until(ExpectedConditions.visibilityOf(profile_edit_icon));
		profile_edit_icon.click();
	}
	public  String  get_old_name()
	{
		wait.until(ExpectedConditions.visibilityOf(profile_edit_icon));
		String old_name_value=profile_edit_icon.getDomAttribute("value");
		return old_name_value;
	}
	public void clear_input_filed()
	{
		wait.until(ExpectedConditions.visibilityOf(profile_edit_icon));
		profile_edit_icon.clear();
	}
	public void input_new_value(String new_name_value)
	{
		wait.until(ExpectedConditions.visibilityOf(profile_edit_icon));
		profile_edit_icon.sendKeys(new_name_value);
		profile_edit_icon.sendKeys(Keys.ENTER);
	
	}
	public void refersh_page(WebDriver driver)
	{
		driver.navigate().refresh();
		
	}
	
	
	
	
	
	
	
 Profile_page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
