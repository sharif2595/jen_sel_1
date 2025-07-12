package utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Itest_listener_logic implements ITestListener {

	public static WebDriver driver;

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
		
		Date d1= new Date();
		d1.getTime();
		Date d2= new Date(d1.getTime());
		
		String format1=d2.toString();
		String day=format1.substring(0, 4);
		String month=format1.substring(4, 7);
		String hour=format1.substring(7, 10);
		String min=format1.substring(10, 13);
		String format2= day+month+hour+min;
		
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		Itest_listener_logic list_logic=new Itest_listener_logic();
		File desn=new File("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\pass_screenshot\\"+ list_logic+format2+".png");
		try {
			FileHandler.copy(source, desn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
 
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailure(result);
		
		Date d1= new Date();
		d1.getTime();
		Date d2= new Date(d1.getTime());
		
		String format1=d2.toString();
		String day=format1.substring(0, 4);
		String month=format1.substring(4, 7);
		String hour=format1.substring(7, 10);
		String min=format1.substring(10, 13);
		String format2= day+month+hour+min;
		
		
		
		
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		Itest_listener_logic list_logic=new Itest_listener_logic();
		File desn=new File("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\failed_screenshot\\"+ list_logic+format2+".png");
		try {
			FileHandler.copy(source, desn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	}


