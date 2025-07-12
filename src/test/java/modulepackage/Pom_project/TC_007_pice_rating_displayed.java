package modulepackage.Pom_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(utils.Itest_listener_logic.class)
public class TC_007_pice_rating_displayed  extends BaseClass {

	@Test(priority = 1,dataProvider ="search_data", retryAnalyzer = utils.Irety_analyzer.class, dataProviderClass = utils.Data_provider.class)
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

	@Test(priority = 2,retryAnalyzer = utils.Irety_analyzer.class)
	public void click_on_first_product() throws InterruptedException
	{
	
		Search_page Search_page=new Search_page(driver);
		Search_page.click_on_first_product();
		Reporter.log("Cllick on the first product");
	
	}

	@Test(priority = 3,retryAnalyzer = utils.Irety_analyzer.class)
	public void verfiy_product_heading() throws InterruptedException
	{
		
		Product_detail_page Product_detail_page=new Product_detail_page(driver);
		boolean product_heading_displayed=Product_detail_page.product_heading_is_displayed();
		sa.assertEquals(product_heading_displayed, true, "Something worng with the product heading");
		sa.assertAll();
		Reporter.log("verfiy_product_heading");
	
	}
	
	@Test(priority = 4,retryAnalyzer = utils.Irety_analyzer.class)
	public void verfiy_product_price() throws InterruptedException
	{
		
		Product_detail_page Product_detail_page=new Product_detail_page(driver);
		boolean product_price_displayed=Product_detail_page.product_price_is_displayed();
		sa.assertEquals(product_price_displayed, true,"Something worng with the price");
		sa.assertAll();
		Reporter.log("verfiy_product_price");
	}
	
	@Test(priority = 5,retryAnalyzer = utils.Irety_analyzer.class)
	public void verfiy_rating() throws InterruptedException
	{
		Product_detail_page Product_detail_page=new Product_detail_page(driver);
		boolean is_displayed_value=Product_detail_page.product_rating_is_displayed();
		if (is_displayed_value==false)
		{
			sa.assertEquals(is_displayed_value, false);
		}
		else {
			
			sa.assertEquals(is_displayed_value, true);
		}
		
		sa.assertAll();
	}
}
