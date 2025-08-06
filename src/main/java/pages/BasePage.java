package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

	protected WebDriver driver;
	protected Waits waits;

	protected BasePage(WebDriver driver) {
		this.driver = driver;
		this.waits = new Waits(driver);
		PageFactory.initElements(driver, this);
	}

	public String getTitle() {
		return driver.getTitle();
	}
	
	public String getTextFromElement(WebElement element) {
		return waits.waitForVisibility(element).getText();
	}
}