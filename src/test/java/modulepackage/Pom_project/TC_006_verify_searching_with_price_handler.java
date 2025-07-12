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
public class TC_006_verify_searching_with_price_handler  extends BaseClass {

	

	
	@Test(priority = 0,dataProvider ="search_data", retryAnalyzer = utils.Irety_analyzer.class,dataProviderClass = utils.Data_provider.class)
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
	

	@Test(priority = 2, retryAnalyzer = utils.Irety_analyzer.class)
	public void handle_rightside_price_range() throws InterruptedException
	{
		filter_page filter_page=new filter_page(driver);
		String max_price_value_before_filter_text=filter_page.max_price_element_before_filter_get_text();
		String remove_currency_symbol=filter_page.remove_currency_symbol(max_price_value_before_filter_text);
		String removed_comma=filter_page.repalce_comma(remove_currency_symbol);
		String max_price_value=filter_page.repalce_plus_sign(removed_comma);
		System.out.println(max_price_value);
		filter_page.Handle_slider_click_on_go_button(driver,35);
		
		String max_price_value_after_filter_text=filter_page.max_price_element_before_filter_get_text();
		String remove_currency_symbol_max_val=filter_page.remove_currency_symbol(max_price_value_after_filter_text);
		String removed_comma_1=filter_page.repalce_comma(remove_currency_symbol_max_val);
		String max_price_value_2=filter_page.repalce_plus_sign(removed_comma_1);
		System.out.println(max_price_value_2);
		
		sa.assertNotEquals(max_price_value_2, max_price_value, "Price value are same ");
		sa.assertAll();
		
		Reporter.log("handle right side price range and click on go button and asserting the price should not be equal");
	}
	
	
	

	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void verify_category() throws InterruptedException
	{
		filter_page filter_page=new filter_page(driver);
		String text_value=filter_page.verify_category();
		System.out.println(text_value);
		sa.assertEquals(text_value, "Sport & Outdoor");
		sa.assertAll();
		Reporter.log("verfiy_category name ");
	}
	


}
