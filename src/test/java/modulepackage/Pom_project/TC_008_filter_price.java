package modulepackage.Pom_project;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Itest_listener_logic.class)
public class TC_008_filter_price extends BaseClass {
	
	
	public String value_before_filter="";
	public String value_after_filter="";
	
	
	
	
	
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
	public void get_the_first_product_price()
	{
		Search_page Search_page=new Search_page(driver);
		String price_before_filter =Search_page.first_element_get_price();
		System.out.println(price_before_filter);
		value_before_filter=price_before_filter;
		Reporter.log("fetch the first product price");
	}
	
	
	@Test(priority = 2, retryAnalyzer = utils.Irety_analyzer.class)
	public void select_filter_price_low_to_high() throws InterruptedException
	{
		Search_page Search_page=new Search_page(driver);
		Search_page.select_drop_down_value_low_to_high(driver);
		Reporter.log("select_filter_price_low_to_high");
	}
	
	
	
	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void get_the_first_product_price_after_filter()
	{
		Search_page Search_page=new Search_page(driver);
		String price_before_filter =Search_page.first_element_get_price();
		System.out.println(price_before_filter);
		value_after_filter=price_before_filter;
		Reporter.log("get_the_first_product_price_after_filter");
	}
	
	

	@Test(priority = 4, retryAnalyzer = utils.Irety_analyzer.class)
	public void compare_price()
	{
		sa.assertNotEquals(value_before_filter, value_after_filter, "Something wrong with the value");
		sa.assertAll();
	}
	

	@Test(priority = 5, retryAnalyzer = utils.Irety_analyzer.class)
	public void select_filter_avg_coustmer_rating() throws InterruptedException
	{
		Thread.sleep(3000);
		Search_page Search_page=new Search_page(driver);
		Search_page.select_drop_down_avg_customer_rating(driver);
		Reporter.log("select filter avg coustmer rating");
	}
	
	
	@Test(priority = 6, retryAnalyzer = utils.Irety_analyzer.class)
	public void verified_avg_customer_rating_drowpdown_selected() throws InterruptedException
	{
		
		Search_page Search_page=new Search_page(driver);
		Search_page.refresh(driver);
		String value=Search_page.verified_avg_downdown_selected();
		sa.assertEquals(value, "Avg. Customer Review");
		sa.assertAll();
		Reporter.log("verified avg customer rating drowpdown selected");
	}
}
