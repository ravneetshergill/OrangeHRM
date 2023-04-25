package basepackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMClass {
	
	public static Properties prop = new Properties();
	public static WebDriver driver;
	
	//Step 1 : config.properties
	public BaseHRMClass(){
		try {
			FileInputStream file = new FileInputStream("C:\\Users\\ravne\\Documents\\Eclipse Workbench\\HRManagement\\src\\test\\java\\environment\\config.properties");
			prop.load(file);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException o) {
			o.printStackTrace();
		}
	}
	
	//Step 2 : common functios for all classes
	public static void initiation() {
		//Selecting browser
		String browser = prop.getProperty("browser");
		
		if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(op);
			
		}
		
		else if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe"); driver = new FirefoxDriver(); 
		}
		driver.get(prop.getProperty("url"));
		
	}
}
