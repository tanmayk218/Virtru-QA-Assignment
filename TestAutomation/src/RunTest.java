import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import junit.framework.Assert;

import org.openqa.selenium.By;




public class RunTest {
	static WebDriver webDriver;


	@SuppressWarnings("deprecation")
	@Test
	public void test() throws InterruptedException, IOException, AWTException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension=C:/Users/Tanmay/AppData/Local/Google/Chrome/User Data/Default/Extensions/nemmanchfojaehgkbgcfmdiidbopakpp/7.6.4.0_0");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		System.setProperty(
				"webdriver.chrome.driver",
				"C:/Users/Tanmay/Desktop/chromedriver.exe");

		// Open the Chrome browser
		webDriver = new ChromeDriver(capabilities);
		webDriver.manage().window().maximize();

		Thread.sleep(2000);

		webDriver.navigate().to("https://www.gmail.com");

		Thread.sleep(5000);

		login();

		compose();

		Thread.sleep(5000);

	}

	private static void login() throws InterruptedException {

		webDriver.findElement(By.id("identifierId")).sendKeys("tanmaykharshikar@gmail.com");

		webDriver.findElement(By.id("identifierNext")).click();

		Thread.sleep(5000);

		webDriver.findElement(By.name("password")).sendKeys("******************");

		webDriver.findElement(By.id("passwordNext")).click();

		Thread.sleep(10000);

	}

	private static void compose() throws InterruptedException, IOException, AWTException {

		webDriver.findElement(By.cssSelector(".T-I.J-J5-Ji.T-I-KE.L3")).click();

		Thread.sleep(2000);
		
		webDriver.findElement(By.cssSelector(".virtru-slider-handle")).click();
		
		Thread.sleep(2000);

		webDriver.findElement(By.cssSelector(".virtru-firsttime-activation-button.virtru-activation-button")).click();
		
		Thread.sleep(2000);

		webDriver.findElement(By.cssSelector(".virtru-intro-message-toggle-button")).click();
		
		Thread.sleep(2000);

		webDriver.findElement(By.cssSelector(".virtru-floating-popover-main-button")).click();
		
		Thread.sleep(2000);

		webDriver.findElement(By.id(":rm")).sendKeys("This is the message body to be encrypted");
		
		Thread.sleep(3000);
		
		webDriver.findElement(By.id(":qs")).click();
		
		Thread.sleep(1000);
		
		webDriver.findElement(By.id(":qz")).sendKeys("tanmaykharshikar@gmail.com");
		
		Thread.sleep(1000);

		webDriver.findElement(By.id(":rm")).click();
		
		Thread.sleep(1000);

		webDriver.findElement(By.id(":qh")).click();
		
		Thread.sleep(1000);
		
		webDriver.findElement(By.id(":qh")).sendKeys("Sending an Encrypted message");
		
		Thread.sleep(1000);

		webDriver.findElement(By.cssSelector(".virtru-intro-editable-body")).click();
		
		Thread.sleep(1000);

		webDriver.findElement(By.cssSelector(".virtru-intro-editable-body")).sendKeys("This is an intro message");
		
		Thread.sleep(2000);

		webDriver.findElement(By.id(":s7")).click();

		attach();
		
		Thread.sleep(2000);

		webDriver.findElement(By.cssSelector(".T-I.J-J5-Ji.aoO.T-I-atl.L3.virtru-modded")).click();

		Thread.sleep(5000);
		
		webDriver.findElement(By.cssSelector(".yW")).click();
		
		Thread.sleep(5000);

		String text = webDriver.findElement(By.cssSelector(".virtru-sender-body")).getText();

		Thread.sleep(2000);

		testEmailcontents(text);

		Thread.sleep(2000);
		
		String text2 = webDriver.findElement(By.cssSelector(".virtru-attachment-content")).getText();
		
		System.out.println("This is attachment name: " + text2);

		testAttachmentFileName(text2);

		webDriver.close();
		webDriver.quit();

	}

	private static void attach() throws InterruptedException, IOException, AWTException {

		Robot r = new Robot();
		Thread.sleep(1000);

		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}



	public static void testEmailcontents(String text)
	{
		assertEquals("This is the message body to be encrypted\n\nRegards,\nTanmay Kharshikar\nMob: +1(571)3739528\n\ntanmay.txt\n.tdf (19 B)",text);
		System.out.println("Success");
	}

	public static void testAttachmentFileName(String text)
	{
		assertEquals("tanmay.txt\n.tdf (19 B)",text);
		System.out.println("Success");
	}
}
