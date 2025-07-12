package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.testng.annotations.DataProvider;

public class Data_provider {
	
	
	
	//test data for login
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
	

	//test data for wrong cred
	@DataProvider(name="get_invaild_data")
	public static Object[][] get_data() throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fn= new FileInputStream("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\excel_data\\data.xlsx");
		Workbook wb=WorkbookFactory.create(fn);
		Sheet sh=wb.getSheet("Incorrect_login");
		String username= NumberToTextConverter.toText(sh.getRow(0).getCell(0).getNumericCellValue());
		String password= NumberToTextConverter.toText(sh.getRow(0).getCell(1).getNumericCellValue());
		
		System.out.println(username);
		System.out.println(password);
		
		Object[][] data_set=new Object[1][2];
		
		data_set[0][0]=username;
		data_set[0][1]=password;

		
		return data_set;
		
	}
	
	

	//test data for profile updation
	@DataProvider(name="get_profile_data")
	public static Object[][] testprofiledata() throws EncryptedDocumentException, IOException
	{
		FileInputStream fn = new FileInputStream("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\excel_data\\data.xlsx");
		Workbook wb=WorkbookFactory.create(fn);
		Sheet sh_name = wb.getSheet("profile");
		
		String name=wb.getSheet("profile").getRow(0).getCell(0).getStringCellValue();

		Object[][] d1=new Object[1][1];
		d1[0][0]=name;
		
		return d1;
	}
	
	
	//test data for searching the product
	@DataProvider(name="search_data")
	public Object[][] testsearchdata() throws EncryptedDocumentException, IOException
	{
		Object[][]data=new Object[1][1];
		
		FileInputStream fn=new FileInputStream("C:\\Users\\zafar\\eclipse-workspace\\Amazon_Pom_project\\excel_data\\data.xlsx");
		Workbook wb= WorkbookFactory.create(fn);
		String search_product_value=wb.getSheet("search_product").getRow(0).getCell(0).getStringCellValue();
		System.out.println(search_product_value);
		data[0][0]=search_product_value;
		return data;
	}
	
	
	
	
	
}
