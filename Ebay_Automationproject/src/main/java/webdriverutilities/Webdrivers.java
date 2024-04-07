package webdriverutilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdrivers {
	
	/**
	 * To get Url
	 */
	public void GetUrl(WebDriver driver,String URL) {
		driver.get(URL);
	}

	/**
	 * To Maximize the Browser
	 */
	public void MaximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * To Minimize the Browser
	 */
	public void MinimizeBrowser(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * To handle Drop down by index value
	 */
	public void Dropdownbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);

	}

	/**
	 * To handle Drop down by value
	 */
	public void Dropdownbyvalue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}

	/**
	 * To handle Drop down by visible text
	 */
	public void Dropdownbyvisibletext(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	/**
	 * To give Implicitly wait
	 */
	public void Implicitlywait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	/**
	 * To give Explicitly wait
	 */
	public void Explicitlywait(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	/**
	 * To perform Right click action
	 */
	public void Torightclick(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	/**
	 * To perform click and hold
	 */
	public void ClickandHold(WebDriver driver , WebElement element) {
		Actions action = new Actions(driver);
		action.clickAndHold(element).perform();

}
	/**
	 * To use Javascriptorexecutor
	 */
	public void JavaScriptexecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollby(0,200)", "");
	}
	/**
	 * To handle multiple windows
	 */
	public void toSwitchwindowbasedontitle(WebDriver driver,String partial) {
		Set<String> allid = driver.getWindowHandles();
		for(String id : allid) {
			String windowtitle = driver.switchTo().window(id).getTitle();
			if(windowtitle.contains(partial)) {
				break;
			}
		}
		
	}
	
	
}