package Base;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclasss {
	
	public static WebDriver driver;
	
	@BeforeTest
	public void first(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	    }
	
    public void star(){
		 JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript("return document.readyState").toString().equals("complete"))
	    {System.out.println("Page has loaded");
	    }else 
	    {System.out.println("Page has not loaded");
	    }}
	
	public void dataread(int a) throws Exception {
		File src= new File("C:\\Users\\sahil.rana\\Data Driven.xlsx");
		FileInputStream fis=new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet4=wb.getSheetAt(a);
		int rowCount4=sheet4.getLastRowNum();
		System.out.println(rowCount4); 
	}
}
