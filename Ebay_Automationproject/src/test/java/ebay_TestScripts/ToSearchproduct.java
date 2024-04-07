package ebay_TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

import webdriverutilities.Webdrivers;

public class ToSearchproduct {
	// Creating object of the Webdrivers class
	Webdrivers wutil = new Webdrivers();

	@Test
	public void ToSearchProduct() throws InterruptedException {
// To launch Browser
		WebDriver driver = new ChromeDriver();
// To Navigate to the URl
		driver.get("https://www.ebay.com/");
// To maximize the browser
		wutil.MaximizeBrowser(driver);
// To give Wait
		wutil.Implicitlywait(driver);

// To search MacBook in the Search Bar
		driver.findElement(By.id("gh-ac")).sendKeys("MacBook");
		driver.findElement(By.id("gh-cat")).click();
		driver.findElement(By.xpath("//option[@value='58058']")).click();
		driver.findElement(By.id("gh-btn")).click();

// To verify the Searched item with Page content
		if (driver
				.findElement(By.xpath(
						"//span[text()='APPLE MACBOOK PRO 15\" | R9 GFX *HUGE 1TB SSD* 16GB QUAD CORE i7 2.5GHZ']"))
				.getText().contains("MACBOOK")) {
			System.out.println("Passed");
		} else {
			System.out.println("Failed");
		}
		Thread.sleep(7000);
		driver.quit();

	}

}
