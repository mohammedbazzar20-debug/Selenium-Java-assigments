package tests;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import base.BaseTest;

public class Alerts extends BaseTest {
	private WebElement jsBtnElement;
	private WebElement jsConfirmBtnElement;
	private WebElement jsPromptBtnElement;
	
	private final String baseUrl = "https://the-internet.herokuapp.com/javascript_alerts";
	
	private By jsBtn = By.xpath(".//button[contains(text(),'Alert')]");
	private By jsConfirmBtn = By.xpath(".//button[contains(text(),'Confirm')]");
	private By jsPromptBtn = By.xpath(".//button[contains(text(),'Prompt')]");
	private By result = By.xpath("//p[@id=\"result\"]");
	
	

	
	@Test (priority = 1)
	public void testJsPrompt() {
		driver.get(baseUrl);
		jsPromptBtnElement = driver.findElement(jsPromptBtn);
		System.out.println("JS Prompt Button found!");
		
		jsPromptBtnElement.click();
		
		Alert alert = driver.switchTo().alert();
	
		String myName = "Abdullah A. Muhaisen";
		
		alert.sendKeys(myName);
		
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
		
		
		alert.accept();
		System.out.println("Switch and sendKeys succesfully!");
		
		
		WebElement resultE = driver.findElement(result);
		Assert.assertTrue(resultE.getText().contains(myName),"Result test is wrong!");
		System.out.println("Entered string: (" + myName + ") found in result: (" + resultE.getText() + ")");
	}
	
	@Test (priority = 2)
	public void testJsAlert() {
		jsBtnElement = driver.findElement(jsBtn);
		System.out.println("JS Alert Button found!");
		
		jsBtnElement.click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
		
		alert.accept();
		System.out.println("JS Alert Accepted!");
		
		WebElement resultE = driver.findElement(result);
		Assert.assertTrue(resultE.getText().contains("clicked"),"Result test is wrong!");
	}
	
	@Test (priority = 3)
	public void testJsConfirm() {
		jsConfirmBtnElement = driver.findElement(jsConfirmBtn);
		System.out.println("JS Confirm Button found!");
		
		jsConfirmBtnElement.click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		System.out.println("Alert text: " + alertText);
		
		alert.dismiss();
		System.out.println("JS Confirm Cancelled!");
		
		WebElement resultE = driver.findElement(result);
		Assert.assertTrue(resultE.getText().contains("Cancel"),"Result test is wrong!");
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("The browser has been closed!");
		if(driver!=null) {
			driver.quit();
		}
	}
}
