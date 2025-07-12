package modulepackage.Pom_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_0012_Select_each_payment_method extends BaseClass {

	
	
	@Test(priority = 0, retryAnalyzer = utils.Irety_analyzer.class)
	public void hover_element() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Thread.sleep(2000);
		Home_Page.hover_on_element(driver);
		Home_Page.click_on_signin_homepage();
		Thread.sleep(2000);
		Reporter.log("Hover on the element and click on sign in button");
	}
	
	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class, dataProvider = "get_vaild_cred", dataProviderClass = utils.Data_provider.class)
	public void enter_vaild_cred_and_validate_username(String username, String password, String name) throws InterruptedException
	{
		Login_Page Login_Page=new Login_Page(driver);
	
		Login_Page.input(username);
		String get_phone_number=Login_Page.get_number();
		sa.assertEquals(get_phone_number, username, "something wrong in the username");

		Login_Page.Click_on_continue_button();
		
		Login_Page.input_password(password);
		String get_password=Login_Page.get_password();
		sa.assertEquals(get_password, password, "something wrong in the password");
	
		Login_Page.click_on_sign_button();
	
		Reporter.log("Enter vaild cred");
		sa.assertAll();
	}
	

	@Test(priority = 2,dataProvider ="search_data", retryAnalyzer = utils.Irety_analyzer.class, dataProviderClass = utils.Data_provider.class)
	public void  Search_Product_And_vaildate_Search_product(String search_product_value)
	{
		Home_Page Home_Page=new Home_Page(driver);
		Home_Page.search_product(search_product_value);
		String actual_value=Home_Page.vaildate_product_name();
		System.out.println(actual_value);
		sa.assertEquals(actual_value, "toy", "Wrong input value");
		sa.assertAll();
		Reporter.log("Search the product and validate the search product");
	}
	
	
	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void click_on_first_product() throws InterruptedException
	{
		Thread.sleep(3000);
		Search_page Search_page=new Search_page(driver);
		Search_page.click_on_first_product();
		Thread.sleep(4000);
		Reporter.log("Cllick on the first product");
	
	}
	
	@Test(priority = 4,retryAnalyzer = utils.Irety_analyzer.class)
	public void click_on_add_to_cart_proceed_to_buy() throws InterruptedException
	{
		Thread.sleep(3000);
		Product_detail_page Product_detail_page= new Product_detail_page(driver);
		
		boolean cartbutton_is_displayed=Product_detail_page.cartbutton_is_displayed();
		sa.assertTrue(cartbutton_is_displayed);
		
		Product_detail_page.click_on_add_to_cart_button();
		Thread.sleep(3000);
		
		boolean button_displayed=Product_detail_page.proceed_to_buy_button_is_displayed();
		sa.assertTrue(button_displayed);
		
		Product_detail_page.click_on_proced_to_buy();
		Thread.sleep(3000);
		Reporter.log("click on add to cart icons and click on proceed to buy button");
	}

	
	@Test(priority = 5, retryAnalyzer = utils.Irety_analyzer.class)
	public void check_card_option_before_clicking() throws InterruptedException
	{
		Thread.sleep(3000);
		Check_out_page Check_out_page= new Check_out_page(driver);
		Thread.sleep(10000);
		Check_out_page.check_payment_options_before_clicking();
		Reporter.log("check card option before clicking");
		
	}
	
	
	
	
	@Test(priority = 6, retryAnalyzer = utils.Irety_analyzer.class)
	public void check_card_option_after_clicking() throws InterruptedException
	{
		Thread.sleep(3000);
		Check_out_page Check_out_page= new Check_out_page(driver);
		Thread.sleep(10000);
		Check_out_page.check_payment_options_after_clicking();
		Reporter.log("check card option after clicking");
		
	}
	
	
	/*
	@Test(priority = 5 ,enabled=false)
	public void check_card_option_before_clicking() throws InterruptedException
	{
		Thread.sleep(3000);
		Check_out_page Check_out_page= new Check_out_page(driver);
		Thread.sleep(10000);
		boolean value=Check_out_page.check_payment_options_before_clicking();
		List<Boolean> list1= new ArrayList<Boolean>();
		while(value==false)
		{
			list1.add(value);
		}
		System.out.println(list1);
		sa.assertEquals(value, false);
		sa.assertAll();
		
		Reporter.log("check card option before clicking");
		
	}
	
	*/
}
