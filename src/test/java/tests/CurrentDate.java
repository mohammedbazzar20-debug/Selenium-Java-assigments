package tests;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class CurrentDate extends BaseTest {

	private final String baseURL = "https://jqueryui.com/datepicker/";
	private WebDriverWait wait;
	private WebElement frameElement;
	private WebElement dataPickerElement;

	private By dataPicker = By.xpath("//input[@id='datepicker']");
	private By iframe = By.xpath(".//iframe[@class='demo-frame']");

	
	@Test
	public void testDatePicker() throws InterruptedException {
		driver.get(baseURL);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		frameElement = driver.findElement(iframe);
		driver.switchTo().frame(frameElement);

		dataPickerElement = driver.findElement(dataPicker);

		Calendar calender = Calendar.getInstance();

		
//		calender.add(Calendar.DATE, -10);
		
		Date date = calender.getTime();

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = sdf.format(date);

		dataPickerElement.click();
		System.out.println("Click picker date successfully!");
		
		Thread.sleep(3000);

		dataPickerElement.clear();
		
		Thread.sleep(3000);
		dataPickerElement.sendKeys(formattedDate, Keys.TAB);
		
		Thread.sleep(3000);

		String selectedDate = dataPickerElement.getAttribute("value");
		System.out.println("Selected date in input field: " + selectedDate);

	}

}
