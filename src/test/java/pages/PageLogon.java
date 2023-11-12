package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import helpers.*;

public class PageLogon {
	private WebDriver driver;
	
	public PageLogon(WebDriver driver){
		this.driver = driver;
	}
	
	public void assertLogonPage() {
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]")).getText().contains("Welcome back to Mercury Tours"));
	}
}
