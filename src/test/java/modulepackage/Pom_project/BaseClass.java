package modulepackage.Pom_project;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import utils.Itest_listener_logic;


public class BaseClass extends Itest_listener_logic {

	String given_url = "https://www.amazon.in/";
	SoftAssert sa=new SoftAssert();
	
	@BeforeClass
	public void launch_browser() throws InterruptedException
	{
		driver= new FirefoxDriver();
		driver.get(given_url); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
	}

	@AfterClass
	public void close_brower() {
		driver.close();
	}

}
