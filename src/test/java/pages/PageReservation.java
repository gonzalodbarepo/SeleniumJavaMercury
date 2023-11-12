package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import helpers.*;

public class PageReservation {
	private WebDriver driver;
	
	private By passengersCombo;
	private By departingFromCombo;
	private By departingMonthCombo;
	private By departingDayCombo;
	private By arrivingToCombo;
	private By arrivingMonthCombo;
	private By arrivingDayCombo;
	
	public PageReservation(WebDriver driver){
		this.driver = driver;
		this.passengersCombo = By.name("passCount");
		this.departingFromCombo = By.name("fromPort");
		this.departingMonthCombo = By.name("fromMonth");
		this.departingDayCombo = By.name("fromDay");
		this.arrivingToCombo = By.name("toPort");
		this.arrivingMonthCombo = By.name("toMonth");
		this.arrivingDayCombo = By.name("toDay");
	}
	
	public void assertLogonPage() {
		Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/font")).getText().contains("Use our Flight Finder to search for the lowest fare on participating airlines"));
	}
	
	public void selectPassengers(int cant) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement cantidadPasajeros = (WebElement) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(passengersCombo));
		Select selectPassengers = new Select(cantidadPasajeros);
		selectPassengers.selectByVisibleText(Integer.toString(cant));
	}
	
	public void selectDepartingFrom(int index) {
		Select selectDeparting = new Select(driver.findElement(departingFromCombo));
		selectDeparting.selectByIndex(index);
	}
	
	public void selectArrivingTo(String city) {
		Select selectArriving = new Select(driver.findElement(arrivingToCombo));
		selectArriving.selectByValue(city);
	}
}
