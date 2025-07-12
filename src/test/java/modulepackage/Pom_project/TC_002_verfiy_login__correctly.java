package modulepackage.Pom_project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(utils.Itest_listener_logic.class)
public class TC_002_verfiy_login__correctly extends BaseClass {
	

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
		Thread.sleep(2000);
		Login_Page.input(username);
		String get_phone_number=Login_Page.get_number();
		sa.assertEquals(get_phone_number, username, "something wrong in the username");
		Thread.sleep(2000);
		Login_Page.Click_on_continue_button();
		Thread.sleep(2000);
		Login_Page.input_password(password);
		String get_password=Login_Page.get_password();
		sa.assertEquals(get_password, password, "something wrong in the password");
		Thread.sleep(2000);
		Login_Page.click_on_sign_button();
		Thread.sleep(5000);
		Reporter.log("Enter vaild cred");
		sa.assertAll();
		
		//verify username after login
		Home_Page Home_Page=new Home_Page(driver);
		String fetch_username=Home_Page.verfiy_user_name();
		sa.assertTrue(fetch_username.contains(name), name);
		sa.assertAll();
		Reporter.log("verfiy the name of the login user"); 
		
	}
	
	
		
		
		
		
	}
	
