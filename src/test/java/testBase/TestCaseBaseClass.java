package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestCaseBaseClass {
	
	public WebDriver driver;
	
	public Properties prop;	// to access config.properties file data
	
//	public TestCaseBaseClass(WebDriver driver) {
//		this.driver = driver;
//	}
//	
	
	
	// Setup method to initiate the Driver
	@BeforeClass
	public void setup() throws Exception {
		
		// Access URL from Properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));
		//driver.manage().window().maximize();
	}
	
	// TearDown method to close the Driver
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	// Random Details for Creating New Account
	public String nameGenerate() {
		String randomName = RandomStringUtils.randomAlphabetic(5);
		return randomName;
	}
	
	public String emailGenerator(){
		String randomEmail = RandomStringUtils.randomAlphabetic(5);
		return randomEmail;
	}
	
	public String passwordGenerator() {
		String alphabaticsUpper = RandomStringUtils.randomAlphabetic(2);
		String alphabaticsLower = RandomStringUtils.randomAlphabetic(4);
		String numbers = RandomStringUtils.randomNumeric(3);
		
		String totalPass = (alphabaticsUpper.toUpperCase() + alphabaticsLower.toLowerCase() + numbers + "@");
		return totalPass;
	}
	
	
//	// Capturing Screen Shot
//	public String captureScreen(String tname) throws IOException {
//
//		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date(0));
//				
//		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//		
//		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
//		File targetFile=new File(targetFilePath);
//		
//		sourceFile.renameTo(targetFile);
//			
//		return targetFilePath;
//
//	}
}
