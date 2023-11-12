package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageLoginSuccess {
	private WebDriver driver;
	
	public PageLoginSuccess(WebDriver driver){
		this.driver = driver;
	}
	
	public void assertLoginSuccess() {
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/h3")).getText().contains("Login Successfully"));
	}
}
