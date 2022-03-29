package CA_video;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class video {
public static WebDriver driver;
	@BeforeTest
    public void start() throws Exception {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.cricket.com.au/");
    driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div/div[3]/ul/li[2]/a")).click();
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
		XSSFSheet sheet1=wb.getSheetAt(0);
		int rowCount1=sheet1.getLastRowNum();
		XSSFSheet sheet2=wb.getSheetAt(1);
		int rowCount2=sheet2.getLastRowNum();
		System.out.println(rowCount2);
		Actions aa=new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver,50);
		for(int i=1;i<=rowCount2;i++) 
		{
		String data2=sheet2.getRow(i).getCell(1).getStringCellValue();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div/div[1]/div/div/div/div[1]"))).click();
	    aa.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'"+data2+"')]")))).click().build().perform();
		Thread.sleep(8000);
		for(int j=1;j<=rowCount1;j++) 
		{
		String data1=sheet1.getRow(j).getCell(1).getStringCellValue();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/main/section/div[2]/div/div[2]/div/div/div/div[1]"))).click();
	    aa.moveToElement(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'"+data1+"')]")))).click().build().perform();
		}}}
    
    @AfterTest
	public void stop() {
	driver.quit();
	}}