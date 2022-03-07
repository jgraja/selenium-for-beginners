package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest() {
		// Create driver
		System.out.println("Test execution started");
//		System.setProperty("webdriver.chrome.driver", "C:/Practice/SeleniumProject/drivers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		sleep(1000);
		
//		open test page
		String url="https://the-internet.herokuapp.com/login";
		driver.get(url);
		driver.manage().window().maximize();
		System.out.println("Page loaded successfully");
		
		//sleep for 3sec
		sleep(1000);
		
//		enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
//		enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		
//		click login button
		WebElement loginButtion = driver.findElement(By.tagName("button"));
		loginButtion.click();
		
		sleep(1000);
		
//		verification		
//		new url
		String expectedURL = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedURL, "URL are not matching, Expected: "+expectedURL + " Actural url "+ actualUrl );
				
				
//		logout buttion is visible
		WebElement logoutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logoutButton.isDisplayed());
		System.out.println("Login Successfull");
				
		
//		successfull login message
		WebElement successMessage = driver.findElement(By.cssSelector("div#flash"));
		Assert.assertTrue(successMessage.isDisplayed());
		logoutButton.click();
				
//		close browser
		driver.quit();
	}

	private void sleep(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}