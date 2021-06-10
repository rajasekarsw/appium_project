package settings_auto;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import pages.SettingsPage;

public class Settingspak {
	AndroidDriver<AndroidElement> driver=null;
	TouchAction action;
	SettingsPage settingpage;
	@BeforeTest
	void config()
	{
		
		//com.android.settings/com.android.settings.Settings
		//dumpsys window windows | grep -E 'mCurrentFocus'
		//adb uninstall io.appium.uiautomator2.server
		//adb uninstall io.appium.uiautomator2.server.test
		
		DesiredCapabilities cap=new DesiredCapabilities();
		
		//MobileCapabilityType.
		
		cap.setCapability("deviceName", "android");
		
		cap.setCapability("appPackage", "com.android.settings");
		
		cap.setCapability("appActivity", ".Settings");
	
		try {
			driver=new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		action=new TouchAction(driver);
	}
	
	@Test
	void longPress()
	{
	     //settingpage=new SettingsPage(driver);
	     
	    // System.out.println(settingpage.getNotiIcon());
		
		AndroidElement element=driver.findElementById("com.android.settings:id/conditionBadge");
	    
	    action.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(element)).withDuration(Duration.ofSeconds(5))).release().perform();
		
	}
	
	@Test
	void scrollDown()
	{
		
		WebElement scrollTo=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Mobile networks\"))");
	}
	
	
	@Test
	void test()
	{
		System.out.println(1/0);
	}
	
	@Test()
	void scrollUp()
	{
		
		WebElement scrollTo=driver.findElementByAndroidUIAutomator("text(\"Mobile networks\")");
		
		action.press(PointOption.point(scrollTo.getLocation().getX(),scrollTo.getLocation().getY())).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(scrollTo.getLocation().getX(),10)).release().perform();
		
	}
	
//adb uninstall io.appium.uiautomator2.server
	
//adb uninstall io.appium.uiautomator2.server.test
	
}
