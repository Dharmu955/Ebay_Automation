package ebay_TestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import webdriverutilities.Webdrivers;

public class ToApplyMultipleFilters {
//To Create object of the Webdrivers class

	Webdrivers wutil = new Webdrivers();

	@Test

	public void ToApplyFilters() throws InterruptedException {
// To launch the browser
		WebDriver driver = new ChromeDriver();
//To navigate to the URL
		driver.get("https://www.ebay.com/");
//To maximize the Browser
		wutil.MaximizeBrowser(driver);
//To give wait
		wutil.Implicitlywait(driver);

//To Apply multiple Filters

		driver.findElement(By.id("gh-shop-ei")).click();
		driver.findElement(By.linkText("Cell phones & accessories")).click();
		driver.findElement(By.linkText("Cell Phones & Smartphones")).click();
		driver.findElement(By.xpath("//button[text()='All Filters']")).click();
		driver.findElement(By.id("c3-mainPanel-condition")).click();
		driver.findElement(By.id("c3-subPanel-LH_ItemCondition_New_cbx")).click();
		driver.findElement(By.id("c3-subPanel-LH_ItemCondition_Very%20Good%20-%20Refurbished_cbx")).click();
		driver.findElement(By.id("c3-mainPanel-price")).click();
		driver.findElement(By.xpath("//input[@aria-label='Minimum Value, US Dollar']")).sendKeys("100");
		driver.findElement(By.xpath("//input[@aria-label='Maximum Value, US Dollar']")).sendKeys("500");
		driver.findElement(By.id("c3-mainPanel-location")).click();
		driver.findElement(By.xpath("//input[@value='Worldwide']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Apply']")).click();
		driver.findElement(By.xpath("//span[text()='4 filters applied']")).click();

		// Verifying the filtered applied

		String Filtered = driver.findElement(By.xpath("(//ul[@class='brm__aspect-list'])[1]")).getText();
		System.out.println(Filtered);
		Thread.sleep(10000);
		driver.quit();

	}

}
