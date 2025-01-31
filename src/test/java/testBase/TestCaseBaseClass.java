package testBase;

import java.io.FileReader;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestCaseBaseClass {
	
	public WebDriver driver;
	
	public Properties prop;	// to access config.properties file data
	
//	public TestCaseBaseClass(WebDriver driver) {
//		this.driver = driver;
//	}
//	
	
	// Setup method to initiate the Driver
	@BeforeClass(groups = {"Sanity","Functional","Master","Data Driven"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws Exception {
		
		// Access URL from Properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		prop = new Properties();
		prop.load(file);
		
		if(prop.getProperty("execution_env").equals("remote")) {
			
			DesiredCapabilities capab = new DesiredCapabilities();
			//OS
			if(os.equalsIgnoreCase("windows")) {
			capab.setPlatform(Platform.WIN11);
			}	
			else if(os.equalsIgnoreCase("mac")) {
				capab.setPlatform(Platform.MAC);
				}	
			else if(os.equalsIgnoreCase("linux")) {
				capab.setPlatform(Platform.LINUX);
				}
			else {
				System.out.println("No environment found");
				return;
			}
			
			//Browser
			switch(br.toLowerCase()) {
			case "chrome" : capab.setBrowserName("chrome"); break;
			case "edge" : capab.setBrowserName("MicrosoftEdge"); break;
			case "firefox" : capab.setBrowserName("firefox"); break;
			default : System.out.println("No browser found"); return;
			}
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capab);
			
		}
		
		if(prop.getProperty("execution_env").equals("local")) {
		//driver = new ChromeDriver();
		switch(br.toLowerCase()) {
		case "chrome" : driver = new ChromeDriver(); break;
		case "edge" : driver = new EdgeDriver(); break;
		case "firefox" : driver = new FirefoxDriver(); break;
		default : System.out.println("No browser found"); return;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	// TearDown method to close the Driver
	@AfterClass(groups = {"Sanity","Functional","Master","Data Driven"})
	public void tearDown() {
		driver.quit();
	}
	
//	@Test
//	public void signInApp() {
//		// Sign IN to the Application
//				HomePagePOM hp = new HomePagePOM(driver);
//				hp.clickSignIn();
//				SignInPOM sp = new SignInPOM(driver);;
//				sp.emailInputBox(prop.getProperty("workingEmail1"));
//				sp.passwordInputBox(prop.getProperty("we1Password"));
//				sp.signInbtn();
//	}
	
	
	
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
