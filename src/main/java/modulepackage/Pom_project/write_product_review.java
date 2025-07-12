package modulepackage.Pom_project;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class write_product_review {
	
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	int star_rate_input = 4;
	int actual_star_click_count = 0;
	int star_not_clicked_count = 0;
	int final_start_rating_count = 0;
	
	
	@FindBy (xpath="//div[@class='in-context-ryp__form-field--starRating']/span")
	List <WebElement>  star_isDplayed;
	public void star_displayed(int star_rating_input) throws InterruptedException
	{
		 wait.until(ExpectedConditions.visibilityOfAllElements(star_isDplayed));
		 
		 int total_star_rating = star_isDplayed.size();
		 
		 for(int i=0; i<=star_rating_input-1; i++)
		 {
			 star_isDplayed.get(i).click();
			 actual_star_click_count++;
		 }
		 	int star_not_clicked_count = total_star_rating - actual_star_click_count;
			int final_start_rating_count = total_star_rating - star_not_clicked_count;
			
			System.out.println("no of times the star clicked is a loop ---->" + actual_star_click_count);
			System.out.println("star given value fetch from screen   ---->" + final_start_rating_count);
			System.out.println("stars left value   ---->" + star_not_clicked_count);
			
			Assert.assertEquals(final_start_rating_count, star_rate_input, "actual star rating and input star rating is not match");
	}
	
	
	
	@FindBy (xpath="//textarea[@id='reviewText']")
	WebElement review_descp;
	public boolean  review_input(String pass_value) throws InterruptedException
	{
		 wait.until(ExpectedConditions.visibilityOf(review_descp));
		 boolean review_descrption=review_descp.isDisplayed();
		 review_descp.sendKeys(pass_value);
		 return review_descrption;
	}
	
	
	@FindBy (id="reviewTitle")
	WebElement review_title;
	public boolean review_title_input(String pass_value) throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(review_title));
		boolean value=review_title.isDisplayed();
		review_title.sendKeys(pass_value);
		return value;
	}
	
	@FindBy (xpath="//span[@class='a-button-inner']//input[@type='submit']")
	WebElement review_submit;
	public boolean review_submitt() throws InterruptedException
	{
		wait.until(ExpectedConditions.visibilityOf(review_submit));
		boolean submit_displayed=review_submit.isDisplayed();
		review_submit.sendKeys(Keys.ENTER);
		return submit_displayed;
	}
	
	
	
	@FindBy (xpath="//span[@class='a-color-tertiary in-context-ryp__thankyou-subheader']")
	WebElement reveiw_descp_text;
	public String verfiy_review_text() throws InterruptedException
	{
		String passvalue="";
		wait.until(ExpectedConditions.visibilityOf(reveiw_descp_text));
		boolean value=reveiw_descp_text.isDisplayed();
		if(value==true)
		{
			String text_value=reveiw_descp_text.getText();
			passvalue=text_value;
		}
		return passvalue;
		
	}
	
	
	
	
	
	
	
	
	
	public write_product_review(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
