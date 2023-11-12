package tests;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.*;
import pages.*;

public class Tests {
	private WebDriver driver;
	ArrayList<String> tabs;
	@BeforeMethod
	public void setUp(){
		DesiredCapabilities caps = new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/newtours/");
		JavascriptExecutor javaExecutor = (JavascriptExecutor)driver;
		String googleWindow = "window.open('https://www.google.com')";
		javaExecutor.executeScript(googleWindow);
		Helpers.sleepSeconds(1);
		tabs = new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0).toString());
		Helpers.sleepSeconds(1);
		driver.switchTo().window(tabs.get(1).toString()).close();
		
	}
	/*
	@Test
	public void pruebaUno() {
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[1]/td/font")).getText().contains("Registered users can"));
	}
	
	
	@Test
	public void pruebaDos() {
		PageLogin pageLogin = new PageLogin(driver);
		PageLoginSuccess pageLoginSuccess = new PageLoginSuccess(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("mercury", "mercury");
		pageLoginSuccess.assertLoginSuccess();
	}
	
	
	@Test
	public void pruebaTres() {
		PageLogin pageLogin = new PageLogin(driver);
		PageLoginSuccess pageLoginSuccess = new PageLoginSuccess(driver);
		PageReservation pageReservation = new PageReservation(driver);
		pageLogin.login("mercury", "mercury");
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		pageReservation.selectPassengers(2);
		pageReservation.selectDepartingFrom(1);
		pageReservation.selectArrivingTo("London");
		Helpers.sleepSeconds(15);
	}
	*/
	
	@Test
	public void cantidadCamposLogin() {
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.verifyFields(5);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(!result.isSuccess()) {
			Helpers.takeScreenshot(driver, "Error");
		}
		driver.close();
	}
	
}
