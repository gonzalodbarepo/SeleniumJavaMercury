package pages;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import helpers.*;


public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passwordField;
	private By loginBtn;
	private By fields;
	
	
	public PageLogin(WebDriver driver){
		this.driver = driver;
		userField = By.name("userName");
		passwordField = By.name("password");
		loginBtn = By.name("submit");
		fields = By.tagName("input");
	}
	
	public void login(String user,String pass) {
		driver.findElement(userField).sendKeys(user);
		driver.findElement(passwordField).sendKeys(pass);
		driver.findElement(loginBtn).click();
		File myScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(myScreenShot, new File("D:\\Java\\TempFiles\\Screenshots\\LOGIN "+System.currentTimeMillis()+".png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void fieldLogin(String user,String pass) {
		List<WebElement> loginFields = driver.findElements(fields);
		loginFields.get(1).sendKeys(user);
		loginFields.get(2).sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void verifyFields(int cant) {
		List<WebElement> loginFields = driver.findElements(fields);
		System.out.println("La cantidad de campos encontrada es: " + String.valueOf(loginFields.size()));
		Assert.assertTrue(loginFields.size()==cant);
	}
}
