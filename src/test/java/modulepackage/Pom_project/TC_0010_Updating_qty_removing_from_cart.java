package modulepackage.Pom_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Itest_listener_logic.class)
public class TC_0010_Updating_qty_removing_from_cart extends BaseClass {
	
	
	
	@Test(priority = 0,dataProvider ="search_data", retryAnalyzer = utils.Irety_analyzer.class, dataProviderClass = utils.Data_provider.class)
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
	
	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class)
	public void  Verify_search_input()
	{
		Search_page Search_page= new Search_page(driver);
		String fetch_value=Search_page.fetch_input();
		sa.assertEquals(fetch_value, "toy", "values are not same");
		sa.assertAll();
		Reporter.log("Verify_search_input");
	}
	
	
	@Test(priority = 2, retryAnalyzer = utils.Irety_analyzer.class)
	public void updating_cart_qty() throws InterruptedException
	{
		Search_page Search_page= new Search_page(driver);
		String get_cart_count_before_adding=Search_page.fetch_cart_count();
		sa.assertTrue(get_cart_count_before_adding.contains("0"));
		System.out.println("get_cart_count_before_adding" +  " "+ get_cart_count_before_adding);
		Search_page.click_on_first_add_to_cart_button();
		Thread.sleep(2000);
		String get_cart_count_after_adding=Search_page.fetch_cart_count();
		System.out.println("get_cart_count_after_adding" +  " "+ get_cart_count_after_adding);
		sa.assertNotEquals(get_cart_count_after_adding, get_cart_count_before_adding);
		sa.assertAll();
		Reporter.log("Verifying and updating the cart qty");
	}
	
	
	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void removing_cart_qty() throws InterruptedException
	{
		Search_page Search_page= new Search_page(driver);
		String get_cart_count_before_delete=Search_page.fetch_cart_count();
		sa.assertTrue(get_cart_count_before_delete.contains("1"));
		Search_page.click_delete_button();
		Thread.sleep(3000);
		String get_cart_count_after_removing_product=Search_page.fetch_cart_count();
		sa.assertNotEquals(get_cart_count_after_removing_product, get_cart_count_before_delete);
		sa.assertAll();
		Reporter.log("Removing the cart qty");
	}
	
	@Test(priority = 4, retryAnalyzer = utils.Irety_analyzer.class)
	public void removing_removed_msg() throws InterruptedException
	{
		Search_page Search_page= new Search_page(driver);
		String actual_value=Search_page.fetch_remove_msg();
		sa.assertTrue(actual_value.contains("was removed "), "was removed from Shopping Cart.");
		sa.assertAll();
		Reporter.log("Verifiying the Removing the cart msg");
	}
}
