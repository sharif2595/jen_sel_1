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
public class TC_009_verify_product_added_to_cart extends BaseClass {
	
	
	@Test(priority = 0,dataProvider ="search_data", retryAnalyzer = utils.Irety_analyzer.class, dataProviderClass = utils.Data_provider.class)
	public void  Search_Product_And_vaildate_Search_product(String search_product_value)
	{
		Home_Page Home_Page=new Home_Page(driver);
		Home_Page.search_product(search_product_value);
		String actual_value=Home_Page.vaildate_product_name();
		System.out.println(actual_value);
		sa.assertEquals(actual_value, search_product_value, "Wrong input value");
		sa.assertAll();
		Reporter.log("Search the product and validate the search product");
	}
	
	@Test(priority = 1,retryAnalyzer = utils.Irety_analyzer.class)
	public void click_on_first_product() throws InterruptedException
	{
		Search_page Search_page=new Search_page(driver);
		Search_page.click_on_first_product();
		Reporter.log("Cllick on the first product");
	}
	
	
	@Test(priority = 2, retryAnalyzer = utils.Irety_analyzer.class)
	public void verify_add_to_cart() throws InterruptedException
	{
		Product_detail_page Product_detail_page= new Product_detail_page(driver);
		boolean cartbutton_is_displayed=Product_detail_page.cartbutton_is_displayed();
		sa.assertTrue(cartbutton_is_displayed);
		Product_detail_page.click_on_add_to_cart_button();
		boolean button_displayed=Product_detail_page.proceed_to_buy_button_is_displayed();
		sa.assertTrue(button_displayed);
		Reporter.log("validate item added in the cart");
	}
	

}
