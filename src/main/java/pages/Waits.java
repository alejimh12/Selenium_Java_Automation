package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Waits {
    private WebDriver driver;
    private WebDriverWait wait;

    public Waits(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickability(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickWhenReady(WebElement element) {
        waitForClickability(element).click();
    }

    public void sendKeysWhenReady(WebElement element, String text) {
        waitForVisibility(element).clear();
        element.sendKeys(text);
    }

    public boolean isElementVisible(WebElement element) {
        try {
            waitForVisibility(element);
            return element.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}