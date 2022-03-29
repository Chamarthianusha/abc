package CA_fixtures;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.baseclasss;
import io.github.bonigarcia.wdm.WebDriverManager;

public class location {
	  public static WebDriver driver;
		
	  @BeforeTest
	  
	    public void start() throws Exception {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.cricket.com.au/");
	    driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div/div[3]/ul/li[3]/a")).click();
	    JavascriptExecutor j = (JavascriptExecutor)driver;
	    if (j.executeScript("return document.readyState").toString().equals("complete"))
	    {System.out.println("Page has loaded");
	    }else 
	    {System.out.println("Page has not loaded");
	    }}
		
		    @Test
			public void data() throws Exception{
				File src= new File("C:\\Users\\sahil.rana\\New folder\\CA_datadriven\\target\\Data Driven.xlsx");
				FileInputStream fis=new FileInputStream(src);
				XSSFWorkbook wb=new XSSFWorkbook(fis);
				XSSFSheet sheet3=wb.getSheetAt(4);
				int rowCount3=sheet3.getLastRowNum();
				System.out.println(rowCount3);
				Actions aa=new Actions(driver);
				for(int i=1;i<=rowCount3;i++) 
				{
				driver.findElement(By.xpath("//*[@id=\"Location\"]")).click();
				Thread.sleep(5000);
				String data3=sheet3.getRow(i).getCell(1).getStringCellValue();
			    aa.moveToElement( driver.findElement(By.xpath("//*[@venuename=\""+data3+"\"]"))).click().build().perform();
		    	Thread.sleep(5000);
		    	driver.findElement(By.xpath("//*[@id=\"0hrsmatchcount1\"]")).click();
		    	Thread.sleep(5000);
				}}
		    
		        @AfterTest
		    	public void stop() {
		    		driver.quit();
		    	}
	   
}
