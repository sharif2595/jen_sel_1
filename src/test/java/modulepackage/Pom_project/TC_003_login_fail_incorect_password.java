package modulepackage.Pom_project;



import org.testng.Reporter;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.Itest_listener_logic.class)
public class TC_003_login_fail_incorect_password  extends BaseClass{
	

	
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
	
	@Test(priority = 1, retryAnalyzer = utils.Irety_analyzer.class, dataProvider = "get_invaild_data", dataProviderClass = utils.Data_provider.class)
	public void enter_invaild_cred_and_validate_username(String username, String password) throws InterruptedException
	{	
		//enter invaild cred
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
		
		//verify username invaild username error box displayed 
		boolean error_box=Login_Page.error_box_displayed();
		sa.assertEquals(error_box,true,"error box  value is wrong");
		sa.assertAll();
		Reporter.log("verfiy error box is displayed"); 		
		
	}
	

}
