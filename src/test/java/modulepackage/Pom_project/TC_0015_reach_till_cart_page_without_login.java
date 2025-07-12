package modulepackage.Pom_project;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(utils.Itest_listener_logic.class)
public class TC_0015_reach_till_cart_page_without_login extends BaseClass {

	
	@Test(priority = 0, retryAnalyzer = utils.Irety_analyzer.class)
	public void verify_cart_icon_click_cart_icon() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Thread.sleep(2000);
		boolean carticon_displayed=Home_Page.verfiy_cart_icon();
		sa.assertTrue(carticon_displayed);
		Home_Page.click_carticon();
		sa.assertAll();
		Reporter.log("cart icons is displayed and click on cart icon ");
	}
	
	

	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class)
	public void verify_cart_page_heading() throws InterruptedException
	{
		Cart_page Cart_page=new Cart_page(driver);
		boolean isdisplayed=Cart_page.verfiy_cartpage_text_isDispalayed();
		sa.assertEquals(isdisplayed, true);
		String actual_heading=Cart_page.verfiy_cartpage_text_heading();
		sa.assertEquals(actual_heading, "Your Amazon Cart is empty","text is worng displayed");
		sa.assertAll();
		Reporter.log("verify cart heading in cart page");
	
	}
	
	
	@Test(priority = 2, retryAnalyzer = utils.Irety_analyzer.class)
	public void verify_signin_button() throws InterruptedException
	{
		Cart_page Cart_page=new Cart_page(driver);
		boolean isdisplayed=Cart_page.signup_button_displayed();
		sa.assertEquals(isdisplayed, true);
		sa.assertAll();
		Reporter.log("verify signin button  in cart page");
	}
	
	
	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void verify_signin_button_heading() throws InterruptedException
	{
		
		Cart_page Cart_page=new Cart_page(driver);
		String actual_val=Cart_page.signup_button_text();
		sa.assertEquals(actual_val, "Sign in to your account", "Something wrong is displayed");
		sa.assertAll();
		Reporter.log("verify signin button  heading in cart page");
	}
	
	
	
}
	
	