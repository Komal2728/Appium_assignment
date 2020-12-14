package assignment1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Ebay {
	
 static AndroidDriver<MobileElement> driver;
	 

 	@BeforeMethod
 	public void setup() throws MalformedURLException {
 		DesiredCapabilities cap= new DesiredCapabilities();
		cap.setCapability("deviceName", "Infinix Hot 8");
		cap.setCapability("udid","04725329B5002510");
		cap.setCapability("platformName","android");
		cap.setCapability("platformVersion","9");
		cap.setCapability("appPackage","com.ebay.mobile");
		cap.setCapability("appActivity","com.ebay.mobile.activities.MainActivity");
		cap.setCapability("noReset", "true");
		 
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		 driver = new AndroidDriver<MobileElement>(url,cap);
		
		System.out.println("successfully opened the application");
		
 	}
	
	 @Test
	public static void Test(){
		
		 try {
		
		//search for 65 inch tv
		
		WebElement search=driver.findElement(By.id("com.ebay.mobile:id/search_box"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		search.click();
	
		driver.findElement(By.id("com.ebay.mobile:id/search_src_text")).sendKeys("65 inch tv 4k");
		driver.findElement(By.xpath("//hierarchy/android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.LinearLayout[2]//android.widget.ListView//android.widget.RelativeLayout[1]//android.widget.TextView")).click();
		
		
		driver.findElement(By.xpath("//hierarchy//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.FrameLayout//android.widget.FrameLayout//androidx.drawerlayout.widget.DrawerLayout//android.widget.LinearLayout//android.view.ViewGroup//android.widget.FrameLayout//android.view.ViewGroup//android.widget.FrameLayout//android.widget.FrameLayout//android.view.ViewGroup//android.widget.FrameLayout//androidx.recyclerview.widget.RecyclerView//android.widget.RelativeLayout[3]//android.view.ViewGroup[1]//android.widget.ImageView")).click();
		
		//Scrolling
		MobileElement element=(MobileElement) driver.findElement(MobileBy.AndroidUIAutomator( 
				"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()"+
		".scrollIntoView(new UiSelector().text(\"Similar sponsored items\"))"));
		
		//add to cart
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Add to cart']")).click();
		
		//go to cart
		driver.findElement(By.id("com.ebay.mobile:id/call_to_action_button")).click();
		
		//checkout
		driver.findElement(By.id("com.ebay.mobile:id/shopping_cart_checkout")).click();


	 }catch(Exception e) {
		 System.out.println(e.getCause());
		 System.out.println(e.getMessage());
		 e.printStackTrace();
	 }
		
	}
	 
	 @AfterMethod
	 public void quit() {
		// driver.quit();
		 System.out.println("Item checkout successfully");
	 }

}
