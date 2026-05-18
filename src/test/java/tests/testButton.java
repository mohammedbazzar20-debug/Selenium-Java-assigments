package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import base.BaseTest;

public class testButton extends BaseTest {
	private final String baseURL = "https://the-internet.herokuapp.com/dynamic_controls";

	@Test
	public void testBtn() throws InterruptedException {
		driver.get(baseURL);
	    WebElement textField = driver.findElement(By.cssSelector("input[type='text']"));
	    WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
	    enableButton.click();
	    
	    Thread.sleep(5000);
	    
        System.out.println("Is text field enabled? " + textField.isEnabled());
        WebElement disableButton = driver.findElement(By.xpath("//button[text()='Disable']"));
        disableButton.click();
        
        Thread.sleep(5000);
        
        System.out.println("Is text field enabled after disable? " + textField.isEnabled());
	}
}
