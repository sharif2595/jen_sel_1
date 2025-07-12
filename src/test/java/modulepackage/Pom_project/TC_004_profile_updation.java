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
public class TC_004_profile_updation extends BaseClass{
	
	
	
	@Test(priority = 0, retryAnalyzer = utils.Irety_analyzer.class)
	public void hover_element() throws InterruptedException
	{
		Home_Page hp= new Home_Page(driver);
		hp.hover_on_element(driver);
		Thread.sleep(2000);
		hp.click_on_signin_homepage();
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
		
		//verify username after login
		Home_Page Home_Page=new Home_Page(driver);
		String fetch_username=Home_Page.verfiy_user_name();
		sa.assertTrue(fetch_username.contains(name), name);
		sa.assertAll();
		Reporter.log("verfiy the name of the login user"); 
	}
	
	
	

	@Test(priority = 2, retryAnalyzer = utils.Irety_analyzer.class)
	public void Navigate_To_profile_page() throws InterruptedException
	{
		Home_Page Home_page=new Home_Page(driver);
		Thread.sleep(2000);
		Home_page.hover_on_element(driver);
		Thread.sleep(2000);
		Home_page.click_manage_prof();
		Thread.sleep(2000);
		Home_page.click_on_account_holdername("zafar");
		Thread.sleep(2000);
		Home_page.hover_on_element(driver);
		Thread.sleep(2000);
		Home_page.hover_on_dropdown(driver);
		Thread.sleep(2000);
		Home_page.click_on_image();
		Thread.sleep(2000);
		Home_page.click_on_profile_view_button("zafar");
		Thread.sleep(8000);

	}
	
	
	
	@Test(priority = 3, retryAnalyzer = utils.Irety_analyzer.class)
	public void Verify_Profile_Page() throws InterruptedException
	{
		Profile_page Profile_page=new Profile_page(driver);
		boolean prof_displayed=Profile_page.profile_page_verfication();
		sa.assertTrue(prof_displayed);
		sa.assertAll();
	}
	
	
	@Test(priority = 4, retryAnalyzer = utils.Irety_analyzer.class, dataProvider = "get_profile_data",dataProviderClass = utils.Data_provider.class)
	public void verfiy_profile_name(String profile_name) throws InterruptedException
	{
		Profile_page Profile_page=new Profile_page(driver);
		Profile_page.click_on_edit_icon();
		Profile_page.profile_edit_icon();
		String old_name_val=Profile_page.get_old_name();
		Profile_page.clear_input_filed();
		Profile_page.input_new_value(profile_name);
		Profile_page.refersh_page(driver);
		String act_val=Profile_page.get_actual_name();
		sa.assertEquals(act_val, profile_name);
		sa.assertAll();	
	}
	
}