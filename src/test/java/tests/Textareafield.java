package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class Textareafield extends BaseTest {
	private final String baseURL = "https://omayo.blogspot.com/";

	@Test
     public void testTextAreaField() throws InterruptedException {
    	 navigateToPage(baseURL);
    	 WebElement element = driver.findElement(By.id("ta1"));
    	 element.sendKeys("Selenium");
    	 Thread.sleep(3000);
    	 System.out.println("Text area field success!");
     }
	
	@Test
	public void testReadingText() {
		driver.get(baseURL);
		WebElement element = driver.findElement(By.id("but1"));
		String text = element.getText();
		System.out.println(text);
	}
}
