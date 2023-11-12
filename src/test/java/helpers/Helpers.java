package helpers;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helpers {

	public static void sleepSeconds(int seconds){
		try {
			Thread.sleep(seconds*1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void takeScreenshot (WebDriver driver,String name) {
		File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenShot, new File("D:\\Java\\TempFiles\\Screenshots\\"+ name +System.currentTimeMillis()+".png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
