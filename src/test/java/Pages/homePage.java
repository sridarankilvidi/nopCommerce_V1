package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testPages.loginPage;

public class homePage {
	WebDriver driver;
	@FindBy(css=".ico-login")
	private WebElement loginLink;

	public homePage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
	}
	
	public loginPage loginLinkClick() {
		return new (loginLink.click());
		
	}
	
}
