import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Appiumcapabilities {

	AndroidDriver driver;

	@Test
	public void testAppium() throws MalformedURLException {

		DesiredCapabilities capability = new DesiredCapabilities();
		capability.setCapability("deviceName", "ZTE A2016");
		capability.setCapability("platformVersion", "5.0.2");
		capability.setCapability("platformName", "Android");
		capability.setCapability(CapabilityType.BROWSER_NAME, "Chrome");

		driver = new AndroidDriver(new URL("http://192.168.10.100:4723/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		Set<String> contexts = driver.getContextHandles();
		System.out.println(contexts.size());

		for (String context : contexts) {
			System.out.println(context);
		}

		driver.context("WEBVIEW_1");
		driver.get("https://www.zatro.es");

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}

}
