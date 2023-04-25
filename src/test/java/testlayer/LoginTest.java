package testlayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseHRMClass;
import pompackage.POMLogin;
import testdata.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	
	POMLogin log;
	
	public LoginTest() {
		super();
	}
	
	@BeforeMethod
	public void initSetup() {
	initiation();
	log = new POMLogin();
	}
	
	
	@Test(priority=1) 
	public void checkPageTitle() { 
		String actual = log.verifyPageTitle();
		System.out.println(actual); 
		Assert.assertEquals(actual, "OrangeHRM"); 
	}

	@DataProvider
	public Object[][] Details(){
		Object result[][]=ExcelSheet.readData("Sheet1");
		return result;
	}
	@Test(priority=2, dataProvider="Details")
	public void Login(String name, String password) throws InterruptedException {
		Thread.sleep(2000);
		log.typeUserName(name);
		log.sendPassword(password);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
