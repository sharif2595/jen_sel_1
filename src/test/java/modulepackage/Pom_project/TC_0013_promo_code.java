package modulepackage.Pom_project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Itest_listener_logic.class)
public class TC_0013_promo_code  extends BaseClass{
	
	@DataProvider(name="get_vaild_cred")
	public static Object[][] testdata() throws EncryptedDocumentException, IOException
	{
		FileInputStream fn = new FileInputStream("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\excel_data\\data.xlsx");
		Workbook wb=WorkbookFactory.create(fn);
		Sheet sh_name = wb.getSheet("Login");
		
		String name=wb.getSheet("Login").getRow(0).getCell(2).getStringCellValue();
		String username=NumberToTextConverter.toText(sh_name.getRow(0).getCell(0).getNumericCellValue());
		String password=NumberToTextConverter.toText(sh_name.getRow(0).getCell(1).getNumericCellValue());
	
		Object[][] d1=new Object[1][3];
		d1[0][0]=username;
		d1[0][1]=password;
		d1[0][2]=name;
		
		return d1;
	}
	
	
	
	
	
	@DataProvider(name="search_data")
	public Object[][] testdata2() throws EncryptedDocumentException, IOException
	{
		Object[][]data=new Object[1][1];
		
		FileInputStream fn=new FileInputStream("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\excel_data\\data.xlsx");
		Workbook wb= WorkbookFactory.create(fn);
		String search_product_value=wb.getSheet("search_product").getRow(0).getCell(0).getStringCellValue();
		System.out.println(search_product_value);
		data[0][0]=search_product_value;
		return data;
	}
	
	
	
	@Test(priority = 0, retryAnalyzer = utils.Irety_analyzer.class)
	public void hover_element() throws InterruptedException
	{
		Home_Page Home_Page=new Home_Page(driver);
		Home_Page.hover_on_element(driver);
		Home_Page.click_on_signin_homepage();
		Reporter.log("Hover on the element and click on sign in button");
	}
	
	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class, dataProvider = "get_vaild_cred")
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
	
	
	
	@Test(priority = 2,dataProvider ="search_data", retryAnalyzer = utils.Irety_analyzer.class)
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
		Search_page Search_page=new Search_page(driver);
		Search_page.click_on_first_product();
		Reporter.log("Click on the first product");
	
	}
	
	@Test(priority = 4, retryAnalyzer = utils.Irety_analyzer.class)
	public void click_on_add_to_cart_proceed_to_buy() throws InterruptedException
	{
		Product_detail_page Product_detail_page= new Product_detail_page(driver);
		Product_detail_page.click_on_add_to_cart_button();
		Product_detail_page.click_on_proced_to_buy();
		Reporter.log("click on add to cart icons and click on proceed to buy button");
	}

	
	
	@Test(priority = 5, retryAnalyzer = utils.Irety_analyzer.class)
	public void check_promo_code_applied() throws InterruptedException
	{
		Check_out_page Check_out_page= new Check_out_page(driver);
		Check_out_page.input_promo_code("FIRST100");
		Check_out_page.click_apply_button();
		Reporter.log("input promo code and click on apply button");
	}
		
	
	@Test(priority = 6, retryAnalyzer = utils.Irety_analyzer.class)
	public void verfiy_promo_code_msg() throws InterruptedException
	{
		Check_out_page Check_out_page= new Check_out_page(driver);
		String promo_code_value=Check_out_page.verfiy_promo_code_msg();
		System.out.println(promo_code_value);
		sa.assertEquals(promo_code_value,"The promotional code you entered is not valid.","Something wrong with text");
		sa.assertAll();
		Reporter.log("verfiy the promo code msg is displayed and msg contails is not vaild");
	}

}
