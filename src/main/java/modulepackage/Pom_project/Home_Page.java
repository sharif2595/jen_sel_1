package modulepackage.Pom_project;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Home_Page {
	
	
    WebDriver driver;
    WebDriverWait Wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    
	
    @FindBy (xpath="//div[@id='nav-link-accountList']/a")
	WebElement hover;
	
	@FindBy (xpath="//a[@class='nav-action-signin-button']")
	WebElement Signin_button_from_hompage;
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	WebElement search_box;
	
	@FindBy (xpath= "//div[@id='nav-link-accountList']/a/div/span")
	WebElement verfiy_name;

	@FindBy (xpath="//button[@class='sc-fqkvVR sc-kMkxaj lajAPo qrSrg']")
	WebElement comp2;
	
	@FindBy (xpath="//div[@id='nav-link-accountList']//a//div")
	WebElement hover4;
	
	@FindBy (xpath="//div[@class='sc-gFqAkR jSvjXZ']/div[@class='sc-dLMFU sc-ikkxIA EZIgf kpsBEL profile-detail-primary']")
	List<WebElement> holdernames;
	
	@FindBy (xpath="//a[@data-testid='profile-view-button']")
	WebElement profile_button;
	
	
	
	
	@FindBy (xpath="//a[@href='https://www.amazon.in/gp/css/homepage.html?ref_=nav_youraccount_btn']")
	WebElement sign_in_xpath;
	public boolean sign_in_xpath()
	{
		Wait.until(ExpectedConditions.visibilityOf(sign_in_xpath));
		boolean value=sign_in_xpath.isDisplayed();
		sign_in_xpath.click();
		return value;
	}
	
	
	//
	//profile page verification
	
	@FindBy (xpath="//a[@href='https://www.amazon.in/gp/your-account/order-history?ref_=ya_d_c_yo']")
	WebElement order_hyper_link;
	public boolean order_hyper_link_click()
	{
		
		Wait.until(ExpectedConditions.visibilityOf(order_hyper_link));
		boolean value=verify_cart_icon.isDisplayed();
		order_hyper_link.click();
		return value;
	}
	
	@FindBy (xpath="(//div[@class='a-section a-spacing-medium page-tabs']/ul/li)[1]")
	WebElement order_tab;
	public boolean order_tab_displayed()
	{
		Wait.until(ExpectedConditions.visibilityOf(order_tab));
		boolean value=order_tab.isDisplayed();
		order_tab.click();
		return value;
		
	}
		
	
	
	
	
	//cart icon
	@FindBy (xpath="//div[@id='nav-cart-text-container']/span[2]")
	WebElement verify_cart_icon;
	public boolean verfiy_cart_icon()
	{
		Wait.until(ExpectedConditions.visibilityOf(verify_cart_icon));
		boolean value=verify_cart_icon.isDisplayed();
		return value;
	}
	public void click_carticon()
	{
		Wait.until(ExpectedConditions.visibilityOf(verify_cart_icon));
		verify_cart_icon.click();
	}
	
	
	
	public void click_on_profile_view_button(String holder_name) throws InterruptedException
	{
		
		Wait.until(ExpectedConditions.visibilityOfAllElements(holdernames));
		for(int i=0; i<=holdernames.size()-1; i++)
		{
			String holdernamevalue1=holdernames.get(i).getText();
			if (holdernamevalue1.contains(holder_name))
			{
				Assert.assertEquals(holdernamevalue1, holder_name);
				Wait.until(ExpectedConditions.visibilityOf(profile_button));
				profile_button.click();
				break;
				
			}
			else
			{
				System.out.println("accout holder name is not present");
			}
		}
		Thread.sleep(8000);
	}
	
	public void hover_on_dropdown(WebDriver driver) throws InterruptedException
	{
		Wait.until(ExpectedConditions.visibilityOf(hover4));
		Actions act= new Actions(driver);
		act.moveToElement(hover4).perform();
	}
	
	
	
	
	@FindBy (xpath="//img[@class='sc-gmgFlS lfSCEq']")
	WebElement image_click;
	public void click_on_image() throws InterruptedException
	{
		Wait.until(ExpectedConditions.visibilityOf(image_click));
		image_click.click();
	}
	
	//profile popup click
	@FindBy (xpath="//div[@class='sc-gFqAkR jSvjXZ']/div[@class='sc-dLMFU sc-ikkxIA EZIgf kpsBEL profile-detail-primary']")
	List<WebElement> holdername;
	
	public void click_on_account_holdername(String holder_name)
	{
		Wait.until(ExpectedConditions.visibilityOfAllElements(holdername));
		for(int i=0; i<=holdername.size()-1; i++)
		{
			String holdernamevalue=holdername.get(i).getText();
			if (holdernamevalue.contains(holder_name))
			{
				Assert.assertEquals(holdernamevalue, holder_name);
				holdername.get(i).click();
				break;
				
			}
			else
			{
				System.out.println("accout holder name is not present");
			}
			
		}
	}
	
	public void click_manage_prof()
	{
		Wait.until(ExpectedConditions.visibilityOf(comp2));
		comp2.click();
	}
	
	public String verfiy_user_name()
	{
		Wait.until(ExpectedConditions.visibilityOf(verfiy_name));
		String actual_user_name=verfiy_name.getText();
		return actual_user_name;
	}

	
	public void hover_on_element(WebDriver driver)
	{
		Wait.until(ExpectedConditions.visibilityOf(hover));
		Actions act= new Actions(driver);
		act.moveToElement(hover).perform();
	}
	
	public void click_on_signin_homepage()
	{
		Wait.until(ExpectedConditions.visibilityOf(Signin_button_from_hompage));
		Signin_button_from_hompage.click();
	}
	
	public void search_product(String product_name )
	{
		Wait.until(ExpectedConditions.visibilityOf(search_box));
		search_box.sendKeys(product_name+ Keys.ENTER);
	}
	
	public String vaildate_product_name()
	{
		Wait.until(ExpectedConditions.visibilityOf(search_box));
		String value=search_box.getDomAttribute("value");
		return value;
	}
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
