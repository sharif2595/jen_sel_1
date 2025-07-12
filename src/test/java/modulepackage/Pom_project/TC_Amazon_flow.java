package modulepackage.Pom_project;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Itest_listener_logic.class)
public class TC_Amazon_flow extends BaseClass {
	
	@Test(priority = 0, retryAnalyzer = utils.Irety_analyzer.class)
	public void hover_element() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Home_Page.hover_on_element(driver);
		Home_Page.click_on_signin_homepage();
		Reporter.log("Hover on the element and click on sign in button");
	}
	
	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class, dataProviderClass = utils.Data_provider.class, dataProvider = "get_vaild_cred")
	public void enter_vaild_cred(String user_name, String Password) throws InterruptedException
	{
		Login_Page Login_Page=new Login_Page(driver);
		Login_Page.input(user_name);
		Login_Page.Click_on_continue_button();
		Login_Page.input_password(Password);
		Login_Page.click_on_sign_button();
		Reporter.log("Enter vaild cred");
		
	}
	

	@Test(priority = 2,retryAnalyzer = utils.Irety_analyzer.class,dataProviderClass = utils.Data_provider.class, dataProvider = "search_data")
	public void search_product(String product_search) throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Home_Page.search_product(product_search);
		Reporter.log("Search the prodduct");
		
	
	}
	
	
	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void click_on_first_product() throws InterruptedException
	{
	
		Search_page Search_page=new Search_page(driver);
		Search_page.click_on_first_product();
		Reporter.log("Cllick on the first product");
	
	}
	
	@Test(priority = 4,retryAnalyzer = utils.Irety_analyzer.class)
	public void click_on_add_to_cart_proceed_to_buy() throws InterruptedException
	{
		
		Product_detail_page Product_detail_page= new Product_detail_page(driver);
		Product_detail_page.click_on_add_to_cart_button();
		Product_detail_page.click_on_proced_to_buy();
		Reporter.log("click on add to cart icons and click on proceed to buy button");
	}

	
	@Test(priority = 5,retryAnalyzer = utils.Irety_analyzer.class)
	public void select_creditcard_option() throws InterruptedException
	{
		Thread.sleep(3000);
		Check_out_page Check_out_page= new Check_out_page(driver);
		Check_out_page.select_credit_card_options("SelectableAddCreditCard");
		Thread.sleep(10000);
		Reporter.log("Select the payment option as creditcard");
		
	}
	
	

}
