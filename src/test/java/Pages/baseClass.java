package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class baseClass {
	
	private static String base_url = "https://demo.nopcommerce.com/";
	private String browser = "chrome";
	private static long implicitWait = 10;
	//public ExtentSparkReporter htmlReporter;
	//public ExtentReports extentReport;
	//public ExtentTest test;
	
	public static WebDriver driver;
	// keep the driver thread safe
	public static final ThreadLocal<WebDriver> tsDriver = new ThreadLocal<>();
	
	public homePage setUp() {
		
		switch (browser){
			
		case "chrome":
			driver = new ChromeDriver();
			break;
			
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;
		
		}
		
		driver.get(base_url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
		driver.manage().window().maximize();
		tsDriver.set(driver);
		return new homePage(getDriver());	
	};
	
	// returns webdriver associated with the specific thread
	public static WebDriver getDriver() {	
		return tsDriver.get();		
	}
	
	
	public static String takeSnapShot(String methodName) {
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot;
		
		scrShot = ((TakesScreenshot)getDriver());
	
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		LocalDateTime datetime = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HHmmss");
		String formattedDate = datetime.format(myFormatObj);
		
		//String strdatetime = datetime.toString();
		String destfile = "./screenShot/"+methodName+formattedDate+".png";
		System.out.println("dest file name is: "+ destfile);
		File DestFile=new File(destfile);
		
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (methodName+formattedDate+".png");
	} 

	public void tearDown() {
		if(getDriver() != null)
			getDriver().quit();
	}
	
		
}
