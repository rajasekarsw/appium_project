
package pages; 

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage {
	
	 AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy(id="com.android.settings:id/conditionBadge")
	private AndroidElement notiIcon;
	
	public SettingsPage(AndroidDriver<AndroidElement> driver) 
	{
		this.driver=driver;
		
		PageFactory.initElements(new AppiumFieldDecorator(driver,Duration.ofSeconds(20)), this);
	}

	public AndroidElement getNotiIcon()
	{
		return notiIcon;
		
	}
}
