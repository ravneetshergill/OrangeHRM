package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseHRMClass;

public class POMLogin extends BaseHRMClass {
	//Object Repository
	@FindBy(css="div.oxd-form-row:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)") WebElement username;
	@FindBy(css="div.oxd-form-row:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)") WebElement password;
	//@FindBy(id="btnLogin") WebElement loginBTN;
	//Inititate Page Elements
	public POMLogin() {
		PageFactory.initElements(driver, this);
	}
	
	//Method for sending username
	public void typeUserName(String name) {
		username.sendKeys(name);
	}
	
	//Method for sending password
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	//Method to click login button
	public void clickLoginBTN() {
		//loginBTN.click();
	}
	
	//Method to verify title of page
	public String verifyPageTitle() {
		return driver.getTitle();
	}
}
