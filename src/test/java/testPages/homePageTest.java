package testPages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import Pages.baseClass;
import Pages.homePage;

public class homePageTest extends baseClass{
	private homePage hp;
	private loginPage lp;
	public static Logger log;
	public ExtentTest test;
	
	@BeforeClass
	
	public void setUpTest() {
		//test = extentReport.createTest("HomePageTest");
		log = Logger.getLogger(homePageTest.class.getName());
		log.info("setup the environment for the test");
		hp = setUp();
		Assert.assertNotNull(hp,"ERROR !! nopcommerce home page is NOT launced!");
		log.info("nopcommerce home page is launced successfully!");
	}
	
	@Test(priority=1)
	public void clickLoginLinkTest() {
		lp = hp.loginLinkClick();
		Assert.assertNotNull(lp,"ERROR !! nopcommerce loginLink Click is not working!");
		log.info("nopcommerce login page is launced successfully!");
	}
	
					
}
	
