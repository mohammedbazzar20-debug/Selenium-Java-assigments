package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
@Test
public class CheckBox extends BaseTest {
	private WebElement checkBoxElement;
	
	private static String baseURL = "https://www.ironspider.ca/forms/checkradio.htm";
	private By checkBox = By.xpath(".//input[@type='checkbox' and @value='orange']");
	
	@Test (priority = 1)
	public void findCheckBoxElement() {
		driver.get(baseURL);
		checkBoxElement = driver.findElement(checkBox);
		System.out.println("Red Checkbox found!");
	}
	
	@Test (priority = 2)
	public void checkBox() throws InterruptedException {
		if(!checkBoxElement.isSelected()) {
			checkBoxElement.click();
		}
		Assert.assertTrue(checkBoxElement.isSelected(),"Check Box should be selected! - Error");
		System.out.println("Checkbox checked correctly!");
		Thread.sleep(4000);
		
	}
	
	@Test (priority = 3)
	public void unCheckBox() throws InterruptedException {
		checkBoxElement.click();
		Assert.assertTrue(!checkBoxElement.isSelected(),"Check Box shouldn't be selected! - Error");
		System.out.println("Checkbox unchecked correctly!");
		Thread.sleep(4000);
	}
}
